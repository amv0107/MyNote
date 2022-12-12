package ua.amv0107.mynote.data.repository

import androidx.lifecycle.LiveData
import ua.amv0107.mynote.data.dao.CategoriesDao
import ua.amv0107.mynote.data.dao.NotesDao
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.data.model.Notes

class CategoriesRepository(private val dao: CategoriesDao) {

    fun getAllCategories(): LiveData<List<Category>> = dao.getCategories()

    fun insertCategory(category: Category) = dao.insertCategory(category)

    fun deleteCategory(id: Int) = dao.deleteCategory(id)

    fun updateCategory(category: Category) = dao.updateCategory(category)
}