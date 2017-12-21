package h.radoslav.au.news.datasource


import android.arch.lifecycle.LiveData
import h.radoslav.au.news.datasource.network.NewsDataSource
import h.radoslav.au.news.models.NewsSource

class DataSource : IDataSource {

    private val remoteDataSource: NewsDataSource by lazy { NewsDataSource() }

    override fun getArticles(category: String,
                             language: String): LiveData<NewsSource> {

        return remoteDataSource.getArticles(category, language)
    }
}