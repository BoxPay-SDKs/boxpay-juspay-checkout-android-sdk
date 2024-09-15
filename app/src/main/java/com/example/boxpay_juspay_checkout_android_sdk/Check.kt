package com.example.boxpay_juspay_checkout_android_sdk

import com.example.boxpay_juspay_checkout_android_sdk.`interface`.HyperPaymentsCallbackAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.boxpay_juspay_checkout_android_sdk.databinding.ActivityCheckBinding
import org.json.JSONObject

class Check : AppCompatActivity() {
    private var successScreenFullReferencePath: String? = null
    private lateinit var hyperServiceHolder: HyperServiceHolder


    private val binding: ActivityCheckBinding by lazy {
        ActivityCheckBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView6.text = "Generating Token Please wait..."
        hyperServiceHolder = HyperServiceHolder(this)
        hyperServiceHolder.setCallback(createHyperPaymentsCallbackAdapter())
        successScreenFullReferencePath = "com.example.AndroidCheckOutSDK.SuccessScreen"


        showBottomSheetWithOverlay()
    }

    private fun showBottomSheetWithOverlay() {
        val orderJson = JSONObject(
            """
                {
    "action": "paymentPage",
    "merchantId": "lGfqzNSKKA_phonepe",
    "clientId": "railyatripp",
    "orderId": "1725133659jpp1988719986",
    "amount": "2304",
    "toolbarSecondLine": "NZM - BDTS | 2024-08-21",
    "customerId": "cth_udBM2B34PMgSZXjX",
    "customerEmail": "avinash.singh@railyatri.in",
    "customerMobile": "9555681381",
    "orderDetails": "{\"metadata.webhook_url\":\"https:\\/\\/payment-test.railyatri.in\\/api\\/juspay\\/update-payment\",\"udf1\":\"30313407\",\"udf2\":\"4\",\"return_url\":\"https:\\/\\/payment-test.railyatri.in\\/payment\\/juspay\\/process\",\"order_id\":\"1725133659jpp1988719986\",\"merchant_id\":\"lGfqzNSKKA_phonepe\",\"amount\":\"2304.0\",\"timestamp\":\"1725133662\",\"customer_id\":\"cth_udBM2B34PMgSZXjX\",\"currency\":\"INR\",\"customer_email\":\"avinash.singh@railyatri.in\",\"customer_phone\":\"9555681381\",\"metadata.merchant_container_list\":\"[{\\\"payment_method\\\":\\\"RY_CASH\\\",\\\"payment_method_type\\\":\\\"MERCHANT_CONTAINER\\\",\\\"display_name\\\":\\\"RYCASH\\\",\\\"eligible_amount\\\":10,\\\"balance_amount\\\":400,\\\"walletIconURL\\\":\\\"https:\\/\\/cdn-icons-png.flaticon.com\\/512\\/216\\/216490.png\\\"},{\\\"payment_method\\\":\\\"RY_CASH_PLUS\\\",\\\"payment_method_type\\\":\\\"MERCHANT_CONTAINER\\\",\\\"display_name\\\":\\\"RYCASHPLUS\\\",\\\"eligible_amount\\\":400,\\\"balance_amount\\\":400,\\\"walletIconURL\\\":\\\"https:\\/\\/cdn-icons-png.flaticon.com\\/512\\/216\\/216490.png\\\"}]\"}",
    "product_summary": "[[{\"type\":\"text\",\"text\":\"Updated Status:\",\"textSize\":14,\"color\":\"#000000\"},{\"type\":\"text\",\"text\":\"50 WAITLIST\",\"textSize\":16,\"fontType\":\"Bold\",\"color\":\"#00B829\"},{\"type\":\"linegap\",\"gap\":0}],[{\"type\":\"linegap\",\"gap\":4},{\"type\":\"text\",\"text\":\"High confirmation chance tickets are likely to get confirmed!\",\"textSize\":12,\"color\":\"#333333\"}],[{\"type\":\"divider\",\"thickness\":1,\"color\":\"#F0F7FD\"}],[{\"type\":\"text\",\"text\":\"Review Ticket\",\"textSize\":15,\"fontType\":\"Bold\",\"color\":\"#000000\"},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"text\",\"text\":\"Booking ID: 30313407\",\"textSize\":11,\"fontType\":\"SemiBold\",\"color\":\"#333333\"}],[{\"type\":\"divider\",\"thickness\":2,\"color\":\"#ffffff\"}],[{\"type\":\"divider\",\"thickness\":1,\"color\":\"#F0F7FD\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"linegap\",\"gap\":0},{\"type\":\"text\",\"text\":\"12910 - Garib Rath Express\",\"textSize\":14,\"fontType\":\"Bold\",\"color\":\"#333333\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"linegap\",\"gap\":4},{\"type\":\"text\",\"text\":\"2 Travellers| Class- 3A| Quota- GN\",\"textSize\":9,\"fontType\":\"Bold\",\"color\":\"#333333\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"linegap\",\"gap\":4},{\"type\":\"text\",\"text\":\"Saturday, 30 Sep\",\"textSize\":10,\"color\":\"#333333\"},{\"type\":\"space\",\"width\":50,\"weight\":1},{\"type\":\"text\",\"text\":\"Saturday, 30 Sep\",\"textSize\":10,\"color\":\"#333333\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"linegap\",\"gap\":0},{\"type\":\"text\",\"text\":\"NZM , 16:30\",\"textSize\":18,\"fontType\":\"Bold\",\"color\":\"#333333\"},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"image\",\"url\":\"https://images.railyatri.in/ry_images_prod/train-icon-1715841210.png\",\"size\":30},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"text\",\"text\":\"09:15, BDTS\",\"textSize\":18,\"fontType\":\"Bold\",\"color\":\"#333333\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"linegap\",\"gap\":0},{\"type\":\"text\",\"text\":\"DELHI HAZRAT NIZAMUDDIN\",\"textSize\":10,\"color\":\"#333333\"},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"text\",\"text\":\"---- 16:45 h ----\",\"textSize\":10,\"color\":\"#888888\"},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"text\",\"text\":\" MUMBAI BANDRA TERMINUS\",\"textSize\":10,\"color\":\"#333333\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"divider\",\"thickness\":1,\"color\":\"#F0F7FD\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"accordion\",\"limit\":1,\"content\":[[{\"type\":\"text\",\"text\":\"Passenger Details & Fare Breakup\",\"textSize\":15,\"fontType\":\"Bold\",\"color\":\"#333333\"},{\"type\":\"space\",\"width\":10,\"weight\":1},{\"type\":\"toggleImage\",\"openIcon\":\"https://assets.juspay.in/hyper/images/internalPP/ic_arrow_down.png\",\"closeIcon\":\"https://assets.juspay.in/hyper/images/internalPP/ic_arrow_up.png\",\"size\":20}],[{\"type\":\"text\",\"text\":\"1. Test (Male)\",\"textSize\":14,\"color\":\"#333333\"},{\"type\":\"text\",\"text\":\"25 \",\"textSize\":12,\"color\":\"#888888\"},{\"type\":\"text\",\"text\":\"| Lower Berth | \",\"textSize\":12,\"color\":\"#333333\"},{\"type\":\"text\",\"text\":\"2. Test (Male)\",\"textSize\":14,\"color\":\"#333333\"},{\"type\":\"text\",\"text\":\"30 \",\"textSize\":12,\"color\":\"#888888\"},{\"type\":\"text\",\"text\":\"| Lower Berth | \",\"textSize\":12,\"color\":\"#333333\"}],[{\"type\":\"divider\",\"thickness\":1,\"color\":\"#E5E5E5\"}],[{\"type\":\"text\",\"text\":\"Fare Breakup\",\"textSize\":14,\"fontType\":\"Bold\",\"color\":\"#000000\"},{\"type\":\"space\",\"width\":10,\"weight\":1}],[{\"type\":\"text\",\"text\":\"Ticket Base Fare\",\"textSize\":12,\"color\":\"#333333\"},{\"type\":\"space\",\"width\":50,\"weight\":1},{\"type\":\"text\",\"text\":\"₹2180.0\",\"textSize\":12,\"color\":\"#333333\"}],[{\"type\":\"text\",\"text\":\"Agent Service Charge\",\"textSize\":12,\"color\":\"#333333\"},{\"type\":\"space\",\"width\":50,\"weight\":1},{\"type\":\"text\",\"text\":\"₹40.0\",\"textSize\":12,\"color\":\"#333333\"}],[{\"type\":\"text\",\"text\":\"IRCTC Conv. Fee\",\"textSize\":12,\"color\":\"#333333\"},{\"type\":\"space\",\"width\":50,\"weight\":1},{\"type\":\"text\",\"text\":\"₹35.4\",\"textSize\":12,\"color\":\"#333333\"}],[{\"type\":\"text\",\"text\":\"Net Amount payable\",\"textSize\":14,\"fontType\":\"Bold\",\"color\":\"#000000\"},{\"type\":\"space\",\"width\":50,\"weight\":1},{\"type\":\"text\",\"text\":\"₹2304\",\"textSize\":14,\"fontType\":\"Bold\",\"color\":\"#000000\"},{\"type\":\"background\",\"color\":\"#F0F7FD\"}],[{\"type\":\"space\",\"width\":1,\"weight\":2}]]}]]",
    "signature": "aSUaLK6cvlPgMptvU7QqF+Asdg4p5+ZuYekFCriW98ijgsXNrYwWG19aQEwOJ3lhZFGmGdcUR9jV27fVdGktzH2N0eAO88yxMp/tmopbEbObJOypXdvPtlRUW6FNS0YAfz6RYWZJ7DB0ZNciuQ83Zei8s7d4UzPB41kKy4lwi9DqtQHAQOQUl9eSEqhY80VAcAd40X0/Tuf2p8X4/vhi6r0oaie1w2acJWCnxOrErLk3Z2W1vuw2B28aurBEQPS9qDOhn9Q49DSwIwg7nAP1XkE2szh1ybvcrUpRzDgdNU7ozLxSAyVpEyH15C9rNYsIuxEyiZbHFk9dr0gLbPqlPw==",
    "merchantKeyId": "13031",
    "language": "English"
}
               """
        )
        hyperServiceHolder.setBoxPayTextEnv(true)
        hyperServiceHolder.process(orderJson, false)
    }


