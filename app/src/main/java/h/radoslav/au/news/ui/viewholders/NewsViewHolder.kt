package h.radoslav.au.news.ui.viewholders

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.utils.TimeUtil
import kotlinx.android.synthetic.main.item_layout.view.*
import androidx.recyclerview.widget.RecyclerView


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(news: Article) = with(itemView) {
        item_title.text = news.title
        item_description.text = news.description
        item_date.text = TimeUtil.timeFormat(news.publishedAt).toUpperCase()

        Glide.with(this)
                .load(Uri.parse(news.urlToImage ?: ""))
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        itemView.progress.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        itemView.progress.visibility = View.GONE
                        return false
                    }
                })
                .into(itemView.list_item_icon);
    }
}