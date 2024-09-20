package com.project1.myapplication11

import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>
}