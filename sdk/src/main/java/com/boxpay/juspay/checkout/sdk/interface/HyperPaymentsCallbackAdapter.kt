package com.boxpay.juspay.checkout.sdk.`interface`

import org.json.JSONObject


interface HyperPaymentsCallbackAdapter {
    fun onEvent(jsonObject: JSONObject)
}