package com.example.orionstark.barberros.controllers.cellviews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.orionstark.barberros.R;
/**
 * Created by evan on 20/06/18.
 */

public class FavoriteRecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView tvName;
    public ImageView iconView,iconFav;
    public LinearLayout listFav;

    public FavoriteRecyclerViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.nama_barber);
        iconView = itemView.findViewById(R.id.icon_barber);
        iconFav = itemView.findViewById(R.id.fav_barber);
        listFav = itemView.findViewById(R.id.rvFav);
    }
}
