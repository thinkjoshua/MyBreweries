package com.example.mybrewery.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybrewery.R;
import com.example.mybrewery.BreweryDetailActivity;
import com.example.mybrewery.models.Brewery;


import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BreweryRecyclerAdapter extends RecyclerView.Adapter<BreweryRecyclerAdapter.RestaurantViewHolder> {
    List<Brewery> businesses;

    public BreweryRecyclerAdapter(List<Brewery> businesses) {
        this.businesses = businesses;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater= LayoutInflater.from(parent.getContext()).inflate(R.layout.brewery,parent,false);
        RestaurantViewHolder view=new RestaurantViewHolder(inflater);
        return view;

    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {

        holder.bindRestaurant(businesses.get(position));
    }

    @Override
    public int getItemCount() {
        return businesses.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurantImageView)
        ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView)
        TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    Intent i = new Intent(mContext, BreweryDetailActivity.class);
                    i.putExtra("position", position);
                    i.putExtra("brews", (Serializable) businesses);
                    mContext.startActivity(i);
                }
            });
        }
        public void bindRestaurant(Brewery restaurant) {
         mNameTextView.setText(restaurant.getStrDrink());
         mCategoryTextView.setText(restaurant.getStrCategory());
         mRatingTextView.setText(restaurant.getIdDrink());
        }
    }
}
