package ca.bcit.ass2.kao_zhang;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lel on 2017-10-10.
 */

public class CountryAdapter extends ArrayAdapter<Country> {
    Context _context;
    public CountryAdapter(Context context, ArrayList<Country> countries) {
        super(context, 0, countries);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        Country ctry = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvCountryName = (TextView) convertView.findViewById(R.id.country_name);
        TextView tvCountryCapital = (TextView) convertView.findViewById(R.id.country_capital);
        TextView tvCountryRegion = (TextView) convertView.findViewById(R.id.country_region);
        TextView tvCountryPopulation = (TextView) convertView.findViewById(R.id.country_population);
        TextView tvCountryArea = (TextView) convertView.findViewById(R.id.country_area);
        TextView tvCountryBorders = (TextView) convertView.findViewById(R.id.country_borders);
        // Populate the data into the template view using the data object
        tvCountryName.setText(ctry.getName());
        tvCountryCapital.setText(ctry.getCapital());
        tvCountryRegion.setText(ctry.getRegion());
        tvCountryPopulation.setText("Population: " + ctry.getPopulation());
        tvCountryArea.setText("Area: " + ctry.getArea());
        tvCountryBorders.setText(ctry.getBorders().toString());

        ImageView imgOnePhoto = (ImageView) convertView.findViewById(R.id.country_flag);
        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());
        if (ctry.getFlag() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(ctry.getFlag());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}

