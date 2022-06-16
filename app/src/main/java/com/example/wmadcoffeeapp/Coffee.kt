package com.example.wmadcoffeeapp

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

class Coffee (
    val title: String = "",
    val description: String = "",
    val image: String = "") : Serializable {
        companion object{
            fun getCoffees(filename: String, context: Context): ArrayList<Coffee> {
                val coffeeList = ArrayList<Coffee>()

                try{
                    val inputStream = context.assets.open(filename)
                    val buffer = ByteArray(inputStream.available())
                    inputStream.read(buffer)
                    inputStream.close()

                    val json = JSONObject(String(buffer, Charsets.UTF_8))
                    val coffees = json.getJSONArray("coffees")

                    for(i in 0 until coffees.length())
                        coffeeList.add(Coffee(
                            coffees.getJSONObject(i).getString("title"),
                            coffees.getJSONObject(i).getString("description"),
                            coffees.getJSONObject(i).getString("image")
                        ))
                }
                catch(e: JSONException){
                    e.printStackTrace()
                }
                return coffeeList
            }
        }
    }