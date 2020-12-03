package com.example.pertemuan5mobile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;


public class ListsFragment extends Fragment {
    private RecyclerView rvFoodies;
    private ArrayList<Food> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lists, container, false);

        // Add the following lines to create RecyclerView
        rvFoodies = view.findViewById(R.id.rv_foodies);
        rvFoodies.setHasFixedSize(true);
        rvFoodies.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvFoodies.setAdapter(new GridFoodAdapter(getContext(), list));
        list.addAll(FoodData.getListData());
        showRecyclerGrid();

        return view;
    }

    private void showRecyclerGrid(){
        rvFoodies.setLayoutManager(new GridLayoutManager(getContext(), 1));
        GridFoodAdapter gridFoodAdapter = new GridFoodAdapter(getContext(), list);
        rvFoodies.setAdapter(gridFoodAdapter);
    }
}