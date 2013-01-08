package jp.classmethod.android.sample.playstore;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AppListAdapter extends ArrayAdapter<App> {

    public AppListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        App item = getItem(position);
        
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_app, parent, false);
        }
        
        TextView title = (TextView) convertView.findViewById(R.id.title_text_view);
        title.setText(item.title);
        
        return convertView;
    }

}
