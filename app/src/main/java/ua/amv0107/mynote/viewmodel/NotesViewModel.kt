package ua.amv0107.mynote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ua.amv0107.mynote.data.NotesDatabase
import ua.amv0107.mynote.data.model.Notes
import ua.amv0107.mynote.data.repository.NotesRepository

class NotesViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNote(note: Notes) = repository.insertNote(note)

    fun getNote() : LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNote(id: Int) = repository.deleteNote(id)

    fun updateNote(note: Notes) = repository.updateNote(note)
}