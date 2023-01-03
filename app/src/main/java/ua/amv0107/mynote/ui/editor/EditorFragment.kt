package ua.amv0107.mynote.ui.editor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import ua.amv0107.mynote.R
import ua.amv0107.mynote.data.model.Notes
import ua.amv0107.mynote.databinding.FragmentEditorBinding
import ua.amv0107.mynote.ui.editor.dialogs.SetColorDialog
import ua.amv0107.mynote.ui.editor.dialogs.SetColorDialog.Companion.SET_BACKGROUND_COLOR_TEXT
import ua.amv0107.mynote.ui.editor.dialogs.SetColorDialog.Companion.SET_BACKGROUND_COLOR_TITLE
import ua.amv0107.mynote.ui.editor.dialogs.SetColorDialog.Companion.SET_COLOR_TEXT
import ua.amv0107.mynote.viewmodel.CategoriesViewModel
import ua.amv0107.mynote.viewmodel.NotesViewModel

class EditorFragment : Fragment(), SetColorDialog.Listener {

    val sizeText = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")

    private lateinit var binding: FragmentEditorBinding
    private lateinit var setColorDialog: SetColorDialog
    private val notesViewModel: NotesViewModel by viewModels()
    private val categoriesViewModel: CategoriesViewModel by viewModels()
    private var idCategory: Int = 0
    private var clicked = false
    private var tagSetColorDialog: String = ""
    private var backgroundColorTitle: Int = R.color.yellow
    private var startPos: Int = 0
    private var endPos: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEditorBinding.inflate(layoutInflater, container, false)
        setStatusBarColor(requireContext().getColor(R.color.yellow))

        binding.tvDate.text = TimeManager.getCurrentTime()
        initSpinnerCateory()
        initSpinnerSizeText()
        actionMenuCallback()

        // Listeners
        with(binding) {

            ibImage.setOnClickListener {
                // TODO: Image
                Toast.makeText(requireContext(),
                    "Функция добавления картинки будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            ibMicrophone.setOnClickListener {
                // TODO: Microphone
                Toast.makeText(requireContext(),
                    "Функция добавления голосовых заметок будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            ibCheckBox.setOnClickListener {
                // TODO: CheckBox
                Toast.makeText(requireContext(),
                    "Функция добавления списки будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            ibEdit.setOnClickListener {
                // TODO: EditPhoto
                Toast.makeText(requireContext(),
                    "Функция добавления рисования будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            ibListBulleted.setOnClickListener {
                // TODO: ListBulleted
                // Текущую строку пометить как маркированных список
                Toast.makeText(requireContext(),
                    "Функция добавления маркированного списка будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            ibListNumbered.setOnClickListener {
                // TODO: List Numbered
                // Текущую строку пометить как нумерованный список
                Toast.makeText(requireContext(),
                    "Функция добавления нумерованного списка будет реализована позже",
                    Toast.LENGTH_SHORT).show()
            }

            btnSave.setOnClickListener {
                createNotes(it)
            }

            btnAddCategory.setOnClickListener {
                val action =
                    EditorFragmentDirections.actionEditorFragmentToEditorCategoryDialog(null)
                Navigation.findNavController(it).navigate(action)
            }

            btnMore.setOnClickListener { onAddButtonClickedMoreFAB() }

            imStyleBold.setOnClickListener {
                FormattingText.setBold(this, startPos, endPos)
            }

            imStyleItalic.setOnClickListener {
                FormattingText.setItalic(this, startPos, endPos)
            }

            imStyleUnderlined.setOnClickListener {
                FormattingText.setUnderlined(this, startPos, endPos)
            }

            imStyleColorText.setOnClickListener {
                tagSetColorDialog = SET_COLOR_TEXT
                setColorDialog =
                    SetColorDialog(this@EditorFragment, tagSetColorDialog, startPos, endPos)
                setColorDialog.show(parentFragmentManager, tagSetColorDialog)
            }

            imStyleColorTextBack.setOnClickListener {
                tagSetColorDialog = SET_BACKGROUND_COLOR_TEXT
                setColorDialog =
                    SetColorDialog(this@EditorFragment, tagSetColorDialog, startPos, endPos)
                setColorDialog.show(parentFragmentManager, tagSetColorDialog)
            }

            btnFontNote.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Функция выбора шрифта будет реализована позже",
                    Toast.LENGTH_SHORT
                ).show()
                onAddButtonClickedMoreFAB()
            }

            btnBackgroundNote.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Функция выбора фона заметки будет реализована позже",
                    Toast.LENGTH_SHORT
                ).show()
                onAddButtonClickedMoreFAB()
            }

            btnBackgroundTitle.setOnClickListener {
                tagSetColorDialog = SET_BACKGROUND_COLOR_TITLE
                setColorDialog = SetColorDialog(this@EditorFragment, tagSetColorDialog)
                setColorDialog.show(parentFragmentManager, tagSetColorDialog)
                onAddButtonClickedMoreFAB()
            }

        }
        return binding.root
    }

