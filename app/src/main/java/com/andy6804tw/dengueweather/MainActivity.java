package com.andy6804tw.dengueweather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andy6804tw.dengueweather.Fragment.Fragment1;
import com.andy6804tw.dengueweather.Fragment.Fragment2;
import com.andy6804tw.dengueweather.Fragment.WeatherNowFragment;
import com.andy6804tw.spinmenulibrary.OnSpinMenuStateChangeListener;
import com.andy6804tw.spinmenulibrary.SpinMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SpinMenu spinMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinMenu = (SpinMenu) findViewById(R.id.spin_menu);

        // 设置页面标题
        List<String> hintStrList = new ArrayList<>();
        hintStrList.add("热门信息");
        hintStrList.add("实时新闻");
        hintStrList.add("我的论坛");
        hintStrList.add("我的信息");
        hintStrList.add("走走看看");
        hintStrList.add("阅读空间");
        hintStrList.add("听听唱唱");
        hintStrList.add("系统设置");

        spinMenu.setHintTextStrList(hintStrList);
        spinMenu.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu.setHintTextSize(14);

        // 设置启动手势开启菜单
        spinMenu.setEnableGesture(true);

        // 设置页面适配器
        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new WeatherNowFragment());
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        spinMenu.setFragmentAdapter(fragmentPagerAdapter);

        // 设置菜单状态改变时的监听器
        spinMenu.setOnSpinMenuStateChangeListener(new OnSpinMenuStateChangeListener() {
            @Override
            public void onMenuOpened() {
                Toast.makeText(MainActivity.this, "SpinMenu opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(MainActivity.this, "SpinMenu closed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
