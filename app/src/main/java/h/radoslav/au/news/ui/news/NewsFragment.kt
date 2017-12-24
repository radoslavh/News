package h.radoslav.au.news.ui.news

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.NewsApplication
import h.radoslav.au.news.R
import h.radoslav.au.news.databinding.FragmentNewsBinding
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.ui.adapters.NewsViewAdapter
import h.radoslav.au.news.ui.base.BaseFragment


class NewsFragment : BaseFragment() {

    private val adapter: NewsViewAdapter by lazy { NewsViewAdapter() }

    private val viewModel: NewsViewModel by lazy { NewsViewModel(getDataSource()) }

    private val CATEGORY = "business"
    private val LANG = "en"

    private lateinit var binding: FragmentNewsBinding

    companion object {
        val TAG: String = NewsFragment::class.java.simpleName
        fun newInstance() = NewsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savInsState: Bundle?): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        viewModel.getNews(CATEGORY, LANG).observeForever({
            adapter.addArticles(it!!.articles)
        })
    }

    private fun initRecyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(activity)
        binding.recycleView.adapter = adapter
        binding.recycleView.setEmptyView(binding.emptyView)
    }

    @NonNull
    private fun getDataSource(): IDataSource {
        return (activity.applicationContext as NewsApplication).getDataSource()
    }
}