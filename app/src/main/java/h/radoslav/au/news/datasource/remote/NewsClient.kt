package h.radoslav.au.news.datasource.remote

import h.radoslav.au.news.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsClient {

    private var newsService: NewsAPI

    init {
        var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        newsService = retrofit.create(NewsAPI::class.java)
    }

    fun getClient(): NewsAPI {
        return newsService
    }
}