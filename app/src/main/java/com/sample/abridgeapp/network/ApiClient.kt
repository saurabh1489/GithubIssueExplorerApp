package com.sample.abridgeapp.network

import com.sample.abridgeapp.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.github.com/"

class ApiClient {

    companion object {
        fun getClient(): GithubService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(GithubService::class.java)
        }
    }

}