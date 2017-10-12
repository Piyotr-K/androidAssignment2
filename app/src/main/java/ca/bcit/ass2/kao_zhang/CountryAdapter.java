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
        TextView tvFirstName = (TextView) convertView.findViewById(R.id.display_text);
        // Populate the data into the template view using the data object
        tvFirstName.setText(ctry.getName());

        ImageView imgOnePhoto = (ImageView) convertView.findViewById(R.id.thumbImage);
        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());
        if (ctry.getFlag() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(ctry.getFlag());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}

