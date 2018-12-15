package h.radoslav.au.news.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import h.radoslav.au.news.R
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseFragment
import kotlinx.coroutines.launch

class ArticleFragment : BaseFragment() {

	private val viewModel by lazy { ViewModelProviders.of(this).get(ArticleViewModel::class.java) }
	private val source by lazy { arguments!!.getString(ARTICLE_KEY) }

	companion object {
		val ARTICLE_KEY: String = "article_id"

		val TAG: String = this::class.java.simpleName

		operator fun invoke(source: String) = ArticleFragment().apply {
			arguments = Bundle(1).apply {
				putString(ARTICLE_KEY, source)
			}
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savInsState: Bundle?): View =
			inflater.inflate(R.layout.fragment_article, container, false)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		observe(viewModel.article) {
			onFetchArticle(it)
		}
		launch { viewModel.getArticle(source) }

	}

	private fun onFetchArticle(comment: Article) = with(comment) {
//		name.text = title
//		email.text = description
//		body.text = author
	}
}

