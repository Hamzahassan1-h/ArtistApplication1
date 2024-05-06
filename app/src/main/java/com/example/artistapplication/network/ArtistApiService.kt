package com.example.artistapplication.network

import com.example.artistapplication.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET

interface ArtistApiService {

    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    suspend fun getAllList(): Response<ResultModel>
}