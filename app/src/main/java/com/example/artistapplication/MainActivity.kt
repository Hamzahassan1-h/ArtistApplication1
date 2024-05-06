package com.example.artistapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.artistapplication.databinding.ActivityMainBinding
import com.example.artistapplication.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : ArtistViewModel by viewModels()
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchArtistCharacter()

        viewModel.artistLivedata.observe(this){
            Log.i("Data_Artist", it.toString())
            binding.test.text = it.toString()


           // Log.i("Data_Artist", it.data?.results?.get(0)?.name.toString())

        }
    }
}