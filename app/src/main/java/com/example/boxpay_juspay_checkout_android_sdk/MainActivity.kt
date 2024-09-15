package com.example.boxpay_juspay_checkout_android_sdk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.boxpay_juspay_checkout_android_sdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val sharedPrefs = getSharedPreferences("TransactionDetails", Context.MODE_PRIVATE).edit()
        sharedPrefs.clear()
        sharedPrefs.apply()


        binding.openByDefault.setOnClickListener {
            //        var intent: Intent? = null
            try {
                intent = Intent(
                    this,
                    Check::class.java
                )
                startActivity(intent)
            } catch (e: ClassNotFoundException) {

            }
        }
    }
}

