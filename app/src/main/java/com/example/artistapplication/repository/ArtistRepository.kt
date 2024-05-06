package com.example.artistapplication.repository

import com.example.artistapplication.network.ArtistApiService
import javax.inject.Inject

class ArtistRepository @Inject constructor(private val service : ArtistApiService){
    suspend fun getAllCharacters () = service.getAllList()
}