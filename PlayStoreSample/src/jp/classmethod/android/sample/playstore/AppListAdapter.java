package jp.classmethod.android.sample.playstore;

import java.util.List;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AppListAdapter extends ArrayAdapter<App> {
    
    public AppListAdapter(Context context, int textViewResourceId, List<App> objects) {
        super(context, textViewResourceId, objects);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        App item = getItem(position);
        
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_app, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.title_text_view);
            holder.companyTextView = (TextView) convertView.findViewById(R.id.company_text_view);
            holder.ratingBar = (RatingBar) convertView.findViewById(R.id.rating_bar);
            holder.valueTextView = (TextView) convertView.findViewById(R.id.value_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.titleTextView.setText(item.title);
        holder.companyTextView.setText(item.company);
        holder.ratingBar.setRating(item.rate);
        holder.valueTextView.setText("Åè" + item.value);
        
        return convertView;
    }
    
    private class ViewHolder {
        
        public ImageView imageView;
        public TextView titleTextView;
        public TextView companyTextView;
        public RatingBar ratingBar;
        public TextView valueTextView;
        
    }

}
