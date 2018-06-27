package com.example.orionstark.barberros.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.models.Barber;
import com.example.orionstark.barberros.models.favorite;

public class FavoriteRecyclerAdapter extends RecyclerView.Adapter<FavoriteRecyclerAdapter.FavoriteViewHolder>{
    private Context context;
    View view;
    public FavoriteRecyclerAdapter(Context context)
    {
        this.context=context;
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item_row,parent,false);
        FavoriteViewHolder viewHolder=new FavoriteViewHolder(view);
        return  viewHolder;
    }
    @Override
    public void onBindViewHolder(FavoriteViewHolder holder,int position){
        holder.tvName.setText(favorite.fav.get(position).namaBarber);
        holder.iconView.setImageDrawable(view.getResources().getDrawable(R.drawable.next_salon_logo));
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

    public int getItemCount(){
        return favorite.fav.size();
    }

    public  class FavoriteViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;
        public ImageView iconView, iconFav;
        public LinearLayout listFav;

        public FavoriteViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nama_barber);
            iconView = itemView.findViewById(R.id.icon_barber);
            iconFav = itemView.findViewById(R.id.fav_barber);
            listFav = itemView.findViewById(R.id.rvFav);
        }
    }


}

