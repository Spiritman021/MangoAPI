package com.tworoot2.mangoapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tworoot2.mangoapi.Models.CareerModel;
import com.tworoot2.mangoapi.R;
import com.tworoot2.mangoapi.ViewHolders.Career_ViewHolder;

import java.util.List;

public class Career_Adapter extends RecyclerView.Adapter<Career_ViewHolder> {

    Context context;
    private List<CareerModel> list;
    private List<CareerModel.CareerDetail> careerDetailList;

    public Career_Adapter(Context context, List<CareerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Career_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_career, parent, false);
        return new Career_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Career_ViewHolder holder, int position) {

        CareerModel currentItem = list.get(holder.getAdapterPosition());


        Glide.with(context).load(currentItem.getCareerImage()).into(holder.careerImage);

        holder.careerID.setText(currentItem.getId().toString());
        holder.careerTitle.setText(currentItem.getTitle());
        holder.careerSlug.setText(currentItem.getCareerDetail().getSlug());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}