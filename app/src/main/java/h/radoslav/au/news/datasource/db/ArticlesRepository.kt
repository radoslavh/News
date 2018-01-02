package h.radoslav.au.news.datasource.db

import h.radoslav.au.news.datasource.ISchedulers
import h.radoslav.au.news.datasource.Schedulers
import h.radoslav.au.news.models.Article
import io.reactivex.Completable
import io.reactivex.Single


class ArticlesRepository constructor(private val database: AppDatabase) {

    private val mScheduler: ISchedulers by lazy { Schedulers() }

    fun createArticle(article: Article): Completable = Completable
            .fromAction({ database.articlesDao().insert(article) })
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

    fun deleteArticle(id: String): Completable = Completable
            .fromAction({ database.articlesDao().delete(id) })
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

    fun deleteAllArticles(): Completable = Completable
            .fromAction({ database.articlesDao().deleteAll() })
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

    fun getArticles(): Single<List<Article>> = database
            .articlesDao()
            .findAll()
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

    fun getArticle(id: String): Single<Article> = database
            .articlesDao()
            .findById(id)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

    fun updateArticle(article: Article): Completable = Completable
            .fromAction({ database.articlesDao().update(article) })
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.ui())

}