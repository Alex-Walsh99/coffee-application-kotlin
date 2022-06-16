package com.example.wmadcoffeeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class OrderActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    companion object{
        val TAG = "onCreate"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val editTextLatte: TextView = findViewById(R.id.editTextLatte);
        val editTextEspresso: TextView = findViewById(R.id.editTextEspresso);
        val editTextMocha: TextView = findViewById(R.id.editTextMocca);
        val editTextAmericano: TextView = findViewById(R.id.editTextAmericano);

        val editTextForename: TextView = findViewById(R.id.editTextForename);
        val editTextSurname: TextView = findViewById(R.id.editTextSurname);
        val editTextTelephone: TextView = findViewById(R.id.editTextTelephone);
        val editTextAddress: TextView = findViewById(R.id.editTextAddress);
        val editPostcode: TextView = findViewById(R.id.editPostcode);

        val btnNext: Button = findViewById(R.id.btnNext)


        prefs = getSharedPreferences("com.example.share.preferences", Context.MODE_PRIVATE)
        editor = prefs.edit()

        editTextForename.text = "${prefs.getString("forename", "")}"
        editTextSurname.text = "${prefs.getString("surname", "")}"
        Log.d(AccountDetailsActivity.TAG, "The set name is ${prefs.getString("forename", "")} ${prefs.getString("surname", "")}")

        btnNext.setOnClickListener {

            val latte = if(editTextLatte.text.isNullOrEmpty()) "0"
                else editTextLatte.text.toString();
            val espresso = if(editTextEspresso.text.isNullOrEmpty()) "0"
            else editTextEspresso.text.toString();
            val mocha = if(editTextMocha.text.isNullOrEmpty()) "0"
            else editTextMocha.text.toString();
            val americano = if(editTextAmericano.text.isNullOrEmpty()) "0"
            else editTextAmericano.text.toString();

            val forename = if(editTextForename.text.isNullOrEmpty()) ""
            else editTextForename.text.toString();
            val surname = if(editTextSurname.text.isNullOrEmpty()) ""
            else editTextSurname.text.toString();
            val telephone = if(editTextTelephone.text.isNullOrEmpty()) ""
            else editTextTelephone.text.toString();
            val address = if(editTextAddress.text.isNullOrEmpty()) ""
            else editTextAddress.text.toString();
            val postcode = if(editPostcode.text.isNullOrEmpty()) ""
            else editPostcode.text.toString();

            var isQuantitySubmitted = false;

            if(!editTextLatte.text.isNullOrEmpty())
                isQuantitySubmitted = true;
            if(!editTextMocha.text.isNullOrEmpty())
                isQuantitySubmitted = true;
            if(!editTextEspresso.text.isNullOrEmpty())
                isQuantitySubmitted = true;
            if(!editTextAmericano.text.isNullOrEmpty())
                isQuantitySubmitted = true;


            if(isQuantitySubmitted) {
                run {
                    val orderDetailsIntent: Intent =
                        Intent(this, OrderDetailsActivity::class.java).apply {
                            putExtra("LATTE", latte)
                            putExtra("ESPRESSO", espresso)
                            putExtra("MOCHA", mocha)
                            putExtra("AMERICANO", americano)

                            putExtra("FORENAME", forename)
                            putExtra("SURNAME", surname)
                            putExtra("TELEPHONE", telephone)
                            putExtra("ADDRESS", address)
                            putExtra("POSTCODE", postcode)
                        }
                    startActivity(orderDetailsIntent)
                }
            }else{
                Toast.makeText(this, "Please enter a quantity of drink", Toast.LENGTH_SHORT).show()
            }
        }
    }
}