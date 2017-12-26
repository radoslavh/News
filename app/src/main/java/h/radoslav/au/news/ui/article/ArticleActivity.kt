package h.radoslav.au.news.ui.article

import android.os.Bundle
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseActivity
import h.radoslav.au.news.ui.news.NewsFragment


class ArticleActivity : BaseActivity() {

    val Article_ID = "article_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        initFragment()
    }

    private fun initFragment() {
        val str = intent.getStringExtra(Article_ID);
        val tag = ArticleFragment.TAG
        fragmentManager.beginTransaction()
                .add(R.id.container, ArticleFragment.newInstance(str),tag)
                .commit()

    }
}

