package ua.amv0107.mynote.ui.editor.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ua.amv0107.mynote.R
import ua.amv0107.mynote.databinding.DialogSetColorBinding

class SetColorDialog(
    private val listener: Listener,
    private val titleDialog: String,
    private val startPos: Int? = null,
    private val endPos: Int? = null) : BottomSheetDialogFragment() {

    private lateinit var dialogBinding: DialogSetColorBinding
    //private val args by navArgs<SetColorDialogArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialogBinding = DialogSetColorBinding.inflate(layoutInflater, container, false)

        dialogBinding.tvTitleDialog.text = titleDialog

        // TODO: Устанавливать флажок на текущий или новый цвет

        dialogBinding.fab1.setOnClickListener {
            listener.onClickSetColor(R.color.yellow, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab2.setOnClickListener {
            listener.onClickSetColor(R.color.orange_1, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab3.setOnClickListener {
            listener.onClickSetColor(R.color.blue_1, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab4.setOnClickListener {
            listener.onClickSetColor(R.color.orange_2, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab5.setOnClickListener {
            listener.onClickSetColor(R.color.orange_3, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab6.setOnClickListener {
            listener.onClickSetColor(R.color.light_green, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab7.setOnClickListener {
            listener.onClickSetColor(R.color.fiolet, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab8.setOnClickListener {
            listener.onClickSetColor(R.color.blue, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab9.setOnClickListener {
            listener.onClickSetColor(R.color.purple, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab10.setOnClickListener {
            listener.onClickSetColor(R.color.grafit, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab11.setOnClickListener {
            listener.onClickSetColor(R.color.grey, startPos, endPos)
            dismiss()
        }

        dialogBinding.fab12.setOnClickListener {
            listener.onClickSetColor(R.color.white, startPos, endPos)
            dismiss()
        }

        return dialogBinding.root
    }


    interface Listener {
        fun onClickSetColor(color: Int, startPos: Int? = null, endPos: Int? = null) {
        }
    }

    companion object {
        const val SET_COLOR_TEXT = "Set Color Text"
        const val SET_BACKGROUND_COLOR_TEXT = "Set Background Color Text"
        const val SET_BACKGROUND_COLOR_TITLE = "Set Background Color Title"
    }
}