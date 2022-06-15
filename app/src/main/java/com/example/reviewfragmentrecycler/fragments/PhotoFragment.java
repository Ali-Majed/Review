package com.example.reviewfragmentrecycler.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.reviewfragmentrecycler.R;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URL;

public class PhotoFragment extends Fragment {
ImageView img;
String url="https://lh3.googleusercontent.com/a-/AOh14GgaFJtlJRo2r8dEg1L1iGQxV-n9Anani4a1MwX7=s360-p-rw-no";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img=getView().findViewById(R.id.img);

        Picasso.get().
                load(url).
                into(img);
    }
}