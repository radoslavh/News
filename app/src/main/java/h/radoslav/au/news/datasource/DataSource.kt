package h.radoslav.au.news.datasource

import h.radoslav.au.news.datasource.remote.ILoadDataCallback
import h.radoslav.au.news.datasource.remote.NewsDataSource
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.datasource.remote.NewsService
import io.reactivex.Observable
import java.util.ArrayList

class DataSource : IDataSource {

    private val remoteDataSource: NewsDataSource by lazy { NewsDataSource() }

    private var observable: Observable<List<Article>> = Observable.empty()

    override fun getAllNews(): Observable<List<Article>> {
        NewsService(this).load()
        return getNews();
    }

    override fun setArticles(articles: List<Article>) {
        observable = Observable.fromArray(articles)
    }

    private fun getNews(): Observable<List<Article>> {
        return observable;
    }

    private fun getArticlesFromDataSource(sourceId: String,
                                          callback: ILoadDataCallback<Article>) {


        remoteDataSource.getArticles(sourceId, object : ILoadDataCallback<Article> {
            override fun onDataLoaded(list: List<Article>) {
                callback.onDataLoaded(ArrayList(list))
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }
}