package com.mahendra.licius.network

import com.mahendra.licius.model.RetroProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RestApi {

    @GET("favorites")
    fun getProductItems() : Call<RetroProductResponse>

}