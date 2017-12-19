package h.radoslav.au.news

import android.app.Application
import h.radoslav.au.news.datasource.DataSource
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.datasource.remote.NewsDataSource
import io.reactivex.annotations.NonNull

class NewsApplication : Application() {

    @NonNull
    private lateinit var mDataSource: IDataSource

    override fun onCreate() {
        super.onCreate()
        mDataSource = DataSource(NewsDataSource())
    }

    @NonNull
    fun getDataSource(): IDataSource {
        return mDataSource
    }
}