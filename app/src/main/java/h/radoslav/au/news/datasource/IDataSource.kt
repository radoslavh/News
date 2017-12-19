package h.radoslav.au.news.datasource

import h.radoslav.au.news.models.Article
import io.reactivex.Observable


interface IDataSource {

    fun getAllNews(): Observable<List<Article>>

    fun setArticles(articles: List<Article>)

}
