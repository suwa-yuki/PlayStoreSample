package jp.classmethod.android.sample.playstore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

public class GridViewFragment extends Fragment {
    
    private GridView mGridView;
    private ListAdapter mAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        mGridView = new GridView(getActivity());
        mGridView.setNumColumns(2);
        mGridView.setAdapter(mAdapter);
        
        return mGridView;
    }
    
    public void setAdapter(ListAdapter adapter) {
        mAdapter = adapter;
    }

}
