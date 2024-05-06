package com.example.artistapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.artistapplication.model.CharacterResponseModel
import com.example.artistapplication.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : ArtistViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchArtistCharacter()

        viewModel.artistLivedata.observe(this){
            Log.i("Data_Artist", it.toString())


           // Log.i("Data_Artist", it.data?.results?.get(0)?.name.toString())

        }
    }
}