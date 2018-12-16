package h.radoslav.au.news.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

open class BaseFragment : Fragment() {

	protected fun <R> observe(data: LiveData<R>, observer: (R) -> Unit) =
			data.observe(this, Observer { observer(it) })

}