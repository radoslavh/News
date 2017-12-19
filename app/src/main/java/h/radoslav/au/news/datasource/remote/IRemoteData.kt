package h.radoslav.au.news.datasource.remote

import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource


interface IRemoteData : IDataSource {

    fun getSource(callback: ILoadDataCallback<NewsSource>)

    fun getArticles(source: String, callback: ILoadDataCallback<Article>)
}