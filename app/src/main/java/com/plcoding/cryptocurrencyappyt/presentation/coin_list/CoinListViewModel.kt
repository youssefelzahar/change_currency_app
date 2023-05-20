package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_list.GetCoinList
import com.plcoding.cryptocurrencyappyt.util.common.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinList: GetCoinList
):ViewModel()
{
    private val _state = mutableStateOf(CoinListState())
    val state = _state

    init {
        getCoins()
    }
    private fun getCoins() {
        getCoinList().onEach { result ->
            when (result) {
                is ResponseState.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is ResponseState.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is ResponseState.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }
            .launchIn(viewModelScope)
    }
}