package com.example.android4a.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.repository.Pokemon
import com.example.android4a.injection.MainController
import com.example.android4a.injection.Singletons

class PokemonMainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var mAdapter: ListAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var controller: MainController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_activity_main)
        controller = MainController(
            this,
            Singletons.gsonInstance,
            Singletons.sharedPreferencesInstance
        )
        controller!!.onStart()
    }

    fun showList(pokemonList: MutableList<Pokemon>?) {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView!!.setHasFixedSize(true)
        // use a linear layout manager
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.setOnClickListener { }

        // define an adapter
        mAdapter = ListAdapter((pokemonList)!!, object : ListAdapter.OnItemClickListener {
            override fun onItemClick(item: Pokemon?) {
                controller?.onItemClick(item)
            }
        })
        recyclerView!!.adapter = mAdapter
    }

    fun showError() {
        Toast.makeText(applicationContext, "Api Error", Toast.LENGTH_SHORT).show()
    }

    fun navigateToDetails(pokemon: Pokemon?) {
        val myIntent = Intent(this, DetailActivity::class.java)
        myIntent.putExtra("pokemonKey", Singletons.gsonInstance?.toJson(pokemon))
        this.startActivity(myIntent)
    }
}