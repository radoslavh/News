package h.radoslav.au.news.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import h.radoslav.au.news.R
import h.radoslav.au.news.models.News

/**
 * Created by Radoslav Hlinka on 18/12/2017.
 */
class NewsViewAdapter(var news: List<News>) : RecyclerView.Adapter<NewsViewHolder>(){

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news.elementAt(position))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder?{
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent,false)
        return NewsViewHolder(v)
    }
}