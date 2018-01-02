package h.radoslav.au.news.datasource.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import h.radoslav.au.news.BuildConfig
import h.radoslav.au.news.datasource.ISchedulers
import h.radoslav.au.news.datasource.Schedulers
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource


class NewsDataSource {

    private val mNewsClient: NewsAPI by lazy { NewsClient().getClient() }

    private val mScheduler: ISchedulers by lazy { Schedulers() }

    fun getNews(category: String, language: String): LiveData<NewsSource> {
        val liveData = MutableLiveData<NewsSource>()

        mNewsClient
                .getNews(category, language, BuildConfig.API_KEY)
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.ui())
                .subscribe(liveData::setValue)

        return liveData
    }

    fun getArticle(language: String): LiveData<Article> {
        val liveData = MutableLiveData<Article>()

        mNewsClient
                .getSource(language)
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.ui())
                .subscribe(liveData::setValue)

        return liveData
    }

    fun getArticles(source: String): LiveData<NewsSource> {
        val liveData = MutableLiveData<NewsSource>()

        mNewsClient
                .getArticles(source, BuildConfig.API_KEY)
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.ui())
                .subscribe(liveData::setValue)

        return liveData
    }

    fun getEverything(query: String): LiveData<NewsSource> {
        val liveData = MutableLiveData<NewsSource>()

        mNewsClient
                .getEverything(query, BuildConfig.API_KEY)
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.ui())
                .subscribe(liveData::setValue)

        return liveData
    }


}

