package ua.amv0107.mynote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ua.amv0107.mynote.data.NotesDatabase
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.data.model.Notes
import ua.amv0107.mynote.data.repository.CategoriesRepository
import ua.amv0107.mynote.data.repository.NotesRepository

class CategoriesViewModel(application: Application): AndroidViewModel(application) {

    private val repository: CategoriesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).categoriesDao()
        repository = CategoriesRepository(dao)
    }

    fun addCategory(category: Category) = repository.insertCategory(category)

    fun getCategories() : LiveData<List<Category>> = repository.getAllCategories()

    fun deleteCategory(id: Int) = repository.deleteCategory(id)

    fun updateCategory(category: Category) = repository.updateCategory(category)
}