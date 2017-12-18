package h.radoslav.au.news.services

import h.radoslav.au.news.models.NewsSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    fun getNews(
            @Query("category") category: String,
            @Query("language") language: String,
            @Query("apiKey") apiKey: String): Call<NewsSource>
}