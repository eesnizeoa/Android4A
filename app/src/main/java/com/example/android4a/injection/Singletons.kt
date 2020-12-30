package com.example.android4a.injection

import android.content.Context
import android.content.SharedPreferences
import com.example.android4a.data.remote.PokeApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Singletons {
    var gsonInstance: Gson? = null
    var pokeApiInstance: PokeApi? = null
    var sharedPreferencesInstance: SharedPreferences? = null
    val gson: Gson?
        get() {
            if (gsonInstance == null) {
                gsonInstance = GsonBuilder()
                    .setLenient()
                    .create()
            }
            return gsonInstance
        }

    val pokeApi: PokeApi?
        get() {
            if (pokeApiInstance == null) {
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                pokeApiInstance = retrofit.create(PokeApi::class.java)
            }
            return pokeApiInstance
        }

    fun getSharedPreferencesInstance(context: Context): SharedPreferences? {
        if (sharedPreferencesInstance == null) {
            sharedPreferencesInstance = context.getSharedPreferences(
                "application_esiea",
                Context.MODE_PRIVATE
            )
        }
        return sharedPreferencesInstance
    }
}
