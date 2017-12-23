package h.radoslav.au.news.ui.source

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.adapters.SourceViewAdapter
import h.radoslav.au.news.ui.base.BaseFragment
import h.radoslav.au.news.ui.news.NewsRecyclerView


class SourceFragment : BaseFragment() {

    private val adapter: SourceViewAdapter by lazy {
        TODO("not implemented")
    }

    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savInsState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_source, container, false)
        initRecyclerView()
        return mView
    }

    companion object {
        val TAG: String = SourceFragment::class.java.simpleName
        fun newInstance() = SourceFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null) {
            TODO("not implemented")
        }
    }

    private fun initRecyclerView() {
        val mRecyclerView = mView.findViewById<NewsRecyclerView>(R.id.recycleView)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = adapter
        mRecyclerView.setEmptyView(mView.findViewById(R.id.empty_view))
    }

}


