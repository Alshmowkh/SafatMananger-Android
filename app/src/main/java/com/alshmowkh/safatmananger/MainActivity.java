package com.alshmowkh.safatmananger;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.alshmowkh.safatmananger.Classes.Zone;
import com.alshmowkh.safatmananger.activities.FieldActiv;
import com.alshmowkh.safatmananger.activities.ZoneActiv;
import com.alshmowkh.safatmananger.adapters.ZoneAdapter;
import com.alshmowkh.safatmananger.database.DatabaseAccess;
import com.alshmowkh.safatmananger.list_activities.FieldListActivity;
import com.alshmowkh.safatmananger.utiles.Utile;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseAccess db;
    private ListView listView;
    TextView lblView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);
        //Button lvFooter = (Button) findViewById(R.id.btnAddZone);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer2_layout, listView, false);
        listView.addFooterView(footer, null, false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
                Zone zone = (Zone) listView.getItemAtPosition(position);
                Utile.message(getApplicationContext(), zone.getName());
                Intent intent = new Intent(MainActivity.this, FieldListActivity.class);
                intent.putExtra("zone_id", zone.getID());
                intent.putExtra("zone_name",zone.getName());
                startActivity(intent);

            }
        });

        db = DatabaseAccess.getInstance(this);
        lblView=findViewById(R.id.lblview);

       lblView.setText("sdfs");

        starting();


    }


    private void starting() {

        List zones = db.getZones();
        ZoneAdapter zoneAdapter = new ZoneAdapter(this, zones);
        listView.setAdapter(zoneAdapter);
        lblView.setText(zones.toString());

    }

    protected void onResume() {
        super.onResume();
        List zones = db.getZones();
        ZoneAdapter zoneAdapter = new ZoneAdapter(this, zones);

        listView.setAdapter(zoneAdapter);
//        Button btn2= new Button(this);
//        btn2.setText("ظيعة جديد");
//        listView.addView(btn2);
//        zoneAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
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
        if (id == R.id.btnBarAdd) {
            Utile.message(this, "yeeees");
            // onClickAddZone(this);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAddZone(View view) {
        Intent intent;
        intent = new Intent(this, FieldActiv.class);
        startActivity(intent);
    }
}