    @SuppressLint("ResourceType")
    private fun initSpinnerSizeText() {
        val arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, sizeText)
        binding.spinnerSizeText.setAdapter(arrayAdapter)

        binding.spinnerSizeText.setOnItemClickListener { _, _, _, _ ->
            val sizeText = binding.spinnerSizeText.text.toString().toInt()
            FormattingText.setTextSize(binding, startPos, endPos, sizeText)
        }
//        onItemClickListener =
//            OnItemClickListener {
//                    _, _, _, _ ->
//                Toast.makeText(
//                    requireContext(),
//                    "${binding.spinnerSizeText.text.toString()}",
//                    Toast.LENGTH_SHORT).show()
//            }

//        binding.spinnerSizeText.onItemSelectedListener = object : OnItemSelectedListener {
//            override fun onItemSelected(
//                adapterView: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long,
//            ) {
//                val size = sizeText[position].toInt()
//                Toast.makeText(requireContext(), "${binding.spinnerSizeText.selectedItem.toString()}", Toast.LENGTH_SHORT).show()
//                // FormattingText.setTextSize(binding, startPos, endPos, size)
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//        }

    }

    /**
     * Listener for additional FABs
     */
    override fun onClickSetColor(color: Int, startPos: Int?, endPos: Int?) {
        when (tagSetColorDialog) {
            SET_BACKGROUND_COLOR_TITLE -> {
                val c = requireContext().getColor(color)
                backgroundColorTitle = c
                binding.fragmentEditNoteTopBar.setBackgroundColor(c)
                binding.mainCont.setBackgroundColor(c)
                setStatusBarColor(c)
            }
            SET_COLOR_TEXT -> {
                FormattingText.setColorText(binding, requireContext(), startPos!!, endPos!!, color)
            }
            SET_BACKGROUND_COLOR_TEXT -> {
                FormattingText.setColorTextBackground(binding,
                    startPos!!,
                    endPos!!,
                    requireContext().getColor(color))
            }
        }
    }

    /**
     * Set Status Bar Color
     */
    private fun setStatusBarColor(color: Int) {
        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = color
    }

    /**
     * Fun to display additional FABs
     */
    private fun onAddButtonClickedMoreFAB() {
        ExtendedFAB.setVisibilityMoreFAB(binding, clicked)
        ExtendedFAB.setAnimationMoreFAB(binding, clicked)
        ExtendedFAB.setClickableMoreFAB(binding, clicked)
        clicked = !clicked
    }

    /**
     * Initial spinner Category
     */
    private fun initSpinnerCateory() {
        categoriesViewModel.getCategories().observe(viewLifecycleOwner) {
            val adapterSpinner = SpinnerCategoryAdapter(requireContext(), it)
            binding.spinnerCategory.adapter = adapterSpinner
        }

        binding.spinnerCategory.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                val tvIdCategory = view?.findViewById<TextView>(R.id.tv_idCategory)!!
                idCategory = Integer.parseInt(tvIdCategory.text.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    /**
     * Create and save note in ROOM Database
     */
    private fun createNotes(it: View?) {
        val data = Notes(
            id = null,
            title = binding.edTitle.text.toString(),
            notes = binding.edDescription.text.toString(),
            date = TimeManager.getCurrentTime(),
            pin = false,
            color = backgroundColorTitle,
            background = 0,
            category = idCategory,
            isFavorite = false,
            isDelete = false,
            deleteDate = "",
            isArchive = false
        )

        // TODO: Проверку на заполнение данных
        notesViewModel.addNote(data)
        setStatusBarColor(requireContext().getColor(R.color.grafit))
        Toast.makeText(requireContext(), "Notes Created Successfully!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).popBackStack()
    }

    /**
     * Showing menu when selected text
     */
    private fun actionMenuCallback() {
        binding.edDescription.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                hideKeyboard()
                with(binding) {
                    btnMore.visibility = View.GONE
                    mainToolbar.visibility = View.GONE
                    btnSave.visibility = View.GONE
                    toolbarFormatText.visibility = View.VISIBLE
                }
                startPos = binding.edDescription.selectionStart
                endPos = binding.edDescription.selectionEnd
                return true
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                hideKeyboard()
                with(binding) {
                    btnMore.visibility = View.GONE
                    mainToolbar.visibility = View.GONE
                    btnSave.visibility = View.GONE
                    toolbarFormatText.visibility = View.VISIBLE
                }
                startPos = binding.edDescription.selectionStart
                endPos = binding.edDescription.selectionEnd
                return true
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return true
            }

            override fun onDestroyActionMode(p0: ActionMode?) {

            }
        }
    }


    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}