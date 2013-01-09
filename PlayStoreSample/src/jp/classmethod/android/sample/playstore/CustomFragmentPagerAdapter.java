package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * FragmentPagerAdapter.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    /** {@link PageItem} のリスト. */
    private ArrayList<PageItem> mList;
    
    /**
     * コンストラクタ.
     * @param fm {@link FragmentManager}
     */
    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<PageItem>();
    }
    
    @Override
    public Fragment getItem(int position) {
        PageItem item = mList.get(position);
        if (PageItem.RELATIVE == item.fragmentKind) {
            // RelativeLayout の Fragment
            return new RecommendFragment();
        }
        // GridView の Fragment
        GridViewFragment gridViewFragment = new GridViewFragment();
        // Bundle を作成
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
    
    /**
     * アイテムを追加する.
     * @param item {@link PageItem}
     */
    public void addItem(PageItem item) {
        mList.add(item);
    }
    
}
