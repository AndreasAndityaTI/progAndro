package com.FastMenu.app.data.repository

import com.FastMenu.app.data.remote.ApiService
import com.FastMenu.app.data.response.DetailMakananResponse
import com.FastMenu.app.data.response.MakananResponse

class MakananRepository(private val apiService : ApiService) {

    suspend fun getMakanan() : MakananResponse {
        return apiService.getMakanan()
    }

    suspend fun getDetailMakanan(id: String) : DetailMakananResponse {
        return apiService.getDetailMakanan(id)
    }

}