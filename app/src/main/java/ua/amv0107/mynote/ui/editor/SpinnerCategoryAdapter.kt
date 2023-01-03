package ua.amv0107.mynote.ui.editor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.databinding.LayoutCategorySpinnerBinding

class SpinnerCategoryAdapter(context: Context, categoryList: List<Category>) :
    ArrayAdapter<Category>(context, 0, categoryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {

        val category = getItem(position)
        val binding = LayoutCategorySpinnerBinding.inflate(LayoutInflater.from(context), parent, false)

        category?.let {
            binding.tvIdCategory.text = category.id.toString()
            binding.tvTitleCategory.text = category.title
        }

        return binding.root
    }
}