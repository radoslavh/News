package h.radoslav.au.news.di

import androidx.room.Database
import androidx.room.RoomDatabase
import h.radoslav.au.news.models.Article

//@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

//	abstract fun dayForecastDao(): ForecastDao
}
