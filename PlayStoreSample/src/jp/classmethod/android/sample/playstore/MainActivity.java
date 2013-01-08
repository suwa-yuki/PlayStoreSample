package jp.classmethod.android.sample.playstore;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        
        // PagerTitleStrip のカスタマイズ
        PagerTabStrip strip = (PagerTabStrip) findViewById(R.id.strip);
        strip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        strip.setTextColor(Color.WHITE);
        strip.setTextSpacing(50);
        strip.setNonPrimaryAlpha(0.3f);
        strip.setDrawFullUnderline(true);
        strip.setTabIndicatorColor(Color.GREEN);
        
        // ViewPager の Adapter
        GridViewPagerAdapter adapter = new GridViewPagerAdapter(getSupportFragmentManager());
        // GridView の Adapter
        AppListAdapter appListAdapter = new AppListAdapter(getApplication(), R.layout.item_app);
        for (int i = 0; i < 30; i++) {
            App item = new App();
            item.title = "App" + i;
            item.description = "This app is " + i + ".";
            appListAdapter.add(item);
        }
        
        // 各ページアイテム(人気アプリ)
        PageItem popular = new PageItem();
        popular.title = "Popular App";
        popular.fragment = new GridViewFragment();
        popular.fragment.setAdapter(appListAdapter);
        adapter.addItem(popular);
        
        // 各ページアイテム(人気アプリ)
        PageItem recommend = new PageItem();
        recommend.title = "Recommend App";
        recommend.fragment = new GridViewFragment();
        recommend.fragment.setAdapter(appListAdapter);
        adapter.addItem(recommend);
        
        // 各ページアイテム(無料アプリ)
        PageItem free = new PageItem();
        free.title = "Free App";
        free.fragment = new GridViewFragment();
        free.fragment.setAdapter(appListAdapter);
        adapter.addItem(free);
        
        // 各ページアイテム(有料アプリ)
        PageItem paid = new PageItem();
        paid.title = "Paid App";
        paid.fragment = new GridViewFragment();
        paid.fragment.setAdapter(appListAdapter);
        adapter.addItem(paid);
        
        pager.setAdapter(adapter);
    }
}
