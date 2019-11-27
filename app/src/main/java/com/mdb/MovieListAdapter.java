package com.mdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends BaseAdapter {
    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
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
        TextView titleTextView;
        TextView starTextView;
        ImageView img;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_list_item, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.text_title);
            viewHolder.starTextView = (TextView) convertView.findViewById(R.id.text_starring);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_movie);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

       final Movie movie = movies.get(i);

        viewHolder.titleTextView.setText(movie.getTitle());
        viewHolder.starTextView.setText(movie.getStars());
        viewHolder.img.setImageResource(movie.getImgId());

        return convertView;
    }
}