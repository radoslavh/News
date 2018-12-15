package h.radoslav.au.news.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.viewholders.NewsViewHolder


class NewsViewAdapter() : RecyclerView.Adapter<NewsViewHolder>() {

    private var currentList: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(currentList.elementAt(position))
    }

    override fun getItemCount() = currentList.size

    fun addArticles(articles: List<Article>) {
        currentList = articles
        notifyDataSetChanged()
    }
}