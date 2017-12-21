package h.radoslav.au.news.datasource.network

import h.radoslav.au.news.models.NewsSource
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {

    @GET("top-headlines")
    fun getNews(
            @Query("category") category: String,
            @Query("language") language: String,
            @Query("apiKey") apiKey: String): Observable<NewsSource>
}