package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_details

import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetails
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.util.common.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetails @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId:String): Flow<ResponseState<CoinDetails>> = flow {
        try {
            emit(ResponseState.Loading<CoinDetails>())
            val coin = repository.getCoinDetails(coinId).toCoinDetails()
            emit(ResponseState.Success<CoinDetails>(coin))
        }
        catch (e: HttpException){
            emit(ResponseState.Error<CoinDetails>(e.localizedMessage?: "Unexpected ERROR :("))
        }
        catch (e: IOException){
            emit(ResponseState.Error<CoinDetails>(e.localizedMessage?: "check your internet connection !"))
        }
    }
}

