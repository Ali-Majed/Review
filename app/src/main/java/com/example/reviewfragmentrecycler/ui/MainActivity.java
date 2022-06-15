package com.example.reviewfragmentrecycler.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.reviewfragmentrecycler.R;
import com.example.reviewfragmentrecycler.adapter.AdapterNav;
import com.example.reviewfragmentrecycler.brodcast.BrodCast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    ViewPager2 viewPager2;
    AdapterNav navAdapter;
    BrodCast brodCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav);
        viewPager2 = findViewById(R.id.view_pager2);


        brodCast=new BrodCast();
        IntentFilter intentFilter=new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

        registerReceiver(brodCast,intentFilter);

        navAdapter = new AdapterNav(this);
        viewPager2.setAdapter(navAdapter);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        viewPager2.setCurrentItem(0);

                        break;
                    case R.id.text:
                        viewPager2.setCurrentItem(1);

                        break;

                    case R.id.photo:
                        viewPager2.setCurrentItem(2);

                }
                return true;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                navigationView.getMenu().getItem(position).setChecked(true);
            }
        });

    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(brodCast);
//    }


}

