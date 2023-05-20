package com.plcoding.cryptocurrencyappyt.data.remote.web_services

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTOItem
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAPI {

    @GET("/v1/coins")
    suspend fun getCoinsList(): List<CoinDTOItem>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailsDTO
}