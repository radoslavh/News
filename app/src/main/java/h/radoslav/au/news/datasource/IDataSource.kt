package h.radoslav.au.news.datasource

import android.arch.lifecycle.LiveData
import h.radoslav.au.news.models.NewsSource


interface IDataSource {

    fun getArticles(category: String, language: String): LiveData<NewsSource>
}
