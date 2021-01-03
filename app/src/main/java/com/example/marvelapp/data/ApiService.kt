package com.example.marvelapp.data

import com.example.marvelapp.BASE_URL
import com.example.marvelapp.data.model.MarvelCharacterNetworkModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("characters")
    fun getCharacterList(
        @Query("ts") timeStamp: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
    ): Call<List<MarvelCharacterNetworkModel>>

    @GET("characters")
    fun getCharacterListSimple(): Call<List<MarvelCharacterNetworkModel>>

    @GET("characters/{characterId}")
    fun getCharacter(
        @Query("ts") timeStamp: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Path("characterId") id: Int
    ): Call<MarvelCharacterNetworkModel>

    companion object {

        fun create(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}