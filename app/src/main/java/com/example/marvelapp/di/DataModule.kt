package com.example.marvelapp.di

import com.example.marvelapp.data.NetworkDatasource
import com.example.marvelapp.data.NetworkDatasourceImpl
import com.example.marvelapp.data.Repository
import com.example.marvelapp.data.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository

    @Binds
    fun bindNetworkDataSource(netWorkDataSource: NetworkDatasourceImpl): NetworkDatasource
}