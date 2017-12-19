package h.radoslav.au.news.datasource.remote

import h.radoslav.au.news.BuildConfig
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsService(var client: IDataSource) : Callback<NewsSource> {

    private val CATEGORY = "business"
    private val LANG = "en"

    fun load() {
        var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsAPI::class.java)
                .getNews(CATEGORY, LANG, BuildConfig.API_KEY);

        retrofit.enqueue(this)
    }

    override fun onFailure(call: Call<NewsSource>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<NewsSource>, response: Response<NewsSource>) {
        if (response.isSuccessful()) {
            val articles: List<Article> = response.body()!!.articles
            client.setArticles(articles)

        } else {
            System.out.println(response.errorBody())
        }
    }
}


