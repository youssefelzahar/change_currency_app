package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTOItem
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailsDTO

interface CoinRepository {
    suspend fun getCoinsList():List<CoinDTOItem>

    suspend fun getCoinDetails(coinId:String):CoinDetailsDTO

}