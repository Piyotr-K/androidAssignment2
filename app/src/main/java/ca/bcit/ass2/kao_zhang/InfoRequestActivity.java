package ca.bcit.ass2.kao_zhang;

import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InfoRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView manufact = (TextView) findViewById(R.id.manufacturer);
        manufact.setText(Build.MANUFACTURER);
        TextView model = (TextView) findViewById(R.id.model);
        model.setText(Build.MODEL);
        TextView version = (TextView) findViewById(R.id.version);
        version.setText(Build.VERSION.SDK_INT);
        TextView versionRelease = (TextView) findViewById(R.id.version_release);
        versionRelease.setText(Build.VERSION.RELEASE);
        TextView srlNum = (TextView) findViewById(R.id.serial_num);
        srlNum.setText(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
    }
}
