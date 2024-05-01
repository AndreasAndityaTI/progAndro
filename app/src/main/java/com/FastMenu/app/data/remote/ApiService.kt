package com.FastMenu.app.data.remote

import com.FastMenu.app.data.response.DetailMakananResponse
import com.FastMenu.app.data.response.ScanResponse
import com.FastMenu.app.data.response.MakananResponse
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {

    @GET("makanan")
    suspend fun getMakanan() : MakananResponse

    @GET("makanan/{id}")
    suspend fun getDetailMakanan(
        @Path("id") id: String
    ) : DetailMakananResponse

    @Multipart
    @POST("post")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part
    ): ScanResponse

}