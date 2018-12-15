package h.radoslav.au.news.ui.article

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseViewModel

class ArticleViewModel(app: Application) : BaseViewModel(app) {
	private var _article = MutableLiveData<Article>()
	val article: LiveData<Article> = _article

	suspend fun getArticle(category: String) {
		_article.postValue(rest.getArticle(category).await())
	}

}