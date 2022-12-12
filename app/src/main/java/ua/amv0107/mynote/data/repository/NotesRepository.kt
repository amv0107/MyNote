package ua.amv0107.mynote.data.repository

import androidx.lifecycle.LiveData
import ua.amv0107.mynote.data.dao.NotesDao
import ua.amv0107.mynote.data.model.Notes

class NotesRepository(private val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> = dao.getNotes()

    fun insertNote(note: Notes) = dao.insertNote(note)

    fun deleteNote(id: Int) = dao.deleteNote(id)

    fun updateNote(note: Notes) = dao.updateNote(note)
}