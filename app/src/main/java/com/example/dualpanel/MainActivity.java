package com.example.dualpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container_second) != null) {
            isLandscape = true;
            getSupportFragmentManager().popBackStack("second_fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_second, new SecondFragment()).commit();
        }
        else
            isLandscape = false;

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new FirstFragment()).commit();
    }
}