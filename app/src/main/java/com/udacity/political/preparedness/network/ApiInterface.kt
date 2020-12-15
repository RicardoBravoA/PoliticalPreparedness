package com.udacity.political.preparedness.network

import com.udacity.political.preparedness.BuildConfig
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("elections")
    suspend fun feed(
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY
    ): Response<List<ElectionEntity>>

}