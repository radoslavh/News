package h.radoslav.au.news.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import h.radoslav.au.news.R

open class BaseActivity : AppCompatActivity() {

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
}


