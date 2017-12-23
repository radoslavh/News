package h.radoslav.au.news.ui.viewholders

import android.content.ContentUris
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.utils.TimeUtil
import kotlinx.android.synthetic.main.item_layout.view.*


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(news: Article) = with(itemView) {
        itemView.item_title.text = news.title
        itemView.item_description.text = news.description
        itemView.item_date.text = TimeUtil.timeFormat(news.publishedAt).toUpperCase()

        Glide.with(this)
                .load(Uri.parse(news.urlToImage))
                .into(itemView.list_item_icon);
    }


}