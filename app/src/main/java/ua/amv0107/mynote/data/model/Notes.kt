package ua.amv0107.mynote.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)    var id: Int? = null,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "notes") var notes: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "pin") var pin: Boolean = false,
    @ColumnInfo(name = "color") var color: Int,
    @ColumnInfo(name = "background") var background: Int,
    @ColumnInfo(name = "category") var category: Int = 0,
    @ColumnInfo(name = "favorite") var isFavorite: Boolean = false,
    @ColumnInfo(name = "delete") var isDelete: Boolean = false,
    @ColumnInfo(name = "deleteDate") var deleteDate: String?,
    @ColumnInfo(name = "archive") var isArchive: Boolean = false
)
