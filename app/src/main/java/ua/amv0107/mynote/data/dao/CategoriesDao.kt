package ua.amv0107.mynote.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.amv0107.mynote.data.model.Category

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories")
    fun getCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Query("DELETE FROM categories WHERE id=:id")
    fun deleteCategory(id: Int)

    @Update
    fun updateCategory(category: Category)
}