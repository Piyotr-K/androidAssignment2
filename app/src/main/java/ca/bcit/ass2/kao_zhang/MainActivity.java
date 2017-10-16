package ca.bcit.ass2.kao_zhang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    private Intent countryInt;
    private static String SERVICE_URL = "https://restcountries.eu/rest/v2/all";
    public static ArrayList<Country> countriesList;
    private ArrayList<Country> continentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countriesList = new ArrayList<Country>();
        continentsList = new ArrayList<Country>();
        lv = (ListView) findViewById(R.id.listContinents);
        new GetContacts().execute();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                countryInt = new Intent(MainActivity.this, CountryActivity.class);
                countryInt.putExtra("selectedRegion", ((TextView) v.findViewById(R.id.display_text)).getText().toString());
                startActivity(countryInt);
            }
        });
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray countryJsonArray = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < countryJsonArray.length(); i++) {
                        Double area;
                        JSONObject c = countryJsonArray.getJSONObject(i);
                        JSONArray border = c.getJSONArray("borders");
                        List<String> borderCountries = new ArrayList<String>();
                        String name = c.getString("name");
                        String region = c.getString("region");
                        String capital = c.getString("capital");
                        int population = c.getInt("population");
                        if (c.isNull("area")) {
                            area = 0.0;
                        } else {
                            area = c.getDouble("area");
                        }
                        for (int o = 0; o < border.length(); o++) {
                            borderCountries.add(border.getString(o));
                        }
                        String flagUrl = c.getString("flag");

                        // tmp hash map for single contact
                        Country ctry = new Country();

                        // adding each child node to HashMap key => value
                        ctry.setName(name);
                        ctry.setRegion(region);
                        ctry.setCapital(capital);
                        ctry.setPopulation(population);
                        ctry.setArea(area);
                        ctry.setBorders(borderCountries);
                        ctry.setFlag(flagUrl);

                        // adding contact to contact list
                        countriesList.add(ctry);
                        if (continentsList.size() == 0) {
                            continentsList.add(ctry);
                        } else {
                            if (!containsRegion(continentsList, ctry)) {
                                continentsList.add(ctry);
                            }
                        }
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            CountryAdapter adapter = new CountryAdapter(MainActivity.this, continentsList, 1);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }

        protected boolean containsRegion(ArrayList<Country> List, Country c) {
            boolean found = false;
            for (int j = 0; j < continentsList.size(); j++) {
                if (continentsList.get(j).getRegion().equalsIgnoreCase(c.getRegion())) {
                    found = true;
                }
            }
            return found;
        }
    }

}
