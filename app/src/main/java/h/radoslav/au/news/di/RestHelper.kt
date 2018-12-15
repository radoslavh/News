package h.radoslav.au.news.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import h.radoslav.au.news.BuildConfig
import h.radoslav.au.news.datasource.network.NewsAPI
import h.radoslav.au.news.models.NewsSource
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Singleton
class RestHelper {

	private val newsService by lazy { retrofit.create(NewsAPI::class.java) }

	private companion object {
		private val retrofit = Retrofit.Builder()
				.baseUrl(BuildConfig.API_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(CoroutineCallAdapterFactory())
				.client(OkHttpClient())
				.build()!!
	}

	fun getNews(category: String, language: String): Deferred<NewsSource> {
		Timber.d("getNews()")
		return newsService.getNews(category, language, BuildConfig.API_KEY)
	}

	fun getArticle(language: String) = newsService.getSource(language)

	fun getArticles(source: String)= newsService.getArticles(source, BuildConfig.API_KEY)

	fun getEverything(query: String) = newsService.getEverything(query, BuildConfig.API_KEY)
}
