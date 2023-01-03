package ua.amv0107.mynote.ui.editor

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import ua.amv0107.mynote.R
import ua.amv0107.mynote.databinding.FragmentEditorBinding

/**
 * Show extended FAB
 */
object ExtendedFAB {
     fun setVisibilityMoreFAB(binding: FragmentEditorBinding, clicked: Boolean) {
        if (!clicked) {
            binding.btnFontNote.visibility = View.VISIBLE
            binding.btnBackgroundTitle.visibility = View.VISIBLE
            binding.btnBackgroundNote.visibility = View.VISIBLE
        } else {
            binding.btnFontNote.visibility = View.INVISIBLE
            binding.btnBackgroundTitle.visibility = View.INVISIBLE
            binding.btnBackgroundNote.visibility = View.INVISIBLE
        }
    }

     fun setAnimationMoreFAB(binding: FragmentEditorBinding, clicked: Boolean) {
         val rotateOpen: Animation by lazy {
             AnimationUtils.loadAnimation(
                 binding.root.context,
                 R.anim.rotate_open_anim
             )
         }
          val rotateClose: Animation by lazy {
             AnimationUtils.loadAnimation(
                 binding.root.context,
                 R.anim.rotate_close_anim
             )
         }
          val fromBottom: Animation by lazy {
             AnimationUtils.loadAnimation(
                 binding.root.context,
                 R.anim.from_bottom_anim
             )
         }
          val toBottom: Animation by lazy {
             AnimationUtils.loadAnimation(
                 binding.root.context,
                 R.anim.to_bottom_anim
             )
         }

        if (!clicked) {
            binding.btnFontNote.startAnimation(fromBottom)
            binding.btnBackgroundNote.startAnimation(fromBottom)
            binding.btnBackgroundTitle.startAnimation(fromBottom)
            binding.btnMore.startAnimation(rotateOpen)
        } else {
            binding.btnFontNote.startAnimation(toBottom)
            binding.btnBackgroundNote.startAnimation(toBottom)
            binding.btnBackgroundTitle.startAnimation(toBottom)
            binding.btnMore.startAnimation(rotateClose)
        }
    }

     fun setClickableMoreFAB(binding: FragmentEditorBinding, clicked: Boolean) {
        if (!clicked) {
            binding.btnFontNote.isClickable = true
            binding.btnBackgroundTitle.isClickable = true
            binding.btnBackgroundNote.isClickable = true
        } else {
            binding.btnFontNote.isClickable = false
            binding.btnBackgroundTitle.isClickable = false
            binding.btnBackgroundNote.isClickable = false
        }
    }
}