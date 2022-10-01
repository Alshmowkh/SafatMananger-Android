package com.alshmowkh.safatmananger.list_activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.alshmowkh.safatmananger.R;
import com.alshmowkh.safatmananger.adapters.FieldAdapter;
import com.alshmowkh.safatmananger.database.DatabaseAccess;

import java.util.List;

public class FieldListActivity extends AppCompatActivity {

    private int zoneId;
    private String zoneName;
    private ListView listView;
    private DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_list);
        Intent intent = getIntent();
        zoneId = intent.getIntExtra("zone_id", 0);
        zoneName = intent.getStringExtra("zone_name");
        this.setTitle(zoneName);

        listView = (ListView) findViewById(R.id.listView1);
        db = DatabaseAccess.getInstance(this);
    }

    protected void onResume() {
        super.onResume();
        List zones = db.getFields();
        FieldAdapter fieldAdapter = new FieldAdapter(this, zones);

        listView.setAdapter(fieldAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_field_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
