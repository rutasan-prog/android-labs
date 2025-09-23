package com.example.myfirstapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Адаптер RecyclerView, который связывает список имён с макетом элемента списка.
 */

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NameViewHolder> {

    public interface OnNameClickListener {
        void onNameClick(@NonNull String name);
    }

    private final List<String> names;
    @Nullable
    private final OnNameClickListener onNameClickListener;

    public NamesAdapter(@NonNull List<String> names, @Nullable OnNameClickListener onNameClickListener) {
        this.names = names;
        this.onNameClickListener = onNameClickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name, parent, false);
        return new NameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        final String name = names.get(position);
        holder.nameTextView.setText(name);
        holder.itemView.setOnClickListener(view -> {
            if (onNameClickListener != null) {
                onNameClickListener.onNameClick(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    /**
     * ViewHolder хранит ссылку на TextView, отображающую отдельное имя списка.
     */
    static class NameViewHolder extends RecyclerView.ViewHolder {

        final TextView nameTextView;

        NameViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tvName);
        }
    }
}