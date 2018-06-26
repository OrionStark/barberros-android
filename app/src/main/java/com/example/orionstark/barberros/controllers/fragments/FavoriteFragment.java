package com.example.orionstark.barberros.controllers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orionstark.barberros.R;

public class FavoriteFragment extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rvFav);
        rv.setHasFixedSize(true);
        return view;
    }

}