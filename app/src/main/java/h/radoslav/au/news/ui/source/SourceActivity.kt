package h.radoslav.au.news.ui.source

import android.os.Bundle
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseActivity

class SourceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        initFragment()
    }

    private fun initFragment() {
        val fm = supportFragmentManager
        val tag = SourceFragment.TAG
        fm.findFragmentByTag(tag) ?: SourceFragment().apply {
            fm.beginTransaction()
                    .add(R.id.container, this, tag)
                    .commit()
        }
    }
}