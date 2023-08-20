package com.farouk.iti_project.di

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.data.repository.PostRepoImp
import com.farouk.iti_project.domin.repository.AppRepo
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApiInterface {
        val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging).build()

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_V2)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofit.create(PostApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PostApiInterface): AppRepo {
        return PostRepoImp(api)
    }

}