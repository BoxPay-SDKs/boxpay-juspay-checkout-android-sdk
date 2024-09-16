package com.example.boxpay_juspay_checkout_android_sdk

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.boxpay.checkout.sdk.BoxPayOrderCheckout
import com.boxpay.checkout.sdk.BuildConfig
import com.boxpay.checkout.sdk.paymentResult.PaymentResultObject
import com.example.boxpay_juspay_checkout_android_sdk.`interface`.HyperPaymentsCallbackAdapter
import org.json.JSONObject

class HyperServiceHolder(private val context: Context) {

    private var callback: HyperPaymentsCallbackAdapter? = null
    private lateinit var checkout: BoxPayOrderCheckout
    private var testEnv: Boolean = false

    // Method to set the callback
    fun setCallback(callback: HyperPaymentsCallbackAdapter) {
        this.callback = callback
    }

    fun setBoxPayTextEnv(test: Boolean) {
        this.testEnv = test
    }

    private fun handlePaymentResult(paymentResult: PaymentResultObject) {
        val status = when(paymentResult.status?.lowercase()) {
            "success" -> "charged"
            "rejected"-> "authorization_failed"
            "requiresaction" -> "authentication_failed"
            "failed" -> "api_failure"
            "processing"-> "pending_vbv"
            else -> {
                "new"
            }
        }
        callback?.onEvent(JSONObject().apply {
            put("event", "process_result")
            put("payload", JSONObject().apply {
                put("status", status)
                put("error", paymentResult.status.equals("rejected", true) || paymentResult.status.equals("failed", true) )
                // Add other fields as needed
            })
        })
    }

    fun process(jsonObject: JSONObject, sandbox: Boolean = false) {
        val orderDetailsString = jsonObject.getString("orderDetails")
        val orderDetails = JSONObject(orderDetailsString)
        val amount = orderDetails.getString("amount")
        orderDetails.put("mandate.max_amount", amount)
        orderDetails.put("options.create_mandate", "REQUIRED")
        orderDetails.put("mandate.frequency", "ASPRESENTED")
        val queue = Volley.newRequestQueue(context)
        val url = "https://sandbox-apis.boxpay.tech/v0/juspay/checkout/sessions"

        val request = object : JsonObjectRequest(
            Method.POST, url, orderDetails,
            { response ->
                val token = response.getString("id") ?: ""
                checkout = BoxPayOrderCheckout(
                    context, token, ::handlePaymentResult, sandbox, jsonObject
                )
                if (this.testEnv) {
                    checkout.testEnv = true
                }
                checkout.display()
                // Call a function that depends on the token
            },
            Response.ErrorListener { /* no response handling */ }) {
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["X-Client-Connector-Name"] = "Android SDK"
                headers["X-Client-Connector-Version"] = BuildConfig.SDK_VERSION
                return headers
            }
        }
        queue.add(request)
    }
}
