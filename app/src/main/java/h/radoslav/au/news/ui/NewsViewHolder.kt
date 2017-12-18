package h.radoslav.au.news.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import h.radoslav.au.news.models.News
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by Radoslav Hlinka on 18/12/2017.
 */
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(news: News) = with(itemView) {
        itemView.textViewItem.text = news.title

    }
}