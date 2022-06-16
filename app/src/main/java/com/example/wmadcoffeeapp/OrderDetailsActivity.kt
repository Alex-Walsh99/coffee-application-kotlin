package com.example.wmadcoffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OrderDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val txtLatteQuantity: TextView = findViewById(R.id.txtLatteQuantity)
        val txtEspressoQuantity: TextView = findViewById(R.id.txtEspressoQuantity)
        val txtMochaQuantity: TextView = findViewById(R.id.txtMochaQuantity)
        val txtAmericanoQuantity: TextView = findViewById(R.id.txtAmericanoQuantity)

        val txtHeaderOrderDetails: TextView = findViewById(R.id.txtHeaderOrderDetails)

        val btnNext: Button = findViewById(R.id.btnNext)

        txtLatteQuantity.text = "${intent?.extras?.getString("LATTE")}"
        txtEspressoQuantity.text = "${intent?.extras?.getString("ESPRESSO")}"
        txtMochaQuantity.text = "${intent?.extras?.getString("MOCHA")}"
        txtAmericanoQuantity.text = "${intent?.extras?.getString("AMERICANO")}"

        txtHeaderOrderDetails.text = "${intent?.extras?.getString("FORENAME")} ${intent?.extras?.getString("SURNAME")}'s Order"
        btnNext.setOnClickListener {
            val homeIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
        }
    }
}