package com.mdb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MovieListFragment extends Fragment {


    private static final String IS_WATCHLIST = "IS_WATCHLIST";
    private static int isWactList;

    /**
     * Osztály példányosítás.
     *
     * @param isWactList  ha 1 a film benne van a megnézendő filmek listájában
     * @return MovieListFragment
     */
    public static MovieListFragment newInstance(int isWactList) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(IS_WATCHLIST, isWactList);
        fragment.setArguments(args);
        return fragment;
    }

    public MovieListFragment() {
        // Empty constructor required for fragment subclasses
    }

    /**
     * Megjeleníti a filmek listáját.Ha az IS_WATCHLIST 1, akkor
     * a watchlist-al tölti fel a listát.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return filmek listája
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_movie_list, null);
        //int i = getArguments().getInt(ARG_INDEX);
        //String planet = getResources().getStringArray(R.array.titles_array)[i];

        ListView listView = (ListView) rootView.findViewById(R.id.movies_listview);

        isWactList = getArguments().getInt(IS_WATCHLIST);

        //Set and create the adapter
        List<Movie> movies = isWactList == 0 ? MovieGateway.getmovies() : MovieGateway.getWatchList();
        listView.setAdapter(new MovieListAdapter(getActivity(), movies));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //public void moveToDetailFragment(int position) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.scale_up, R.anim.fade_out, R.anim.scale_up, R.anim.fade_out);
                transaction.replace(R.id.content_frame, MovieDetailFragment.newInstance(position, isWactList));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;
    }
}
