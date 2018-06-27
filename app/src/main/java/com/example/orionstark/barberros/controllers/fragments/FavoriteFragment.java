package com.example.orionstark.barberros.controllers.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.adapters.FavoriteRecyclerAdapter;

public class FavoriteFragment extends Fragment {

    View view;
    RecyclerView rv;
    FavoriteRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_favorite,container,false);
        rv=view.findViewById(R.id.rvFav);
        adapter= new FavoriteRecyclerAdapter(this.getContext());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;


    }

}