package h.radoslav.au.news.datasource.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import h.radoslav.au.news.models.Article


@Database(entities = [(Article::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

}