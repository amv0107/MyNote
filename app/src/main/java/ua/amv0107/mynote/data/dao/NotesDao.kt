package ua.amv0107.mynote.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.amv0107.mynote.data.model.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Notes)

    @Query("DELETE FROM notes WHERE id=:id")
    fun deleteNote(id: Int)

    @Update
    fun updateNote(note: Notes)
}