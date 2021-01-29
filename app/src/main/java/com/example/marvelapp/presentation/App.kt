package com.example.marvelapp.presentation


import com.example.marvelapp.di.AppComponent
import com.example.marvelapp.di.AppComponentFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    open lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = AppComponentFactory.create(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}
