package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_list

import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.util.common.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinList @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<ResponseState<List<Coin>>> = flow{
        try {

            emit(ResponseState.Loading<List<Coin>>())
            val coin = repository.getCoinsList().map { it.toCoin() }
            emit(ResponseState.Success<List<Coin>>(coin))

        }catch (e: HttpException){
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage?: "Unexpected ERROR :("))

        }catch (e: IOException){
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage?: "check your internet connection !"))
        }
    }
}