package com.example.memo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class memo02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo02);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        mainFragment mainFragment = new mainFragment();
        settingFragment settingFragment = new settingFragment();

        // 프레그먼트 초기화면 설정
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new mainFragment()).commit();

        // 바텀네비게이션 스위치 작업
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mainFragment).commit();
                        break;

                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, settingFragment).commit();
                        break;
                }
                return true;
            }
        });


    }
}