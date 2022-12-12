package ua.amv0107.mynote.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import ua.amv0107.mynote.R
import ua.amv0107.mynote.databinding.FragmentMainBinding
import ua.amv0107.mynote.viewmodel.NotesViewModel

 class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        binding.rcNotes.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel.getNote().observe(viewLifecycleOwner) { notesList ->
            binding.rcNotes.adapter = NotesAdapter(notesList)
        }

        binding.fabAddNote.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_editorFragment)
        }
        binding.imgMenu.setOnClickListener {
            // TODO: Как то нужно открыть DrawerMainMenu 
        }


        return binding.root
    }
}