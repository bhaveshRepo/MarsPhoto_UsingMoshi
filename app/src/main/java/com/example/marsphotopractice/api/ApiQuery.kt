package com.example.marsphotopractice.api

import com.example.marsphotopractice.model.MarsPhoto
import retrofit2.http.GET

interface ApiQuery {

    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>

}