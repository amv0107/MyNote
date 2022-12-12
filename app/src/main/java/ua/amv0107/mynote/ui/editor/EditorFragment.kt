package ua.amv0107.mynote.ui.editor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import ua.amv0107.mynote.R
import ua.amv0107.mynote.data.model.Notes
import ua.amv0107.mynote.databinding.FragmentEditorBinding
import ua.amv0107.mynote.viewmodel.CategoriesViewModel
import ua.amv0107.mynote.viewmodel.NotesViewModel

class EditorFragment : Fragment() {
    // TODO: В дизайне убрать полоску после Toolbar
    lateinit var binding: FragmentEditorBinding
    private val viewModel: NotesViewModel by viewModels()
    private val categoryViewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditorBinding.inflate(layoutInflater, container, false)

        initSpinner()

        binding.btnSave.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun initSpinner() {
        val spinnerAdapter = ArrayAdapter<Any>(requireContext(),android.R.layout.simple_spinner_item)
        categoryViewModel.getCategories().observe(viewLifecycleOwner){
            it.forEach { category ->
                spinnerAdapter.add(category.title)
            }
        }
        binding.spinnerCategory.adapter = spinnerAdapter
    }

    private fun createNotes(it: View?) {
        val data = Notes(
            null,
            binding.edTitle.text.toString(),
            binding.edDescription.text.toString(),
            ""
        )

        // TODO: Проверку на заполнение данных 
        
        viewModel.addNote(data)

        Toast.makeText(requireContext(), "Notes Created Successfully!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.mainFragment)
    }
}