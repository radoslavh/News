package h.radoslav.au.news.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.ui.viewholders.NewsViewHolder


class NewsViewAdapter() : RecyclerView.Adapter<NewsViewHolder>() {

    private val currentList: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder? {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(currentList.elementAt(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun addArticles(articles: List<Article>) {
        currentList.clear()
        currentList.addAll(articles)
        notifyDataSetChanged()
    }
}