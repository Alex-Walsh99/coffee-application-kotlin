package com.example.wmadcoffeeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class AccountDetailsActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences

    private lateinit var editor: SharedPreferences.Editor

    companion object{
        val TAG = "onCreate"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_details)

        val btnSave: Button = findViewById(R.id.btnSave)
        val txtForenameIn: TextView = findViewById(R.id.txtForenameIn)
        val txtSurnameIn: TextView = findViewById(R.id.txtSurnameIn)

        prefs = getSharedPreferences("com.example.share.preferences", Context.MODE_PRIVATE)

        editor = prefs.edit()

        txtForenameIn.text = "${prefs.getString("forename", "")}"
        txtSurnameIn.text = "${prefs.getString("surname", "")}"

        Log.d(TAG, "The set name is ${prefs.getString("forename", "")} ${prefs.getString("surname", "")}")
        btnSave.setOnClickListener{
            editor.putString("forename", txtForenameIn.text.toString())
            editor.putString("surname", txtSurnameIn.text.toString())
            editor.apply()

            val saveIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(saveIntent)
        }
    }
}