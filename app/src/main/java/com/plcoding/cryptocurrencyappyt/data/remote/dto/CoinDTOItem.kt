package com.plcoding.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

// DTO is like a filter used to filter the data come from the API before using the model

data class CoinDTOItem(
    @SerializedName("id")
    val id: String, // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean, // true
    @SerializedName("is_new")
    val isNew: Boolean, // false
    @SerializedName("name")
    val name: String, // Bitcoin
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("symbol")
    val symbol: String, // BTC
    @SerializedName("type")
    val type: String // coin
)


fun CoinDTOItem.toCoin(): Coin {
    return Coin(
        id= id,
        isActive = isActive,
        name=name,
        rank=rank,
        symbol=symbol
    )
}
