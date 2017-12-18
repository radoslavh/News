package h.radoslav.au.news.services

import h.radoslav.au.news.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRxService {

    lateinit var newsService: NewsAPI

    private val CATEGORY = "business"
    private val LANG = "en"

    fun NewsBasicService() {
        var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        newsService = retrofit.create(NewsAPI::class.java)
    }

}