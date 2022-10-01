package com.alshmowkh.safatmananger.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alshmowkh.safatmananger.Classes.Zone;
import com.alshmowkh.safatmananger.R;
import com.alshmowkh.safatmananger.database.DatabaseAccess;
import com.alshmowkh.safatmananger.utiles.Utile;

public class ZoneActiv extends AppCompatActivity {
    private EditText txtNo;
    private EditText txtName;
    private EditText txtNote;
    private ImageView img;

    private DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_zone);

        txtNo = (EditText) findViewById(R.id.txtNoZone);
        txtName = (EditText) findViewById(R.id.txtNameZone);
        txtNote = (EditText) findViewById(R.id.txtNoteZone);
        img = (ImageView) findViewById(R.id.imgZone);

        db = DatabaseAccess.getInstance(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_zone, menu);
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

    public void onClickedSaveZone(View view) {
        Zone zone;
//        zone= new Zone();
        String no = txtNo.getText().toString();
        int id = Integer.parseInt(no);
        String name = txtName.getText().toString();
        String note = txtNote.getText().toString();
        Bitmap photo = ((BitmapDrawable) img.getDrawable()).getBitmap();

        zone = new Zone(id, name, note, photo);
        try {
            db.addZone(zone);
        } catch (Exception ex) {
            Utile.message(getApplicationContext(), "Error at : " + ex.getMessage());
        }
        Utile.message(getApplicationContext(), name + " is saved.");

    }

    public void onClickedChangePhoto(View view) {

    }
}
