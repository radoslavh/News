package h.radoslav.au.news.datasource.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import h.radoslav.au.news.BuildConfig
import h.radoslav.au.news.models.Article
import h.radoslav.au.news.models.NewsSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class NewsDataSource {

    private val mNewsClient: NewsAPI by lazy { NewsClient().getClient() }

    fun getArticles(category: String, language: String): LiveData<NewsSource> {
        val liveData = MutableLiveData<NewsSource>()

        mNewsClient
                .getNews(category, language, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liveData::setValue)

        return liveData
    }

    fun getArticle(language: String): LiveData<Article> {
        val liveData = MutableLiveData<Article>()

        mNewsClient
                .getSource(language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liveData::setValue)

        return liveData
    }

}