    private fun createHyperPaymentsCallbackAdapter(): HyperPaymentsCallbackAdapter {
        return object : HyperPaymentsCallbackAdapter {
            override fun onEvent(jsonObject: JSONObject) {
                try {
                    val event = jsonObject.getString("event")
                    if (event == "hide_loader") {
                        // Hide Loader
                    } else if (event == "process_result") {
                        val error = jsonObject.optBoolean("error")
                        val innerPayload = jsonObject.optJSONObject("payload")
                        val status = innerPayload.optString("status")
//                        val redirect = Intent(context, ResponsePage::class.java)
                        Toast.makeText(
                            this@Check,
                            "Status : $status , Error : $error",
                            Toast.LENGTH_SHORT
                        ).show()

                        if (!error) {
                            when (status) {
                                "charged" -> {
//                                    redirect.putExtra("status", "OrderSuccess")
//                                    context.startActivity(redirect)
                                }

                                else -> {

                                }
                            }
                        } else {
                            when (status) {
                                "backpressed" -> {

                                }

                                "user_aborted" -> {
//                                    redirect.putExtra("status", "UserAborted")
//                                    context.startActivity(redirect)
                                }

                                "pending_vbv" -> {
//                                    redirect.putExtra("status", "PendingVBV")
//                                    context.startActivity(redirect)
                                }

                                "authorizing" -> {
//                                    redirect.putExtra("status", "Authorizing")
//                                    context.startActivity(redirect)
                                }

                                "authorization_failed" -> {
//                                    redirect.putExtra("status", "AuthorizationFailed")
//                                    context.startActivity(redirect)
                                }

                                "authentication_failed" -> {
//                                    redirect.putExtra("status", "AuthenticationFailed")
//                                    context.startActivity(redirect)
                                }

                                "api_failure" -> {
//                                    redirect.putExtra("status", "APIFailure")
//                                    context.startActivity(redirect)
                                }

                                else -> {
//                                    redirect.putExtra("status", "APIFailure")
//                                    context.startActivity(redirect)
                                }
                            }
                        }
                    }
                } catch (e: Exception) {

                }
            }
        }
    }
}