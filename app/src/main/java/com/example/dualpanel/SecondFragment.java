package com.example.dualpanel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SecondFragment extends Fragment {

    private int[] imageResource = {R.drawable.spicy_noodles, R.drawable.makisushi, R.drawable.soup, R.drawable.pizza, R.drawable.rice, R.drawable.spaghetti, R.drawable.beef_steak};
    private ImageView imageView;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        imageView = view.findViewById(R.id.image_food);
        SetImageResource(FirstFragment.position);
        return view;
    }

    private void SetImageResource (int position) {
        imageView.setImageResource(imageResource[position]);
    }
}