package com.example.gmgn.mysunshine;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gmgn on 3/8/2016.
 */
public class FitchWitherTask extends AsyncTask< String, Void, Void> {

    private final String log_tag=FitchWitherTask.class.getSimpleName();

    @Override
    protected Void doInBackground(String... params) {
        if(params.length==0)
        {
            return null;
        }
        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;
        String format="json";
        String units="metric";
        int numDays=7;

        try {
            // Construct the URL for the OpenWeatherMap query
            // Possible parameters are avaiable at OWM's forecast API page, at
            // http://openweathermap.org/API#forecast
            URL url  = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");

                            final String FORECAST_BASE_URL =
                                           "http://api.openweathermap.org/data/2.5/forecast/daily?";
                            final String QUERY_PARAM = "q";
                            final String FORMAT_PARAM = "mode";
                            final String UNITS_PARAM = "units";
                            final String DAYS_PARAM = "cnt";
                            final String APPID_PARAM = "APPID";

                                    Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
                                            .appendQueryParameter(QUERY_PARAM, params[0])
                                            .appendQueryParameter(FORMAT_PARAM, format)
                                           .appendQueryParameter(UNITS_PARAM, units)
                                            .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
                                            .appendQueryParameter(APPID_PARAM, BuildConfig.OPEN_WEATHER_MAP_API_KEY)
                                            .build();
                           URL ur1  = new URL(builtUri.toString());
            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            Log.v(log_tag,"done");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            forecastJsonStr = buffer.toString();
        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }

        return null;
    }
}