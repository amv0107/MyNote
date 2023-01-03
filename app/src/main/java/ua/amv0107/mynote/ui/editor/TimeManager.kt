package ua.amv0107.mynote.ui.editor

import java.text.SimpleDateFormat
import java.util.*

/**
 * Получение текущего времени
 */
object TimeManager {

    fun getCurrentTime(): String{
        val formatter = SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }
}