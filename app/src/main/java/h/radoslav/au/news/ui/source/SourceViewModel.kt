package h.radoslav.au.news.ui.source

import android.arch.lifecycle.LiveData
import h.radoslav.au.news.datasource.IDataSource
import h.radoslav.au.news.models.NewsSource

class SourceViewModel(private var remoteData: IDataSource) {

    fun getNews(source: String): LiveData<NewsSource>
            = remoteData.getArticles(source)

}