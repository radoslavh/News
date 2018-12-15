package h.radoslav.au.news.ui.news

import android.os.Bundle
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseActivity

class NewsActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_news)
		replaceFragment(NewsFragment(), R.id.container, false, NewsFragment.TAG)
	}
}