package com.mdb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CelebListFragment extends Fragment {
    /**
     * Új példány létrehozása az osztályból.
     *
     * @return CelebListFragment
     */
    public static CelebListFragment newInstance() {
        return new CelebListFragment();
    }

    public CelebListFragment() {
        // Empty constructor required for fragment subclasses
    }

    /**
     * Megjeleníti a hirességek listáját.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return hírességeket tartalmazó lista
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_movie_list, null);

        ListView listView = (ListView) rootView.findViewById(R.id.movies_listview);

        //Set and create the adapter
        listView.setAdapter(new CelebListAdapter(getActivity(), MovieGateway.getCelebs()));

        return rootView;
    }
}