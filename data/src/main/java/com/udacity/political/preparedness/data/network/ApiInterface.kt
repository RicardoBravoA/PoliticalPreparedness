package com.udacity.political.preparedness.data.network

import com.udacity.political.preparedness.data.BuildConfig
import com.udacity.political.preparedness.data.response.ElectionDetailResponse
import com.udacity.political.preparedness.data.response.ElectionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("elections")
    suspend fun elections(
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY
    ): Response<ElectionResponse>

    @GET("voterinfo")
    suspend fun electionDetail(
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY,
        @Query("electionId") electionId: String
    ): Response<ElectionDetailResponse>

}