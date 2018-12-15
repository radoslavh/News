package h.radoslav.au.news.ui.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.util.AttributeSet
import android.view.View


open class BaseRecyclerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private var emptyView: View? = null

    private val observer = object : RecyclerView.AdapterDataObserver() {
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) = checkViewIsEmpty()

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) = checkViewIsEmpty()

        override fun onChanged() = checkViewIsEmpty()
    }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(observer)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(observer)

        checkViewIsEmpty()
    }

    private fun checkViewIsEmpty() {
        val isEmptyViewShown = adapter?.itemCount == 0
        emptyView?.visibility = if (isEmptyViewShown) View.VISIBLE else View.GONE
        visibility = if (isEmptyViewShown) View.GONE else View.VISIBLE
    }

    fun setEmptyView(emptyView: View) {
        this.emptyView = emptyView
        checkViewIsEmpty()
    }
}
