package h.radoslav.au.news.ui.article

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseFragment


class ArticleFragment : BaseFragment() {

    companion object {
        val KEY_ARTICLE: String = "article_id"

        val TAG: String = ArticleFragment::class.java.simpleName

        fun newInstance(source: String): ArticleFragment {
            val articleFragment = ArticleFragment()
            articleFragment.arguments.putString(KEY_ARTICLE, source)
            return articleFragment
        }
    }

    private lateinit var viewModel: ArticleViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savInsState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_article, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        val source = arguments.getString(KEY_ARTICLE)
        fetchArticle(source)
    }

    private fun initViewModel() {
        viewModel = ArticleViewModel()
    }

    private fun fetchArticle(source: String) {
        viewModel.getArticle(source)!!.observeForever({
            renderArticle(it)
        })
    }

    private fun renderArticle(comment: Article?) {
//        name.text = comment?.title
//        email.text = comment?.description
//        body.text = comment?.author
    }
}

