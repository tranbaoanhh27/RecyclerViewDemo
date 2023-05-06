package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FootballerAdapter extends RecyclerView.Adapter<FootballerAdapter.FootballerViewHolder> {
    private ArrayList<Footballer> footballers;

    public FootballerAdapter(ArrayList<Footballer> footballers) {
        this.footballers = footballers;
    }

    @NonNull
    @Override
    public FootballerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new FootballerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballerViewHolder holder, int position) {
        Footballer footballer = footballers.get(position);
        holder.nameTextView.setText(footballer.getName());
        holder.detailsTextView.setText(footballer.getDetails());
        holder.profileImageView.setImageResource(footballer.getImageId());
    }

    @Override
    public int getItemCount() {
        return footballers.size();
    }

    public class FootballerViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView profileImageView;
        private TextView nameTextView, detailsTextView;

        public FootballerViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews(itemView);
            itemView.setOnClickListener(itemClickHandler);
        }

        private final View.OnClickListener itemClickHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Footballer footballer = footballers.get(position);
                String message = String.format("%s appeared and said:\n\"%s\"", footballer.getName(), footballer.getSpeech());
                Snackbar.make(v, message, BaseTransientBottomBar.LENGTH_INDEFINITE).setAction("Close",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Do nothing, just close the Snack-bar notification
                            }
                        }).show();
            }
        };

        private void findViews(View itemView) {
            profileImageView = itemView.findViewById(R.id.profile_image);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);
        }
    }
}
