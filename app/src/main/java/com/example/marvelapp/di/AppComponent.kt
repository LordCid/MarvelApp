package com.example.marvelapp.di


import com.example.marvelapp.presentation.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Component(
    modules = [
        AppModule::class,
        ApplicationProviderModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App
        ): AppComponent
    }
}

object AppComponentFactory : AppComponent.Factory by DaggerAppComponent.factory()