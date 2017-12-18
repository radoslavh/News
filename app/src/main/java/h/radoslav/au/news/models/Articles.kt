package h.radoslav.au.news.models

import com.google.gson.annotations.SerializedName

data class Articles(
        @SerializedName("author") var author: String? = null,
        @SerializedName("title") var title: String = "",
        @SerializedName("description") var description: String = "",
        @SerializedName("url") var url: String = "",
        @SerializedName("urlToImage") var urlToImage: String? = null,
        @SerializedName("publishedAt") var publishedAt: String? = null)