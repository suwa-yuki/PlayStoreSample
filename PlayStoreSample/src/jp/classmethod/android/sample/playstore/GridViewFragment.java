package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * GridView ‚Ì Fragment.
 */
public class GridViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GridView gridView = new GridView(getActivity());

        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridView.setNumColumns(3);
        } else {
            gridView.setNumColumns(2);
        }

        @SuppressWarnings("unchecked")
        ArrayList<App> list = (ArrayList<App>) getArguments().get("list");
        gridView.setAdapter(new AppListAdapter(getActivity(), R.layout.item_app, list));

        return gridView;
    }

}
