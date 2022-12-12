package ua.amv0107.mynote.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.databinding.FragmentCategoryBinding
import ua.amv0107.mynote.viewmodel.CategoriesViewModel

class CategoryFragment : Fragment(), CategoryAdapter.Listener {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        setupRCView()

        binding.fabAddCategory.setOnClickListener {
            val action =
                CategoryFragmentDirections.actionCategoryFragmentToEditorCategoryDialog(null)
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

    private fun setupRCView() {
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getCategories().observe(viewLifecycleOwner) { categoryList ->
            binding.rvCategory.adapter = CategoryAdapter(requireContext(), categoryList, this)
        }
    }

    override fun popupDelete(category: Category) {
        viewModel.deleteCategory(category.id!!)
        // TODO: Replace Toast with SnackBar
        Toast.makeText(requireContext(), "Delete ${category.title}", Toast.LENGTH_SHORT).show()
    }
}