package com.alshmowkh.safatmananger.Classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alshmowkh.safatmananger.R;
import com.alshmowkh.safatmananger.activities.FieldActiv;

/**
 * Created by bakee on 17-Jun-19.
 */
public class SaveListener implements View.OnClickListener {
    private EditText fieldNo;
    private EditText fieldName;
    private EditText fieldactArea;
    private EditText fieldDocArea;
    private EditText fieldAlmonds;
    private EditText fieldGates;
    private EditText fieldNote;
    private EditText fieldPhoto;

    private int ZoneID;
    private String zoneName;
    private FieldActiv fieldActiv;
    public SaveListener(String spin1, String spin2) {
       zoneName=spin1;
    }

    public SaveListener(FieldActiv fieldActiv, String spin1, String spin2) {
        zoneName=spin1;
        this.fieldActiv=fieldActiv;
    }

    @Override
    public void onClick(View v) {
        EditText fieldNo=(EditText) fieldActiv.findViewById(R.id.txtFieldID);
        EditText fieldName=(EditText) fieldActiv.findViewById(R.id.txtFieldName);
        EditText fieldactArea=(EditText) fieldActiv.findViewById(R.id.txtFieldAcualArea);
        EditText fieldDocArea=(EditText) fieldActiv.findViewById(R.id.txtFieldDocArea);
        EditText fieldAlmonds=(EditText) fieldActiv.findViewById(R.id.txtFieldAlmonds);
        EditText fieldGates=(EditText) fieldActiv.findViewById(R.id.txtFieldGates);
        EditText fieldNote=(EditText) fieldActiv.findViewById(R.id.txtFieldNotes);
        ImageView fieldPhoto=(ImageView) fieldActiv.findViewById(R.id.imgField);

        String id=fieldNo.getText().toString();
        String name=fieldNo.getText().toString();
        String areaR=fieldNo.getText().toString();
        String areaD=fieldNo.getText().toString();
        String almonds=fieldNo.getText().toString();
        String gates=fieldNo.getText().toString();
        String note=fieldNo.getText().toString();
        fieldPhoto.buildDrawingCache();
       Bitmap photo=fieldPhoto.getDrawingCache();
       // Bitmap photo = ((BitmapDrawable) img.getDrawable()).getBitmap();


    }
}
