package h.radoslav.au.news.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RestModule() {

	@Provides
	@Singleton
	fun provideRest() = RestHelper()
}
