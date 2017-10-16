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
import java.util.List;

/**
 * Created by Lel on 2017-10-10.
 */

public class CountryAdapter extends ArrayAdapter<Country> {
    Context _context;
    private int region;

    public CountryAdapter(Context context, ArrayList<Country> countries, int Region) {
        super(context, 0, countries);
        this.region = Region;
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
        TextView tvCountryName = (TextView) convertView.findViewById(R.id.display_text);
        if (region == 1) {
            tvCountryName.setText(ctry.getRegion());
        } else {
            tvCountryName.setText(ctry.getName());
        }

        // Return the completed view to render on screen
        return convertView;
    }

}

