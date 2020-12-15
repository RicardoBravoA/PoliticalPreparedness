package com.udacity.political.preparedness.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("neo/rest/v1/feed")
    suspend fun feed(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): Response<String>

}