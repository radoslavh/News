package h.radoslav.au.news.datasource

import io.reactivex.Scheduler

interface ISchedulers {

    fun io(): Scheduler

    fun ui(): Scheduler

}