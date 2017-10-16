package ca.bcit.ass2.kao_zhang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import static ca.bcit.ass2.kao_zhang.MainActivity.countriesList;

public class CountryDetailActivity extends AppCompatActivity {

    String selected;
    Country slCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent i = getIntent();
        //Debugging
        //System.out.println("Country selected: " + i.getStringExtra("country"));

        selected = i.getStringExtra("country");
        for (int j = 0; j < countriesList.size(); j++) {
            if (countriesList.get(j).getName().equalsIgnoreCase(selected)) {
                slCountry = countriesList.get(j);
            }
        }

        WebView flag = (WebView) findViewById(R.id.country_flag);
        String html = "<html><body><img src=\"" + slCountry.getFlag() + "\" width='350px' height='200px' />";
        flag.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        TextView name = (TextView) findViewById(R.id.country_name);
        name.setText("Country name: " + slCountry.getName());
        TextView capital = (TextView) findViewById(R.id.country_capital);
        capital.setText("Country capital: " + slCountry.getCapital());
        TextView region = (TextView) findViewById(R.id.country_region);
        region.setText("Country Region: " + slCountry.getRegion());
        TextView population = (TextView) findViewById(R.id.country_population);
        population.setText("Country Population: " + slCountry.getPopulation());
        TextView area = (TextView) findViewById(R.id.country_area);
        area.setText("Country Area: " + slCountry.getArea());
        TextView border = (TextView) findViewById(R.id.country_borders);
        border.setText("Bordering Countries: " + printArrayList(slCountry.getBorders()));
    }

    private String printArrayList(List<String> ls) {
        String outputText = "";
        for (int i = 0; i < ls.size(); i++) {
            outputText += ls.get(i) + " ";
        }
        return outputText;
    }
}
