package h.radoslav.au.news.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import h.radoslav.au.news.NewsApplication

open class BaseViewModel(app: Application) : AndroidViewModel(app) {

	protected val rest = NewsApplication.COMPONENTS.provideRest()

//	protected val db = NewsApplication.COMPONENTS.provideDb()

}
