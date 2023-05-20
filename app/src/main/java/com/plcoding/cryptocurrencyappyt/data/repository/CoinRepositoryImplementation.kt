package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTOItem
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailsDTO
import com.plcoding.cryptocurrencyappyt.data.remote.web_services.CoinAPI
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinAPI
): CoinRepository {
    override suspend fun getCoinsList(): List<CoinDTOItem> {
        return api.getCoinsList()
    }

    override suspend fun getCoinDetails(coinId:String): CoinDetailsDTO{
        return api.getCoinDetails(coinId)
    }
}