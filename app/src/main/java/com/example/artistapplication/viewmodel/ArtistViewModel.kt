package com.example.artistapplication.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artistapplication.repository.ArtistRepository
import com.example.artistapplication.model.CharacterResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(private val artistRepository: ArtistRepository) : ViewModel(){

    val artistLivedata = MutableLiveData<CharacterResponseModel>()
    val errorLiveData = MutableLiveData<String>()


    @SuppressLint("SuspiciousIndentation")
    fun fetchArtistCharacter(){
        viewModelScope.launch (Dispatchers.IO){
            val response = artistRepository.getAllCharacters()

                  if (response.isSuccessful){

                      artistLivedata.postValue(response.body())


                   }
                  else {
                      errorLiveData.postValue(response.errorBody().toString())
                      Log.i("Data_Artist", response.errorBody().toString())
                       }

        }
    }
}