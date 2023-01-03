package ua.amv0107.mynote.ui.editor

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.core.content.ContextCompat
import ua.amv0107.mynote.databinding.FragmentEditorBinding

object FormattingText {

    // TODO: Сейчас можно применить только один стиль форматирования текста, сделать так что бы можно было применять несколько

    fun setBold(binding: FragmentEditorBinding, startPos: Int, endPos: Int) = with(binding) {
        val styles = edDescription.text.getSpans(startPos, endPos, StyleSpan::class.java)
        if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
        edDescription.text.setSpan(StyleSpan(Typeface.BOLD),
            startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        edDescription.text.trim()
        edDescription.setSelection(startPos)
    }

    fun setItalic(binding: FragmentEditorBinding, startPos: Int, endPos: Int) = with(binding) {
        val styles = edDescription.text.getSpans(startPos, endPos, StyleSpan::class.java)
        if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
        edDescription.text.setSpan(StyleSpan(Typeface.ITALIC),
            startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        edDescription.text.trim()
        edDescription.setSelection(startPos)
    }

    fun setUnderlined(binding: FragmentEditorBinding, startPos: Int, endPos: Int) = with(binding) {
            val styles = edDescription.text.getSpans(startPos, endPos, StyleSpan::class.java)
            if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
            edDescription.text.setSpan(UnderlineSpan(),
                startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            edDescription.text.trim()
            edDescription.setSelection(startPos)
        }

    fun setColorTextBackground(binding: FragmentEditorBinding, startPos: Int, endPos: Int,
        color: Int,) = with(binding) {
        val styles = edDescription.text.getSpans(startPos, endPos, StyleSpan::class.java)
        if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
        edDescription.text.setSpan(BackgroundColorSpan(color),
            startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        edDescription.text.trim()
        edDescription.setSelection(startPos)
    }

    fun setColorText(binding: FragmentEditorBinding, context: Context, startPos: Int, endPos: Int,
                     color: Int,) = with(binding) {
            val styles =
                edDescription.text.getSpans(startPos, endPos, ForegroundColorSpan::class.java)
            if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
            edDescription.text.setSpan(ForegroundColorSpan(ContextCompat.getColor(context, color)),
                startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            edDescription.text.trim()
            edDescription.setSelection(startPos)
        }

    fun setTextSize(binding: FragmentEditorBinding, startPos: Int, endPos: Int, size: Int) =
        with(binding) {
            val styles = edDescription.text.getSpans(startPos, endPos, StyleSpan::class.java)
            if (styles.isNotEmpty()) edDescription.text.removeSpan(styles[0])
            edDescription.text.setSpan(RelativeSizeSpan(size.toFloat()/5),
                startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            edDescription.text.trim()
            edDescription.setSelection(startPos)
        }

    // TODO: Выравнивание текста по горизонтали: По левому краю, По центру, По Правому краю 
}
