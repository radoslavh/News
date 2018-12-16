package h.radoslav.au.news.ui.news

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber


class NewsViewModel(app: Application) : BaseViewModel(app) {

	private val CATEGORY = "business"
	private val LANG = "en"

	private var _articles = MutableLiveData<List<Article>>()
	val article: LiveData<List<Article>> = _articles

	fun getNews() {
		launch {
			val articles = rest.getNews(CATEGORY, LANG).await().articles
			Timber.d(articles.toString())
			_articles.postValue(articles)

		}


	}

	suspend fun getArticle() = rest.getArticle(LANG)
}