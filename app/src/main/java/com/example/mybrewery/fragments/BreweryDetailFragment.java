package com.example.mybrewery.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybrewery.R;
import com.example.mybrewery.models.Brewery;

import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreweryDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreweryDetailFragment extends Fragment {
    @BindView(R.id.restaurantImageView) ImageView mImageLabel;
    @BindView(R.id.restaurantNameTextView) TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;


    private Brewery mRestaurant;

    public BreweryDetailFragment() {
        // Required empty public constructor
    }


    public static BreweryDetailFragment newInstance(Brewery restaurant) {
        BreweryDetailFragment restaurantDetailFragment = new BreweryDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("restaurant", restaurant);
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mRestaurant = (Brewery) getArguments().getSerializable("restaurant");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRestaurant.getStrDrinkThumb()).into(mImageLabel);



        mNameLabel.setText(mRestaurant.getStrDrink());
        mCategoriesLabel.setText(mRestaurant.getStrCategory());
        mRatingLabel.setText(mRestaurant.getIdDrink() + "/5");
        mWebsiteLabel.setText(mRestaurant.getStrInstructions());
        mPhoneLabel.setText(mRestaurant.getDateModified());
        mAddressLabel.setText(mRestaurant.getStrGlass());


        return view;
    }



}