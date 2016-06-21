package com.example.gmgn.mysunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gmgn on 3/4/2016.
 */
public class FocastrFragment extends Fragment {
    ArrayAdapter<String> arrayAdapter;
    public FocastrFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//??
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.focastrfragment,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.refresh) {
            FitchWitherTask wethertask=new FitchWitherTask();
            wethertask.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container,false);

        String[] ForcastArray = {"Today - Sunny - 88/63",
                "Tommorow-Foggy-70/40",
                "weds - Cloudy - 72/63",
                "Thurs - Asteroids - 75/65",
                "Fri - Heavy Rains - 65/56",
                "Sat - HELP TRAPPED IN WEATHERSATION - 60/51",
                "Sun - Sunny - 80/68"

        };
        List<String> weekForcast = new ArrayList<String>(Arrays.asList(ForcastArray));
       arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forcasts, R.id.list_item_forecast_textview, weekForcast);
        ListView listView=(ListView)rootview.findViewById(R.id.listview_forecast);
        listView.setAdapter(arrayAdapter);

        return rootview;
    }
}

