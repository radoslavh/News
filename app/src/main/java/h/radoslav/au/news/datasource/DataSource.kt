package h.radoslav.au.news.datasource

import h.radoslav.au.news.models.News
import io.reactivex.Observable
import java.util.*


/**
 * Created by Radoslav Hlinka on 18/12/2017.
 */
class DataSource : IDataSource {

    override fun getAllNews(): Observable<List<News>> {
        return Observable.fromCallable(this::getNews);
    }

    //TODO https://newsapi.org/v2/top-headlines?category=business&language=en&apiKey=86b3956adadb46e48697c2312b3af90a

    private fun getNews(): List<News> {
        return Arrays
                .asList(News("Title 1","Text"),
                        News("Title 2","Text"))
    }
}