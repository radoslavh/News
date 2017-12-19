package h.radoslav.au.news.ui.source

import android.os.Bundle
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.ui.base.BaseActivity
import h.radoslav.au.news.ui.news.NewsFragment
import io.reactivex.annotations.NonNull


class SourceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        initFragment()
    }

    @NonNull
    private fun getDataSource(): IDataSource {
        return (application as NewsApplication).getDataSource()
    }

    private fun initFragment() {
        val tag = NewsFragment.TAG
        fragmentManager.beginTransaction()
                .replace(R.id.container, SourceFragment.newInstance(), tag)
                .addToBackStack(null)
                .commit()

    }
}