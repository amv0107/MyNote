package ua.amv0107.mynote.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ua.amv0107.mynote.databinding.LayoutNoteItemBinding
import ua.amv0107.mynote.data.model.Notes

class NotesAdapter(val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(val binding: LayoutNoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutNoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.tvTitle.text = data.title
        holder.binding.tvTextContent.text = data.notes
        holder.binding.tvTime.text = data.data

        holder.binding.root.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToEditorFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = notesList.size
}