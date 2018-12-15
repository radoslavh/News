package h.radoslav.au.news.models

data class Article(var author: String = "",
                   var title: String = "",
                   var description: String = "",
                   var url: String = "",
                   var urlToImage: String? = null,
                   var publishedAt: String? = null
)