package com.example.orionstark.barberros.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.activities.MoreinfoActivity;
import com.example.orionstark.barberros.models.Barber;


public class BarberRecyclerAdapter extends RecyclerView.Adapter<BarberRecyclerAdapter.CardViewHolder>{
    private Context context;
    public BarberRecyclerAdapter(Context context)
    {
        this.context=context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.barber_item_row,parent,false);
        CardViewHolder viewHolder=new CardViewHolder(view);
        return  viewHolder;
    }
    @Override
    public void onBindViewHolder(CardViewHolder holder,int position){

    }

    public int getItemCount(){
       if ( Barber.barbers.size() > 0 ) {
           return Barber.barbers.size();
       } else {
           return  0;
       }

    }

    public  class CardViewHolder extends RecyclerView.ViewHolder{
       Button btnMore;
       Button btnBook;
       ImageView btnFav;
       TextView txtBarber;
       ImageView icon;




        public CardViewHolder(View itemView){
            super(itemView);
            btnMore = itemView.findViewById(R.id.btn_more);
            btnBook= itemView.findViewById(R.id.btn_book);
            btnFav= itemView.findViewById(R.id.btn_fav);
            txtBarber= itemView.findViewById(R.id.txtBarber);
       //     icon = itemView.findViewById(R.id.Barbericon);

        }
    }


}
