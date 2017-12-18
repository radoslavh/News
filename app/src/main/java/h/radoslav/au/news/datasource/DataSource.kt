package h.radoslav.au.news.datasource

import h.radoslav.au.news.models.Articles
import h.radoslav.au.news.services.NewsService
import io.reactivex.Observable

class DataSource : IDataSource {

    private var observable: Observable<List<Articles>> = Observable.empty()

    override fun getAllNews(): Observable<List<Articles>> {
        NewsService(this).load()
        return getNews();
    }

    override fun setArticles(articles: List<Articles>) {
        observable = Observable.fromArray(articles)
    }

    private fun getNews(): Observable<List<Articles>> {
        return observable;
    }
}