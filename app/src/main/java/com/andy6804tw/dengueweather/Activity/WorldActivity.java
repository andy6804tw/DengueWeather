package com.andy6804tw.dengueweather.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.andy6804tw.dengueweather.Adapter.ViewPagerAdapter;
import com.andy6804tw.dengueweather.Fragment.AlertFragment;
import com.andy6804tw.dengueweather.Fragment.NoticeFragment;
import com.andy6804tw.dengueweather.R;
import com.andy6804tw.dengueweather.SpinMenu.SpinMenu;

public class WorldActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("world");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpinMenu. openMenu();
                finish();
            }
        });
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new AlertFragment(),"今日行程");
        viewPagerAdapter.addFragments(new NoticeFragment(),"今日進度");

        //setupTabIcons();
    }
    @Override
    protected void onResume() {

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        super.onResume();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)//手機按鈕事件
    {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&(event.getAction() == KeyEvent.ACTION_DOWN))
        {
            SpinMenu. openMenu();
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    public void onClick(View view) {
        SpinMenu. openMenu();
        finish();
    }
}