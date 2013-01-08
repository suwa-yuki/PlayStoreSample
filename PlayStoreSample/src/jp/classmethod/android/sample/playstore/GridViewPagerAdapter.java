package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GridViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<PageItem> mList;
    
    public GridViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<PageItem>();
    }
    
    @Override
    public Fragment getItem(int position) {
        return mList.get(position).fragment;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).title;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
    
    public void addItem(PageItem item) {
        mList.add(item);
    }
    
}
