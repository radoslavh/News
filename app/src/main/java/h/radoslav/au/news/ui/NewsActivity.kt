package h.radoslav.au.news.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import h.radoslav.au.news.R

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val mRecyclerView = findViewById<NewsRecyclerView>(R.id.recycleView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = NewsViewAdapter(ArrayList())
        mRecyclerView.setEmptyView(findViewById(R.id.empty_view))
    }

}
