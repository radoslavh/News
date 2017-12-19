package h.radoslav.au.news.datasource.remote

import h.radoslav.au.news.BuildConfig
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsDataSource : IRemoteData {

    private val mNewsClient: NewsAPI by lazy { NewsClient().getClient() }

    override fun getAllNews(): Observable<List<Article>> {
        TODO("not implemented")
    }

    override fun setArticles(articles: List<Article>) {
        TODO("not implemented")
    }

    override fun getSource(callback: ILoadDataCallback<NewsSource>) {
        TODO("not implemented")
    }

    override fun getArticles(source: String, callback: ILoadDataCallback<Article>) {
        val articleResponseCall = mNewsClient.getNews(BuildConfig.API_KEY, source, "top")
        articleResponseCall.enqueue(object : Callback<NewsSource> {
            override fun onResponse(call: Call<NewsSource>, response: Response<NewsSource>) {
                if (response.isSuccessful()) {
                    callback.onDataLoaded(response.body()!!.articles)
                } else {
                    callback.onDataNotAvailable()
                }
            }

            override fun onFailure(call: Call<NewsSource>, t: Throwable) {
                callback.onDataNotAvailable()
            }
        })
    }
}