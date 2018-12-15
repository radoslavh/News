package h.radoslav.au.news.datasource.network

import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource
import kotlinx.coroutines.Deferred

import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {

    @GET("top-headlines")
    fun getNews(
            @Query("category") category: String,
            @Query("language") language: String,
            @Query("apiKey") apiKey: String): Deferred<NewsSource>

    @GET("sources")
    fun getSource(
            @Query("language") countryCode: String): Deferred<Article>

    @GET("sources")
    fun getArticles(
            @Query("source") source: String,
            @Query("apiKey") apiKey: String): Deferred<NewsSource>

    @GET("everything")
    fun getEverything(
            @Query("q") query: String,
            @Query("apiKey") apiKey: String): Deferred<NewsSource>

}