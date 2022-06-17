package com.example.mybrewery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybrewery.adapters.BreweryRecyclerAdapter;
import com.example.mybrewery.models.Brewery;
import com.example.mybrewery.models.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreweryActivity extends AppCompatActivity  {

    List<Brewery> allbrews;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView ;
    BreweryRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        allbrews=new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Constants.BREWS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot brews: snapshot.getChildren()){
                    Brewery brewery = brews.getValue(Brewery.class);
                    allbrews.add(brewery);

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter=new BreweryRecyclerAdapter(allbrews);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.VISIBLE);

    }


}