package h.radoslav.au.news.ui.news

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.datasource.DataSource
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.base.BaseFragment


class NewsFragment : BaseFragment() {

    private lateinit var adapter: NewsViewAdapter

    private lateinit var newsViemModel: NewsViewModel
    private lateinit var mView: View

    private val CATEGORY = "business"
    private val LANG = "en"

    companion object {
        val TAG: String = NewsFragment::class.java.simpleName
        fun newInstance() = NewsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savInsState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_news, container, false)
        adapter = NewsViewAdapter()
        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViemModel = NewsViewModel(getDataSource())
        initRecyclerView()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        newsViemModel.getArticles(CATEGORY, LANG).observeForever({
            adapter.addArticles(it!!.articles)
        })
    }

    private fun initRecyclerView() {
        val mRecyclerView = mView.findViewById<NewsRecyclerView>(R.id.recycleView)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = adapter
        mRecyclerView.setEmptyView(mView.findViewById(R.id.empty_view))
    }

    @NonNull
    private fun getDataSource(): IDataSource {
        return (activity.applicationContext as NewsApplication).getDataSource()
    }
}