package h.radoslav.au.news.datasource

import h.radoslav.au.news.models.News
import io.reactivex.Observable


interface IDataSource {

    fun getAllNews(): Observable<List<News>>

}
