package com.project1.myapplication11

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAlbums(): List<Album> {
        return apiService.getAlbums()
    }
}