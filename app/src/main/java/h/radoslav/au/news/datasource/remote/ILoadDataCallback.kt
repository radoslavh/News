package h.radoslav.au.news.datasource.remote


interface ILoadDataCallback<T> {

    fun onDataLoaded(list: List<T>)

    fun onDataNotAvailable()
}