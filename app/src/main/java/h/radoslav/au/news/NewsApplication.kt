package h.radoslav.au.news

import android.app.Application
import android.support.annotation.NonNull
import h.radoslav.au.news.datasource.DataSource
import h.radoslav.au.news.datasource.IDataSource

class NewsApplication : Application() {

    @NonNull
    private lateinit var mDataSource: IDataSource

    override fun onCreate() {
        super.onCreate()
        mDataSource = DataSource()
    }

    @NonNull
    fun getDataSource(): IDataSource {
        return mDataSource
    }
}