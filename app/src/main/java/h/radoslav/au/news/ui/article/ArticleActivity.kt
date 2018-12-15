package h.radoslav.au.news.ui.article

import android.os.Bundle
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseActivity


class ArticleActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_article)
		initFragment()
	}

	private fun initFragment() {
		val str = intent.getStringExtra(ArticleFragment.ARTICLE_KEY);
		val tag = ArticleFragment.TAG
		supportFragmentManager.beginTransaction()
				.add(R.id.container, ArticleFragment(str), tag)
				.commit()
	}
}

