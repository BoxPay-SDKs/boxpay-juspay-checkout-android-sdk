package com.boxpay.juspay.demoApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boxpay.juspay.demoapp.databinding.ActivityMainBinding

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
                val amount = binding.amountEditText.text.toString()
                val fromTrainStation = binding.fromTrainStation.text.toString()
                val toTrainStation = binding.toTrainStation.text.toString()
                val trainNumberName = binding.trainNameNumber.text.toString()

                val bundle = Bundle()
                bundle.putString("amount", amount.ifEmpty { null })
                bundle.putString("from", fromTrainStation.ifEmpty { null })
                bundle.putString("to", toTrainStation.ifEmpty { null })
                bundle.putString("train", trainNumberName.ifEmpty { null })
                intent = Intent(
                    this,
                    Check::class.java
                )
                intent.putExtras(bundle)
                startActivity(intent)
            } catch (e: ClassNotFoundException) {

            }
        }
    }
}

