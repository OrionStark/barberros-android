package com.example.orionstark.barberros.controllers.cellviews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orionstark.barberros.R;

public class ProfileCellViewFragment extends RecyclerView.ViewHolder {
    public FrameLayout cell;
    public TextView item_text;
    public ImageView left_icon, right_icon;
    public ProfileCellViewFragment(View itemView) {
        super(itemView);
        cell = itemView.findViewById(R.id.profile_item_cell);
        item_text = itemView.findViewById(R.id.profile_text_view);
        left_icon = itemView.findViewById(R.id.profile_item_icon);
        right_icon = itemView.findViewById(R.id.nav_image_profile);
    }
}
