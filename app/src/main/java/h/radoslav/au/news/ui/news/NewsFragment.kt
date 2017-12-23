package h.radoslav.au.news.ui.news

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.ui.adapters.NewsViewAdapter
import h.radoslav.au.news.ui.base.BaseFragment
import kotlinx.android.synthetic.main.item_layout.view.*


class NewsFragment : BaseFragment() {

    private val adapter: NewsViewAdapter by lazy { NewsViewAdapter() }

    private val viemModel: NewsViewModel by lazy { NewsViewModel(getDataSource()) }

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
        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        viemModel.getArticles(CATEGORY, LANG).observeForever({
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