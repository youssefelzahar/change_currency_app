package com.plcoding.cryptocurrencyappyt.presentation.coin_details

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)