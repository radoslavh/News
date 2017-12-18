package h.radoslav.au.news.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.models.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*


class NewsViewAdapter(var news: Observable<List<News>>) : RecyclerView.Adapter<NewsViewHolder>() {

    private var observable: Observable<List<News>>? = null
    private var currentList: List<News>

    init {
        this.currentList = Collections.emptyList()
        this.observable = news
        this.observable?.observeOn(AndroidSchedulers.mainThread())?.subscribe { items ->
            this.currentList = items
            this.notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(currentList.elementAt(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder? {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(v)
    }
}