package h.radoslav.au.news.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

class NewsRecyclerView : RecyclerView {

    private var mEmptyView: View? = null

    private val mDataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            checkViewIsEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            checkViewIsEmpty()
        }

        override fun onChanged() {
            checkViewIsEmpty()
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(mDataObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(mDataObserver)

        checkViewIsEmpty()
    }

    private fun checkViewIsEmpty() {
        val isEmptyViewShown = adapter?.itemCount == 0
        mEmptyView?.visibility = if (isEmptyViewShown) View.VISIBLE else View.GONE
        visibility = if (isEmptyViewShown) View.GONE else View.VISIBLE
    }

    fun setEmptyView(emptyView: View?) {
        mEmptyView = emptyView
        checkViewIsEmpty()
    }
}
