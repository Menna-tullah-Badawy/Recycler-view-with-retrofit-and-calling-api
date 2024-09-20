package com.project1.myapplication11

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project1.myapplication11.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        albumViewModel.albums.observe(this) { albums ->
            albumAdapter = AlbumAdapter(albums)
            binding.recyclerView.adapter = albumAdapter
        }
    }
}
