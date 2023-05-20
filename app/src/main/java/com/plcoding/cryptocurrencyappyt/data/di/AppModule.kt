package com.plcoding.cryptocurrencyappyt.data.di

import com.plcoding.cryptocurrencyappyt.data.remote.web_services.CoinAPI
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImplementation
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.util.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // 3shan yb2a l single retrofit instant f kol l app
object AppModule {
    @Provides
    @Singleton
    fun provideAPI():CoinAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinAPI::class.java)
    }

    //b3d ma hy7sl creation ll retrofit instant hyost5dam f l function de 3shan l repo tsht8l
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinAPI): CoinRepository{
        return CoinRepositoryImplementation(api)
    }
}