package com.udacity.political.preparedness.data.network

import com.udacity.political.preparedness.data.BuildConfig
import com.udacity.political.preparedness.data.response.detail.ElectionDetailResponse
import com.udacity.political.preparedness.data.response.ElectionResponse
import com.udacity.political.preparedness.data.response.geocode.GeocodeResponse
import com.udacity.political.preparedness.data.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface {

    @GET("elections")
    suspend fun elections(
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY
    ): Response<ElectionResponse>

    @GET("voterinfo")
    suspend fun electionDetail(
        @Query("electionId") electionId: String,
        @Query("address") address: String,
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY
    ): Response<ElectionDetailResponse>

    @GET("voterinfo")
    suspend fun voterInfo(
        @Query("address") address: String,
        @Query("electionId") electionId: String,
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY
    ): Response<ElectionDetailResponse>

    @GET
    suspend fun geocode(
        @Url url: String = Constant.GEOCODE_URL,
        @Query("latlng") latLng: String,
        @Query("key") key: String = BuildConfig.CIVIC_API_KEY,
    ): Response<GeocodeResponse>

}