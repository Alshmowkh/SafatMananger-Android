package com.alshmowkh.safatmananger.Classes;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by bakee on 11-Jun-19.
 */
public class Zone {

    private int ID;
    private String name;
    private String note;
    private Bitmap bitmap;
    private byte[] bitmapStream;

    public Zone(int txtNo, String txtName, String txtNote, Bitmap photo) {
        this.ID = txtNo;
        this.name = txtName;
        this.note = txtNote;
        this.bitmap = photo;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public byte[] getBitmapStream() {
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        return stream.toByteArray();
    }
}
