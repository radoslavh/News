package h.radoslav.au.news.ui.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseActivity
import h.radoslav.au.news.databinding.ActivityNewsBinding

class NewsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
        initFragment()
    }

    private fun initFragment() {
        val tag = NewsFragment.TAG
        fragmentManager.beginTransaction()
                .replace(R.id.container, NewsFragment.newInstance(), tag)
                .addToBackStack(null)
                .commit()

    }
}