package com.tworoot2.mangoapi.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tworoot2.mangoapi.R;

public class Career_ViewHolder extends RecyclerView.ViewHolder {

    public ImageView careerImage;
    public TextView careerID, careerTitle, careerSlug;

    public Career_ViewHolder(@NonNull View itemView) {
        super(itemView);

        careerImage = (ImageView) itemView.findViewById(R.id.careerImage);
        careerID = (TextView) itemView.findViewById(R.id.careerID);
        careerTitle = (TextView) itemView.findViewById(R.id.careerTitle);
        careerSlug = (TextView) itemView.findViewById(R.id.careerSlug);

    }
}
