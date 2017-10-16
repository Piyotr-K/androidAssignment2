package ca.bcit.ass2.kao_zhang;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static ca.bcit.ass2.kao_zhang.MainActivity.countriesList;

public class CountryActivity extends AppCompatActivity {

    private ArrayList<Country> cntryDisplayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        ListView list = (ListView) findViewById(R.id.listCountries);

        Intent i = getIntent();

        String region = i.getStringExtra("selectedRegion");

        //Debugging
        //System.out.println("Selected region: " + region);

        cntryDisplayList = new ArrayList<Country>();

        for (int j = 0; j < countriesList.size(); j++) {
            if (countriesList.get(j).getRegion().equalsIgnoreCase(region)) {
                cntryDisplayList.add(countriesList.get(j));
            }
        }

        CountryAdapter adapter = new CountryAdapter(CountryActivity.this, cntryDisplayList, 0);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int post, long id) {
                Intent i = new Intent(CountryActivity.this, CountryDetailActivity.class);
                i.putExtra("country", ((TextView) v.findViewById(R.id.display_text)).getText().toString());
                startActivity(i);
            }
        });
        list.setAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int post, long id) {
        Intent i = new Intent(this, CountryDetailActivity.class);
        i.putExtra("country", countriesList.get((int)id).getName());
        startActivity(i);
    }
}
