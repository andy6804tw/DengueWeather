package com.andy6804tw.dengueweather;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.andy6804tw.dengueweather.Fragment.EarthMapFragment;
import com.andy6804tw.dengueweather.Fragment.Fragment1;
import com.andy6804tw.dengueweather.Fragment.Fragment2;
import com.andy6804tw.dengueweather.Fragment.WeatherNowFragment;
import com.dxtt.coolmenu.CoolMenuFrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bt;
    boolean open;
    CoolMenuFrameLayout coolMenuFrameLayout;
    List<Fragment> fragments = new ArrayList<>();

    List<String> titleList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        coolMenuFrameLayout = $(R.id.rl_main);
        String[] titles = {"", "", "",""};
        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);


        fragments.add(new Fragment2());
        fragments.add(new Fragment1());
        fragments.add(new EarthMapFragment());
        fragments.add(new WeatherNowFragment());


        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }
}
