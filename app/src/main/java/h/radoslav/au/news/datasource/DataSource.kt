package h.radoslav.au.news.datasource


import android.arch.lifecycle.LiveData
import h.radoslav.au.news.datasource.network.NewsDataSource
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource

class DataSource : IDataSource {
    private val remoteDataSource: NewsDataSource by lazy { NewsDataSource() }

    override fun getNews(category: String,
                         language: String): LiveData<NewsSource>
            = remoteDataSource.getNews(category, language)


    override fun getArticle(language: String): LiveData<Article>
            = remoteDataSource.getArticle(language)


    override fun getArticles(source: String): LiveData<NewsSource>
            = remoteDataSource.getArticles(source)


    override fun getEverything(query: String): LiveData<NewsSource>
            = remoteDataSource.getEverything(query)

}