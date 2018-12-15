package h.radoslav.au.news.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseFragment : Fragment(), CoroutineScope {

	private val job: Job = SupervisorJob()
	override val coroutineContext: CoroutineContext = job + Dispatchers.Default

	protected fun <R> observe(data: LiveData<R>, observer: (R) -> Unit) =
			data.observe(this, Observer { observer(it) })

	override fun onDestroy() {
		job.cancelChildren()
		super.onDestroy()
	}
}