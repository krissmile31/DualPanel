package com.example.dualpanel;

import static com.example.dualpanel.MainActivity.isLandscape;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FirstFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private ArrayAdapter arrayAdapter;
    private ListView listView;
    public static int position;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.list_food, android.R.layout.simple_expandable_list_item_1);
        setListAdapter(arrayAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        position = i;
        Log.i("position", String.valueOf(i));

        if (!isLandscape)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).addToBackStack("second_fragment").commit();

        else {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_second, new SecondFragment()).commit();
        }
    }
}