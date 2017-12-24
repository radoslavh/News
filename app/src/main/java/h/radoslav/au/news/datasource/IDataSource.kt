package h.radoslav.au.news.datasource

import android.arch.lifecycle.LiveData
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource


interface IDataSource {

    fun getNews(category: String, language: String): LiveData<NewsSource>

    fun getArticle(language: String): LiveData<Article>

    fun getArticles(source: String): LiveData<NewsSource>

    fun getEverything(query: String): LiveData<NewsSource>
}
