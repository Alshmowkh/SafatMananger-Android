package com.alshmowkh.safatmananger.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.alshmowkh.safatmananger.Classes.Field;
import com.alshmowkh.safatmananger.R;
import com.alshmowkh.safatmananger.database.DatabaseAccess;
import com.alshmowkh.safatmananger.utiles.Utile;

public class FieldActiv extends AppCompatActivity {
   private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activ_field);

     spinner1    = (Spinner) findViewById(R.id.spinTypeNew);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinNewIn);

//        Spinner spinner2 = (Spinner) findViewById(R.id.spinNewIn);
        spinner1.setOnItemSelectedListener(new SpinnerListener());


        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(202020));

        LayoutInflater inflater = LayoutInflater.from(this);
        View mView = inflater.inflate(R.layout.actionbar_layout, null);
        actionBar.setCustomView(mView);
        actionBar.setDisplayShowCustomEnabled(true);


        Button btnSave = (Button) findViewById(R.id.btnBarSave);
        String spin1 = spinner1.getSelectedItem().toString();
        String spin2 = spinner2.getVisibility() == View.VISIBLE ? spinner2.getSelectedItem().toString() : null;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSaveField();
            }
        });

    }

    private void onClickedSaveField() {
        EditText fieldNo=(EditText) findViewById(R.id.txtFieldID);
        EditText fieldName=(EditText) findViewById(R.id.txtFieldName);
        EditText fieldactArea=(EditText) findViewById(R.id.txtFieldAcualArea);
        EditText fieldDocArea=(EditText) findViewById(R.id.txtFieldDocArea);
        EditText fieldAlmonds=(EditText) findViewById(R.id.txtFieldAlmonds);
        EditText fieldGates=(EditText) findViewById(R.id.txtFieldGates);
        EditText fieldNote=(EditText) findViewById(R.id.txtFieldNotes);
        ImageView fieldPhoto=(ImageView) findViewById(R.id.imgField);

        EditText fieldZoneId=(EditText) findViewById(R.id.txtNoZone);

        int id= Integer.parseInt(fieldNo.getText().toString());
        String name=fieldName.getText().toString();
        double areaR= Double.parseDouble(fieldactArea.getText().toString());
        double areaD= Double.parseDouble(fieldDocArea.getText().toString());
        int almonds= Integer.parseInt(fieldAlmonds.getText().toString());
        int gates= Integer.parseInt(fieldGates.getText().toString());
        String note=fieldNote.getText().toString();
        fieldPhoto.buildDrawingCache();
        Bitmap photo=fieldPhoto.getDrawingCache();

        String zoneName=spinner1.getSelectedItem().toString();
        int zoneID= Integer.parseInt(fieldZoneId.getText().toString());
        Field field=new Field(id,name,areaR,areaD,almonds,gates,note,photo,zoneID,zoneName);
  //      public Field(int id, String name, Double areaR, Double areaD, int almonds, int gates, String note, Bitmap photo,int zoneID, String zoneName) {

            try {
            DatabaseAccess db=DatabaseAccess.getInstance(this);
            db.addField(field);
        } catch (Exception ex) {
            Utile.message(getApplicationContext(), "Error at : " + ex.getMessage());
        }
        Utile.message(getApplicationContext(), name + " is saved.");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feild, menu);
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

    private class SpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner2 = (Spinner) findViewById(R.id.spinNewIn);
            //Utile.message(parent.getContext(), spinner2 + "");
            if (parent.getSelectedItem().equals("ظيعة")) {
                spinner2.setVisibility(View.GONE);
            } else {
                spinner2.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
