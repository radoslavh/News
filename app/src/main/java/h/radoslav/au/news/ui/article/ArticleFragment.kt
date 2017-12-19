package h.radoslav.au.news.ui.article

import h.radoslav.au.news.ui.base.BaseFragment


class ArticleFragment : BaseFragment() {

    companion object {
        val TAG: String = ArticleFragment::class.java.simpleName
        fun newInstance() = ArticleFragment()
    }
}