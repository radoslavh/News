package h.radoslav.au.news.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.adapters.NewsViewAdapter
import h.radoslav.au.news.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.launch

class NewsFragment : BaseFragment() {

	private val adapter: NewsViewAdapter by lazy { NewsViewAdapter() }
	private val viewModel by lazy { ViewModelProviders.of(this).get(NewsViewModel::class.java) }

	companion object {
		val TAG: String = this::class.java.simpleName
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savInsState: Bundle?): View =
			inflater.inflate(R.layout.fragment_news, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		recycleView.adapter = adapter
		recycleView.setEmptyView(empty_view)

		observe(viewModel.article) {
			adapter.addArticles(it)
		}

		launch { viewModel.getNews() }
	}
}