package h.radoslav.au.news.datasource.network

import h.radoslav.au.news.BuildConfig
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class NewsClient {

    private var newsService: NewsAPI
    private val httpClient: OkHttpClient = OkHttpClient()

    init {
        var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()

        newsService = retrofit.create(NewsAPI::class.java)
    }

    fun getClient(): NewsAPI {
        return newsService
    }
}