package com.example.reviewfragmentrecycler.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reviewfragmentrecycler.fragments.HomeFragment;
import com.example.reviewfragmentrecycler.fragments.PhotoFragment;
import com.example.reviewfragmentrecycler.fragments.TextFragment;

public class AdapterNav extends FragmentStateAdapter {


    public AdapterNav(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new HomeFragment();
        }else if (position==1){
            return new TextFragment();

        }else if (position==2){
            return new PhotoFragment();

        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
