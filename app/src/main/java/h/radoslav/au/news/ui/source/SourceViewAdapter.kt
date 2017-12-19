package h.radoslav.au.news.ui.source

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import h.radoslav.au.news.models.NewsSource
import io.reactivex.Observable


class SourceViewAdapter(var news: Observable<NewsSource>) : RecyclerView.Adapter<SourceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SourceViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: SourceViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}