package com.example.mybrewery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mybrewery.adapters.BreweryPageAdapter;
import com.example.mybrewery.models.Brewery;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreweryDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private BreweryPageAdapter adapterViewPager;
    List<Brewery> mRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);

        mRestaurants = (List<Brewery>) getIntent().getSerializableExtra("brews");
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BreweryPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mRestaurants);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}