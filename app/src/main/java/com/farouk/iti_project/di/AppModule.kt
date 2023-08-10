package com.farouk.iti_project.di

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.data.repository.PostRepoImp
import com.farouk.iti_project.domin.model.Post
import com.farouk.iti_project.domin.repository.PostRepo
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PostApiInterface): PostRepo {
        return PostRepoImp(api)
    }

}