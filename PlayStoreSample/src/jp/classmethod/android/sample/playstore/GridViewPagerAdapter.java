package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

import android.os.Bundle;
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
        PageItem item = mList.get(position);
        if (PageItem.RELATIVE == item.fragmentKind) {
            return new RecommendFragment();
        }
        GridViewFragment gridViewFragment = new GridViewFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", item.appList);
        gridViewFragment.setArguments(bundle);
        return gridViewFragment;
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
