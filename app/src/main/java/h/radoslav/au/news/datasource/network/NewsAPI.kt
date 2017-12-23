package h.radoslav.au.news.datasource.network

import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {

    @GET("top-headlines")
    fun getNews(
            @Query("category") category: String,
            @Query("language") language: String,
            @Query("apiKey") apiKey: String): Observable<NewsSource>

    @GET("sources")
    fun getSource(
            @Query("language") countryCode: String): Observable<Article>
}