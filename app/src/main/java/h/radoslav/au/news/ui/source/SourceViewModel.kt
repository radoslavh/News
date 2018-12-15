package h.radoslav.au.news.ui.source

import android.app.Application
import h.radoslav.au.news.ui.base.BaseViewModel

class SourceViewModel(app: Application) : BaseViewModel(app) {

	fun getNews(source: String) = rest.getArticles(source)
}