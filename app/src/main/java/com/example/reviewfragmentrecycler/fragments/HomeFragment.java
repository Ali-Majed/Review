package com.example.reviewfragmentrecycler.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reviewfragmentrecycler.R;
import com.example.reviewfragmentrecycler.adapter.RecyclerAdapter;
import com.example.reviewfragmentrecycler.modle.Person;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=getView().findViewById(R.id.recycler);
        ArrayList<Person> personArrayList=new ArrayList<>();
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));
        personArrayList.add(new Person("Ali","0592356263"));

        RecyclerAdapter adapter=new RecyclerAdapter(requireContext(),personArrayList);
        recyclerView.setAdapter(adapter);
    }
}