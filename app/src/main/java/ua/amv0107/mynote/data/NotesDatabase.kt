package ua.amv0107.mynote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ua.amv0107.mynote.data.dao.CategoriesDao
import ua.amv0107.mynote.data.dao.NotesDao
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.data.model.Notes

@Database(entities = [Notes::class, Category::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun myNotesDao(): NotesDao
    abstract fun categoriesDao(): CategoriesDao

    companion object{
        @Volatile
        var INSTANCE: NotesDatabase?=null
        fun getDatabaseInstance(context: Context): NotesDatabase {
            val tempInstance= INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val roomDatabaseInstance = Room.databaseBuilder(
                    context,
                    NotesDatabase::class.java,
                    "Notes"
                ).allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}