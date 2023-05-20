package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

data class CoinDetails (
    val id: String, // btc-bitcoin
    val isActive: Boolean, // true
    val name: String, // Bitcoin
    val description: String, // Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.
    val symbol: String, // BTC
    val rank: Int, // 1
    val tags: List<String>, // Bitcoin
    val team: List<TeamMember>, // Bitcoin

        )