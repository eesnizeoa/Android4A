package com.example.android4a.injection

import android.content.SharedPreferences
import com.example.android4a.data.repository.Pokemon
import com.example.android4a.data.repository.RestPokemonResponse
import com.example.android4a.presentation.main.PokemonMainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.pokemon_activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainController(pokemonMainActivity: PokemonMainActivity, gson: Gson?, sharedPreferences: SharedPreferences?){
    private val sharedPreferences: SharedPreferences? = sharedPreferences
    private val gson: Gson? = gson
    private val view: PokemonMainActivity = pokemonMainActivity

    fun onStart() {
        val pokemonList: MutableList<Pokemon>? = dataFromCache
        if (pokemonList != null) {
            view.showList(pokemonList)
        } else {
            makeApiCall()
        }
    }

    private fun makeApiCall() {
        val call: Call<RestPokemonResponse?>? = Singletons.pokeApi?.getPokemonResponse()
        if(call != null) {
            call.enqueue(object : Callback<RestPokemonResponse?> {
                override fun onResponse(
                    call: Call<RestPokemonResponse?>?,
                    response: Response<RestPokemonResponse?>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        view.recycler_view.apply{
                            val pokemonList: MutableList<Pokemon>? = response.body()!!.results
                            if (pokemonList != null) {
                                saveList(pokemonList)
                            }
                            view.showList(pokemonList)}

                    } else {
                        view.showError()
                    }
                }

                override fun onFailure(call: Call<RestPokemonResponse?>?, t: Throwable?) {
                    view.showError()
                }
            })
        }
    }

    private fun saveList(pokemonList: MutableList<Pokemon>) {
        val jsonString: String? = gson?.toJson(pokemonList)
        sharedPreferences
            ?.edit()
            ?.putString(Constants.KEY_POKEMON_LIST, jsonString)
            ?.apply()
    }

    private val dataFromCache: MutableList<Pokemon>?
        private get() {
            val jsonPokemon = sharedPreferences?.getString(Constants.KEY_POKEMON_LIST, null)
            return if (jsonPokemon == null) {
                null
            } else {
                val listType = genericType<MutableList<Pokemon>>()
                gson!!.fromJson(jsonPokemon, listType)
            }
        }
    private inline fun <reified T> genericType() = object: TypeToken<T>() {}.type

    fun onItemClick(pokemon: Pokemon?) {
        view.navigateToDetails(pokemon)
    }

}