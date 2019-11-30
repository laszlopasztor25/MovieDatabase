package com.mdb;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class MovieDetailFragment extends Fragment {

    private static final String ARG_INDEX = "ARG_INDEX";
    private static final String IS_WATCHLIST = "IS_WATCHLIST";

    private Movie movie;
    private ImageView add;
    private int id;

    public static MovieDetailFragment newInstance(int index, int isw) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        args.putInt(IS_WATCHLIST, isw);
        fragment.setArguments(args);
        return fragment;
    }

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        int index = 0;
        int isWachtList = 0;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
            isWachtList = getArguments().getInt(IS_WATCHLIST);
        }


        //Load the views from the inflated layout
        VideoView vidView = (VideoView) view.findViewById(R.id.myVideo);
        TextView titleTextView = (TextView) view.findViewById(R.id.textMovieTitle);
        TextView descTextView = (TextView) view.findViewById(R.id.textMovieDesc);
        TextView castTextView = (TextView) view.findViewById(R.id.textMovieCast);
        TextView dateTextView = (TextView) view.findViewById(R.id.textDate);
        final ImageView img = (ImageView) view.findViewById(R.id.image_movie);
        add = (ImageView) view.findViewById(R.id.image_add);

        movie = isWachtList == 0 ? MovieGateway.getmovies().get(index) : MovieGateway.getWatchList().get(index);

        String vidAddress = "android.resource://" + getActivity().getPackageName() + "/" + movie.getVidId();
        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);
        vidView.seekTo(100);
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(vidView);
        vidView.setMediaController(mediaController);

        titleTextView.setText(movie.getTitle());
        descTextView.setText(movie.getDesc());
        castTextView.setText(movie.getStars());
        dateTextView.setText(movie.getDate().toString("YYYY. MMM dd."));
        img.setImageResource(movie.getImgId());

        id = MovieGateway.getWatchList().contains(movie) ? R.drawable.ic_check : R.drawable.ic_add;
        if (id == R.drawable.ic_check) {
            add.setBackgroundColor(getResources().getColor(R.color.checked));
        }
        add.setImageResource(id);

        add.setOnClickListener(new View.OnClickListener() {
            /**
             * Hozzáadja a filmet a megnézendő filmek listájához.
             * Ha egy film 1 héten belül megjelenik, akkor értesítést ad.
             *
             * @param v add gomb
             */
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                if (id == R.drawable.ic_add) {
                    MovieGateway.getWatchList().add(movie);
                    DateTime currentDate = new DateTime();
                    final int days = Days.daysBetween(currentDate, movie.getDate()).getDays();
                    if (days <= 7) {
                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                                Notification notification = new Notification(R.drawable.warcraft, "Movie", System.currentTimeMillis());
                                String nText = movie.getTitle() + " in Theaters";
                                if (days >= 1) {
                                    nText += " in " + days + " days";
                                }
                                Intent launchIntent = new Intent(getActivity(), MainActivity.class);
                                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), -1, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                                notification.setLatestEventInfo(getActivity(), "Movie", nText, pendingIntent);

                                int NOTIFICATION_ID = 1;
                                notificationManager.notify(NOTIFICATION_ID, notification);
                            }
                        });
                        t.start();
                    }

                    add.setImageResource(R.drawable.ic_check);
                    id = R.drawable.ic_check;
                    add.setBackgroundColor(getResources().getColor(R.color.checked));
                } else {
                    MovieGateway.getWatchList().remove(movie);
                    add.setImageResource(R.drawable.ic_add);
                    id = R.drawable.ic_add;
                    add.setBackgroundColor(getResources().getColor(R.color.claret));
                }
            }
        });
        return  view;
    }


}
