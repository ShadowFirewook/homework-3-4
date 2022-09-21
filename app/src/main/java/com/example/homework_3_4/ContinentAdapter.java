package com.example.homework_3_4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homework_3_4.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {
        private ArrayList <Continent> continentsList;
private OnItemClick onItemClick;
    public ContinentAdapter(ArrayList<Continent> continentsList, OnItemClick onItemClick) {
        this.continentsList = continentsList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
            viewHolder.bind(continentsList.get(position));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        onItemClick.onItemClick(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return continentsList.size();
    }

    public Continent getContinent(int position){
return continentsList.get(position);
    }

    class ContinentViewHolder extends RecyclerView.ViewHolder{
private ItemContinentBinding binding;

        public ContinentViewHolder(@NonNull ItemContinentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind (Continent continent){
        binding.continentName.setText(continent.getName());
            Glide.with(binding.continentImage).load(continent.getImage()).into(binding.continentImage);
        }

    }
}
