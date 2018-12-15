package h.radoslav.au.news.di

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

	@Provides
	@Singleton
	fun provideDatabase(context: Context): AppDatabase =
			Room.databaseBuilder(context, AppDatabase::class.java, "weather_repo")
					.fallbackToDestructiveMigration()
					.build()

}