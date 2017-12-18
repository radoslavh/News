package h.radoslav.au.news.datasource

import h.radoslav.au.news.models.Articles
import io.reactivex.Observable


interface IDataSource {

    fun getAllNews(): Observable<List<Articles>>

    fun setArticles(articles: List<Articles>)

}
