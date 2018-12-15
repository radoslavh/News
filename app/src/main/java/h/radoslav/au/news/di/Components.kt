package h.radoslav.au.news.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RestModule::class, DatabaseModule::class])
interface Components {

	fun provideContext(): Context

	fun provideRest(): RestHelper
}