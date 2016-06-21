package com.example.gmgn.mysunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   if(savedInstanceState==null)
   {
       //???
   getSupportFragmentManager().beginTransaction().add(R.id.container,new FocastrFragment()).commit();
   }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }



   /* public class placeholderFragment extends Fragment {

        public placeholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main,  container, false);


            String[] ForcastArray = {"Today - Sunny - 88/63",
                    "Tommorow-Foggy-70/40",
                    "weds - Cloudy - 72/63",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Heavy Rains - 65/56",
                    "Sat - HELP TRAPPED IN WEATHERSATION - 60/51",
                    "Sun - Sunny - 80/68"

            };
            List<String> weekForcast = new ArrayList<String>(Arrays.asList(ForcastArray));

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forcasts, R.id.list_item_forecast_textview, weekForcast);
            ListView listView = (ListView) view.findViewById(R.id.listview_forecast);
            listView.setAdapter(arrayAdapter);
            return view;
        }
    }*/
}







