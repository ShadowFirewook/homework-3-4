package com.example.homework_3_4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework_3_4.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick {
    private FragmentFirstBinding binding;
    private ArrayList<Continent> continentsList;
    private ContinentAdapter adapter;
public final static String KEY = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();
        adapter = new ContinentAdapter(continentsList,this);
        binding.resycler.setAdapter(adapter);
    }

    private void loadData() {
        continentsList = new ArrayList<>();
        continentsList.add(new Continent("Asia","https://upload.wikimedia.org/wikipedia/commons/c/c9/Asia_satellite_plane.jpg"));
        continentsList.add(new Continent("Europa","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Europe_satellite_globe.jpg/287px-Europe_satellite_globe.jpg"));
        continentsList.add(new Continent("Africa","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Africa_satellite_plane.jpg/220px-Africa_satellite_plane.jpg"));
        continentsList.add(new Continent("North America","https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/North_America_satellite_globe.jpg/220px-North_America_satellite_globe.jpg"));
        continentsList.add(new Continent("South America","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/South_America_satellite_plane.jpg/220px-South_America_satellite_plane.jpg"));
        continentsList.add(new Continent("Oceania","https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Oceania_satellite.jpg/1200px-Oceania_satellite.jpg"));
    }

    @Override
    public void onItemClick(int position) {
        Continent continent = adapter.getContinent(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY,continent);
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }
}