package com.example.android4a.data.remote

import com.example.android4a.data.repository.RestPokemonResponse
import retrofit2.Call
import retrofit2.http.GET

public interface PokeApi {
    @GET("/api/v2/pokemon")
    fun getPokemonResponse(): Call<RestPokemonResponse?>?
}