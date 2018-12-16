package h.radoslav.au.news.ui.article

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ArticleViewModel(app: Application) : BaseViewModel(app) {
	private var _article = MutableLiveData<Article>()
	val article: LiveData<Article> = _article

	fun getArticle(category: String) {
		launch {
			_article.postValue(rest.getArticle(category).await())
		}
	}

}