package com.plcoding.cryptocurrencyappyt.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_details.GetCoinDetails
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_list.GetCoinList
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import com.plcoding.cryptocurrencyappyt.util.common.Constants
import com.plcoding.cryptocurrencyappyt.util.common.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel@Inject constructor(
    private val getCoinDetails: GetCoinDetails,
    private val savedStateHandle:SavedStateHandle
): ViewModel()
{
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }
    private fun getCoin(coinId:String) {
        getCoinDetails(coinId).onEach { result ->
            when (result) {
                is ResponseState.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }
                is ResponseState.Error -> {
                    _state.value = CoinDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is ResponseState.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }
            .launchIn(viewModelScope)
    }
}