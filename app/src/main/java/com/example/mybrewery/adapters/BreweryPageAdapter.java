package com.example.mybrewery.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.mybrewery.fragments.BreweryDetailFragment;
import com.example.mybrewery.models.Brewery;

import java.util.List;

public class BreweryPageAdapter extends FragmentPagerAdapter {
    private List<Brewery> mRestaurants;

    public BreweryPageAdapter(@NonNull FragmentManager fm, int behavior, List<Brewery> restaurants) {
        super(fm, behavior);
        mRestaurants = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return BreweryDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getStrCategory();
    }
}