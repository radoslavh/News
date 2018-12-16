package h.radoslav.au.news.ui.base

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import h.radoslav.au.news.NewsApplication
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {

	private val job: Job = SupervisorJob()
	override val coroutineContext: CoroutineContext = job + Dispatchers.Default

	protected val rest = NewsApplication.COMPONENTS.provideRest()
//	protected val db = NewsApplication.COMPONENTS.provideDb()


	@CallSuper
	override fun onCleared() {
		job.cancelChildren()
		super.onCleared()
	}
}
