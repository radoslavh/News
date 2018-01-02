package h.radoslav.au.news.datasource.db

import android.arch.persistence.room.*
import h.radoslav.au.news.models.Article
import io.reactivex.Single

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article)

    @Update
    fun update(article: Article)

    @Query("DELETE FROM articles WHERE id = :id")
    fun delete(id: String)

    @Query("DELETE FROM articles")
    fun deleteAll()

    @Query("SELECT * FROM articles WHERE id = :id")
    fun findById(id: String): Single<Article>

    @Query("SELECT * FROM articles ORDER BY DATETIME(date) DESC")
    fun findAll(): Single<List<Article>>

}