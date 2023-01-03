package ua.amv0107.mynote.ui.category.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.databinding.DialogEditorCategoryBinding
import ua.amv0107.mynote.viewmodel.CategoriesViewModel

class EditorCategoryDialog : DialogFragment() {

    private lateinit var dialogBinding: DialogEditorCategoryBinding
    private val args by navArgs<EditorCategoryDialogArgs>()
    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogBinding = DialogEditorCategoryBinding.inflate(layoutInflater)

        if (args.category != null) {
           dialogBinding.edTitleCategory.setText(args.category!!.title)
            dialogBinding.llSample1.visibility = View.GONE
            dialogBinding.llSample2.visibility = View.GONE
            dialogBinding.tvTitleDialog.text = "Rename category"
            dialogBinding.btnYes.text = "Rename"
        }


        setSampleData()

        dialogBinding.btnCancel.setOnClickListener {
            dismiss()
        }
        dialogBinding.btnYes.setOnClickListener {
            if (args.category == null) {
                // If no args, then create a Category
                val data = Category(
                    null,
                    dialogBinding.edTitleCategory.text.toString()
                )
                viewModel.addCategory(data)
            } else {
                // If there are arguments, then opened the Category for editing
                val data = args.category!!.copy(
                    id = args.category!!.id,
                    title = dialogBinding.edTitleCategory.text.toString())
                viewModel.updateCategory(data)
            }

            dismiss()
        }

        return AlertDialog.Builder(requireContext()).setView(dialogBinding.root).create()
    }


    /**
     * Setting Default Values in [edTitleCategory]
     */
    private fun setSampleData() {
        // TODO: Refactor (Возможно сделать RadioButton)
        dialogBinding.tvSample1.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample1.text.toString())
        }
        dialogBinding.tvSample2.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample2.text.toString())
        }
        dialogBinding.tvSample3.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample3.text.toString())
        }
        dialogBinding.tvSample4.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample4.text.toString())
        }
        dialogBinding.tvSample5.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample5.text.toString())
        }
        dialogBinding.tvSample6.setOnClickListener {
            dialogBinding.edTitleCategory.setText("")
            dialogBinding.edTitleCategory.setText(dialogBinding.tvSample6.text.toString())
        }
    }


}