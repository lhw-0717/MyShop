package com.example.myshop.view;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myshop.R;
import com.example.myshop.fragment.HomeFragment;
import com.example.myshop.fragment.KnowladgeFragment;
import com.example.myshop.fragment.MeFragment;
import com.example.myshop.fragment.NavigationFragment;
import com.example.myshop.fragment.ProjectFragment;


public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private HomeFragment homeFragment;
    private KnowladgeFragment knowladgeFragment;
    private MeFragment meFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        knowladgeFragment = new KnowladgeFragment();
        meFragment = new MeFragment();
        navigationFragment = new NavigationFragment();
        projectFragment = new ProjectFragment();
        transaction.add(R.id.content, homeFragment).add(R.id.content, knowladgeFragment).add(R.id.content, meFragment).add(R.id.content, navigationFragment).add(R.id.content, projectFragment)
                .show(homeFragment).hide(knowladgeFragment).hide(meFragment).hide(navigationFragment).hide(projectFragment)
                .commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.rb1:
                        transaction.show(homeFragment)
                                .hide(knowladgeFragment)
                                .hide(meFragment)
                                .hide(navigationFragment)
                                .hide(projectFragment)
                                .commit();
                        break;
                    case R.id.rb2:
                        transaction.show(knowladgeFragment)
                                .hide(homeFragment)
                                .hide(meFragment)
                                .hide(navigationFragment)
                                .hide(projectFragment)
                                .commit();
                        break;
                    case R.id.rb3:
                        transaction.show(meFragment)
                                .hide(homeFragment)
                                .hide(knowladgeFragment)
                                .hide(navigationFragment)
                                .hide(projectFragment)
                                .commit();
                        break;
                    case R.id.rb4:
                        transaction.show(navigationFragment)
                                .hide(homeFragment)
                                .hide(knowladgeFragment)
                                .hide(meFragment)
                                .hide(projectFragment)
                                .commit();
                        break;
                    case R.id.rb5:
                        transaction.show(projectFragment)
                                .hide(homeFragment)
                                .hide(knowladgeFragment)
                                .hide(navigationFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + checkedId);
                }
            }
        });
    }

    private void initView() {
        rg = findViewById(R.id.rg);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}