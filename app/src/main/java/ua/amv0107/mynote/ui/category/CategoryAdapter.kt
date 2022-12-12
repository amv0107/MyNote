package ua.amv0107.mynote.ui.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ua.amv0107.mynote.R
import ua.amv0107.mynote.data.model.Category
import ua.amv0107.mynote.databinding.LayoutCategoryItemBinding

class CategoryAdapter(val context: Context, private val categoryList: List<Category>, val listener: Listener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: LayoutCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var mMenu = binding.imMore

        init {
            mMenu.setOnClickListener { popupMenu(it) }
        }


        private fun popupMenu(v: View) {
            val position = categoryList[adapterPosition]
            val popupMenu = PopupMenu(context, v)
            popupMenu.inflate(R.menu.popup_category)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.popup_edit -> {
                        val action =
                            CategoryFragmentDirections.actionCategoryFragmentToEditorCategoryDialog(
                                position
                            )
                        Navigation.findNavController(v).navigate(action)
                       true
                    }
                    R.id.popup_delete -> {
                        // TODO: Confirmation action
                        listener.popupDelete(position)
                        true
                    }
                    else -> true
                }
            }
            popupMenu.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenu)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout =
            LayoutCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = categoryList[position]
        holder.binding.tvTitle.text = data.title
        // TODO: Подсчет количества повторений каждой категории

        holder.binding.imLock.setOnClickListener {
            Toast.makeText(
                context,
                "Функция блокировки будет реализована в следующих версиях.",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.binding.root.setOnLongClickListener {
            Toast.makeText(
                context,
                "Функция перемещения будет реализована в следующих версиях.",
                Toast.LENGTH_SHORT
            ).show()
            true
        }
        holder.binding.imDrag.setOnLongClickListener {
            Toast.makeText(
                context,
                "Функция перемещения будет реализована в следующих версиях.",
                Toast.LENGTH_SHORT
            ).show()
            true
        }
    }

    override fun getItemCount() = categoryList.size

    interface Listener {
        /**
         * Удаление категории
         */
        fun popupDelete(category: Category)
    }
}