package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

/**
 * ViewPager を表示する Activity です.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        // PagerTitleStrip のカスタマイズ
        PagerTabStrip strip = (PagerTabStrip) findViewById(R.id.strip);
        strip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        strip.setTextColor(0xff9acd32);
        strip.setTextSpacing(50);
        strip.setNonPrimaryAlpha(0.3f);
        strip.setDrawFullUnderline(true);
        strip.setTabIndicatorColor(0xff9acd32);

        // ViewPager の Adapter
        GridViewPagerAdapter adapter = new GridViewPagerAdapter(getSupportFragmentManager());

        // GridView の Adapter
        ArrayList<App> appList = new ArrayList<App>();
        for (int i = 0; i < 30; i++) {
            App item = new App();
            item.title = "App" + i;
            item.description = "This app is " + i + ".";
            item.company = "Company" + i;
            item.rate = (float) Math.random() * 5;
            item.value = (int) Math.floor((Math.random() * (500 - 80 + 1))) + 80;
            appList.add(item);
        }

        // 各ページアイテム(おすすめアプリ)
        PageItem recommend = new PageItem();
        recommend.title = "Recommend App";
        recommend.fragmentKind = PageItem.RELATIVE;
        adapter.addItem(recommend);

        // 各ページアイテム(人気アプリ)
        PageItem popular = new PageItem();
        popular.title = "Popular App";
        popular.fragmentKind = PageItem.GRID;
        popular.appList = appList;
        adapter.addItem(popular);

        // 各ページアイテム(新着アプリ)
        PageItem newest = new PageItem();
        newest.title = "Newest App";
        newest.fragmentKind = PageItem.GRID;
        newest.appList = appList;
        adapter.addItem(newest);

        pager.setAdapter(adapter);
    }
}
