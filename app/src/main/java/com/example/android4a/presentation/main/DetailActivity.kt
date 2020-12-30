package com.example.android4a.presentation.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import com.example.android4a.data.repository.Pokemon
import com.example.android4a.injection.Singletons

class DetailActivity : AppCompatActivity() {
    private var txtDetail: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        txtDetail = findViewById(R.id.detail_txt)
        val intent = intent
        val pokemonJson = intent.getStringExtra("pokemonKey")
        val pokemon: Pokemon? = Singletons.gsonInstance?.fromJson(pokemonJson, Pokemon::class.java)
        if (pokemon != null) {
            showDetail(pokemon)
        }
    }

    private fun showDetail(pokemon: Pokemon) {
        txtDetail?.setText(pokemon.name.toString() + "\n" + pokemon.url)
    }
}
