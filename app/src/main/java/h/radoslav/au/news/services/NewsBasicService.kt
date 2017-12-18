package h.radoslav.au.news.services

import h.radoslav.au.news.BuildConfig
import io.reactivex.annotations.NonNull
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsBasicService {

    lateinit var newsService: NewsAPI
    @NonNull
    private val BaseURL = BuildConfig.API_BASE_URL

    fun NewsBasicService() {
        var retrofit = Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        newsService = retrofit.create(NewsAPI::class.java)
    }

}

