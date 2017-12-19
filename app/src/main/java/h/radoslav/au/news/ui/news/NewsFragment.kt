package h.radoslav.au.news.ui.news

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.ui.base.BaseFragment
import io.reactivex.annotations.NonNull


class NewsFragment : BaseFragment() {

    private val adapter: NewsViewAdapter by lazy { NewsViewAdapter(getDataSource().getAllNews()) }

    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savInsState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_news, container, false)
        initRecyclerView()
        return mView
    }

    companion object {
        val TAG: String = NewsFragment::class.java.simpleName
        fun newInstance() = NewsFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null) {
            //TODO load news
        }
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