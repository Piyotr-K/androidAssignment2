package ca.bcit.ass2.kao_zhang;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static ca.bcit.ass2.kao_zhang.MainActivity.countriesList;

public class CountryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        ListView list = getListView();

        Intent i = getIntent();

        String region = i.getStringExtra("selectedRegion");

        for (int j = 0; j < countriesList.size(); j++) {
            if (countriesList.get(j).getRegion().equalsIgnoreCase(region)) {
            }
        }

        CountryAdapter adapter = new CountryAdapter(CountryActivity.this, countriesList, 0);
        list.setAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int post, long id) {
        Intent i = new Intent(this, CountryDetailActivity.class);
        i.putExtra("country", countriesList.get((int)id).getName());
        startActivity(i);
    }
}
