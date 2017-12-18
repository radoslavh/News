package h.radoslav.au.news.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.datasource.DataSource
import h.radoslav.au.news.datasource.IDataSource
import io.reactivex.annotations.NonNull

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val mRecyclerView = findViewById<NewsRecyclerView>(R.id.recycleView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = NewsViewAdapter(getDataSource().getAllNews())
        mRecyclerView.setEmptyView(findViewById(R.id.empty_view))
    }

    @NonNull
    private fun getDataSource(): IDataSource {
        return (application as NewsApplication).getDataSource()
    }
}