package h.radoslav.au.news.ui.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.ui.base.BaseFragment


class SourceFragment : BaseFragment() {

	companion object {
		val TAG: String = this::class.java.simpleName
	}


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savInsState: Bundle?): View =
			inflater.inflate(R.layout.fragment_source, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		if (savedInstanceState == null) {
			TODO("not implemented")
		}
	}

	private fun initRecyclerView() {
//        val mRecyclerView = mView.findViewById<NewsRecyclerView>(R.id.recycleView)
//        mRecyclerView.layoutManager = LinearLayoutManager(activity)
//        mRecyclerView.adapter = adapter
//        mRecyclerView.setEmptyView(mView.findViewById(R.id.empty_view))
	}

}


