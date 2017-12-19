package h.radoslav.au.news.models

import com.google.gson.annotations.SerializedName

data class NewsSource(
        @SerializedName("status") var status: String = "",
        @SerializedName("totalResults") var source: String = "",
        @SerializedName("articles") var articles: List<Article> = emptyList())