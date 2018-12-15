package h.radoslav.au.news.ui.base

import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import h.radoslav.au.news.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(), CoroutineScope {

	private val job: Job = SupervisorJob()
	override val coroutineContext: CoroutineContext = job + Dispatchers.Default

	fun replaceFragment(
			fragment: BaseFragment,
			@IdRes containerId: Int = R.id.container,
			addToBackStack: Boolean = true,
			backTag: String? = null
	) {
		supportFragmentManager.beginTransaction().apply {
			replace(containerId, fragment)
				if (addToBackStack) {
					addToBackStack(backTag)
				}
		}.commit()
	}

	@CallSuper
	override fun onDestroy() {
		job.cancelChildren()
		super.onDestroy()
	}
}


