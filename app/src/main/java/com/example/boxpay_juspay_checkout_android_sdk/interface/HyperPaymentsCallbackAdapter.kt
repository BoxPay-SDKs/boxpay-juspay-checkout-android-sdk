package com.example.boxpay_juspay_checkout_android_sdk.`interface`

import org.json.JSONObject


interface HyperPaymentsCallbackAdapter {
    fun onEvent(jsonObject: JSONObject)
}