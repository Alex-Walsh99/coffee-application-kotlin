package com.example.wmadcoffeeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    private lateinit var editor: SharedPreferences.Editor

    companion object{
        val TAG = "onCreate"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtWelcome: TextView = findViewById(R.id.txtWelcome)
        val btnOrder: Button = findViewById(R.id.btnOrder)
        val btnAccountDetails: Button = findViewById(R.id.btnLogin)
        val btnCoffee: Button = findViewById(R.id.btnMenu)

        prefs = getSharedPreferences("com.example.share.preferences", Context.MODE_PRIVATE)
        editor = prefs.edit()

        if(prefs.getString("forename", "") != "" && prefs.getString("surname", "") != "")
            txtWelcome.text = "Welcome, ${prefs.getString("forename", "")} ${prefs.getString("surname", "")}!"

        btnOrder.setOnClickListener {
            val orderIntent: Intent = Intent(this, OrderActivity::class.java)
            startActivity(orderIntent)
        }

        btnAccountDetails.setOnClickListener {
            val accountDetailsIntent: Intent = Intent(this, AccountDetailsActivity::class.java)
            startActivity(accountDetailsIntent)
        }

        btnCoffee.setOnClickListener {
            val coffeeMenuIntent: Intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(coffeeMenuIntent)
        }
    }
}