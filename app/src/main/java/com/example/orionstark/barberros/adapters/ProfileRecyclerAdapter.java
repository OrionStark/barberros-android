package com.example.orionstark.barberros.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orionstark.barberros.R;
import com.example.orionstark.barberros.controllers.cellviews.ProfileCellViewFragment;
import com.example.orionstark.barberros.utils.UserPreference;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_profile_cell_view, parent, false);
        return new ProfileCellViewFragment(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                ((ProfileCellViewFragment) holder).left_icon.setImageDrawable(context.getResources().getDrawable(R.drawable.person));
                ((ProfileCellViewFragment) holder).item_text.setText(UserPreference.getInstance(context).getUser().getFull_name());
                ((ProfileCellViewFragment) holder).right_icon.setVisibility(View.GONE);
                break;
            case 1:
                ((ProfileCellViewFragment) holder).left_icon.setImageDrawable(context.getResources().getDrawable(R.drawable.username_ic));
                ((ProfileCellViewFragment) holder).item_text.setText(UserPreference.getInstance(context).getUser().getUsername());
                ((ProfileCellViewFragment) holder).right_icon.setVisibility(View.GONE);
                break;
            case 2:
                ((ProfileCellViewFragment) holder).left_icon.setImageDrawable(context.getResources().getDrawable(R.drawable.mail_ic));
                ((ProfileCellViewFragment) holder).item_text.setText(UserPreference.getInstance(context).getUser().getEmail());
                ((ProfileCellViewFragment) holder).right_icon.setVisibility(View.GONE);
                break;
            case 3:
                ((ProfileCellViewFragment) holder).left_icon.setImageDrawable(context.getResources().getDrawable(R.drawable.phone));
                ((ProfileCellViewFragment) holder).item_text.setText(UserPreference.getInstance(context).getUser().getNo_telp());
                ((ProfileCellViewFragment) holder).right_icon.setVisibility(View.GONE);
                break;
            case 4:
                ((ProfileCellViewFragment) holder).left_icon.setImageDrawable(context.getResources().getDrawable(R.drawable.logout_ic));
                ((ProfileCellViewFragment) holder).item_text.setText("Logout");
                ((ProfileCellViewFragment) holder).cell.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UserPreference.getInstance(context).clearPreference();
                        ((Activity) context).finish();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
