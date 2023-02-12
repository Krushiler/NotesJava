package com.example.notesjava.presentation.list.note_list_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesjava.databinding.ListItemNoteBinding;
import com.example.notesjava.domain.model.Note;

import java.util.ArrayList;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.ViewHolder> {
    private final ArrayList<Note> items;
    private final OnNoteClick onNoteClick;

    public NotesListAdapter(ArrayList<Note> items, OnNoteClick onNoteClick) {
        this.items = items;
        this.onNoteClick = onNoteClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ListItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false),
                onNoteClick
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemNoteBinding binding;
        private final OnNoteClick onNoteClick;

        public ViewHolder(ListItemNoteBinding binding, OnNoteClick onNoteClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onNoteClick = onNoteClick;
        }

        void bind(Note note) {
            binding.contentLabel.setText(note.getContent());
            binding.titleLabel.setText(note.getTitle());
            binding.getRoot().setOnClickListener(v -> onNoteClick.onNoteClick(note.getId()));
        }
    }
}
