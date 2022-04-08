package com.example.newsapirecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapirecyclerview.databinding.RowItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> modelArrayList;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.bind(modelArrayList.get(position));
        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).circleCrop().into(holder.rowItemBinding.imageView);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RowItemBinding rowItemBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowItemBinding = DataBindingUtil.bind(itemView);

            assert rowItemBinding != null;
        }

        public void bind (Model model){
            rowItemBinding.setRowitem(model);
        }
    }
}
