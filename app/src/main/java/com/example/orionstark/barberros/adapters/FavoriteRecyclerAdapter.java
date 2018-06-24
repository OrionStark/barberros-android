package com.example.orionstark.barberros.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.cellviews.FavoriteRecyclerViewHolder;
import com.example.orionstark.barberros.itemCardCollection.FavoriteRecyclerViewHolder;
import com.example.orionstark.barberros.model.favorite;

/**
 * Created by evan on 20/06/18.
 */

public class FavoriteRecyclerAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewHolder>{
    LayoutInflater inflater;
    View v;
    Context context;
    public FavoriteRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    @Override
    public FavoriteRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        v = inflater.inflate(R.layout.fragment_favorite, parent, false);
        FavoriteRecyclerViewHolder viewHolder = new FavoriteRecyclerViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(FavoriteRecyclerViewHolder holder, final int position) {
        holder.tvName.setText(favorite.fav.get(position).namaBarber);
        holder.iconView.setImageDrawable(v.getResources().getDrawable(R.drawable.next_salon_logo));
        holder.iconFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startActivity(new Intent(context, About.class).putExtra("barber_data_about", BarberShop.barbers.get(position).nama));
            }
        });
        holder.listFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startActivity( new Intent(context, MakeAppoinment.class).putExtra("barber_data", BarberShop.barbers.get(position).nama) );
            }
        });
    }

    @Override
    public int getItemCount() {
//        return favorite.fav.size();
    }

}
