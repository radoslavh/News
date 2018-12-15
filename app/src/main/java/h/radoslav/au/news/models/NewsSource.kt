package h.radoslav.au.news.models

data class NewsSource(
		var status: String = "",
		var source: String = "",
		var articles: List<Article> = emptyList()
)