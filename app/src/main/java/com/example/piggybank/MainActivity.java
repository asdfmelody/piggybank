package com.example.piggybank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//희선 2020-12-22 Bottom navigation - Fragment 화면 전환
//참고 https://lktprogrammer.tistory.com/183
public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment =new MainFragment();
    private SpendFragment spendFragment =new SpendFragment() ;
    private CompareFragment compareFragment = new CompareFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //기본 페이지 - mainFragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, mainFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.mainItem:
                    transaction.replace(R.id.frameLayout, mainFragment).commitAllowingStateLoss();
                    break;
                case R.id.spendItem:
                    transaction.replace(R.id.frameLayout, spendFragment).commitAllowingStateLoss();
                    break;
                case R.id.compareItem:
                    transaction.replace(R.id.frameLayout, compareFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }


}