package com.mdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CelebListAdapter extends BaseAdapter {
    private List<Celeb> celebs;
    private Context context;

    public CelebListAdapter(Context context, List<Celeb> celebs) {
        this.context = context;
        this.celebs = celebs;
    }

    @Override
    public int getCount() {
        return celebs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        TextView celebNameTextView;
        TextView celebMovieTextView;
        ImageView img;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.celeb_list_item, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.celebNameTextView = (TextView) convertView.findViewById(R.id.celeb_name);
            viewHolder.celebMovieTextView = (TextView) convertView.findViewById(R.id.celeb_movies);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.image_celeb);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Celeb celeb = celebs.get(i);

        viewHolder.celebNameTextView.setText(celeb.getName());
        viewHolder.celebMovieTextView.setText(celeb.getMovies());
        viewHolder.img.setImageResource(celeb.getImg());

        return convertView;
    }
}