package com.example.orionstark.barberros.controllers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.adapters.BarberRecyclerAdapter;
import com.example.orionstark.barberros.models.Barber;
import com.example.orionstark.barberros.services.BarberrosService;
import com.example.orionstark.barberros.utils.UserPreference;

public class BarbersFragment extends Fragment {

    private RecyclerView rv;
    View view;
    BarberRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_barbers, container, false);
        view=inflater.inflate(R.layout.fragment_barbers,container,false);
        rv=view.findViewById(R.id.cvBarber);
        adapter= new BarberRecyclerAdapter(this.getContext());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BarberrosService.getBarbers(
                UserPreference.getInstance(getContext()).getUser().getToken(),
                getContext(),
                new BarberrosService.ServiceCallback() {
                    @Override
                    public void onSucceed(String message) {
                        rv.removeAllViews();
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(String message) {
                        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
