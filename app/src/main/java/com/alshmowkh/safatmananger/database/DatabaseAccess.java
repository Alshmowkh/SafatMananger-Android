package com.alshmowkh.safatmananger.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.alshmowkh.safatmananger.Classes.Field;
import com.alshmowkh.safatmananger.Classes.Zone;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakee on 10-Jun-19.
 */
public class DatabaseAccess {
    private SQLiteDatabase SQLdb;
    private SQLiteHelper helper;
    private Context context;
    private static volatile DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.context = context;
        helper = new SQLiteHelper(context);
    }

    public static synchronized DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }

        return instance;
    }

    public boolean open() {
        SQLdb = helper.getWritableDatabase();
        return SQLdb.isOpen();
    }

    public boolean close() {
        if (SQLdb != null) {
            SQLdb.close();
        }
        return !SQLdb.isOpen();
    }

    public List getZones() {

        List zones = new ArrayList();
        open();
        SQLdb = helper.getReadableDatabase();
        Cursor cursor = SQLdb.rawQuery("SELECT zone_id,zone_name from zones", null);

        if (cursor != null) {
            cursor.moveToFirst();
            Zone zone;
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                zone = new Zone(id, name, null, null);
                zones.add(zone);
                cursor.moveToNext();
            }
        }

        SQLdb.close();
        return zones;
    }

    public List getBundleZones() {
        List zones = new ArrayList();

        return zones;
    }

    public void addZone(Zone zone) {
        ContentValues values = new ContentValues();
        values.put("zone_id", zone.getID());
        values.put("zone_name", zone.getName());
        values.put("zone_notes", zone.getNote());


        values.put("zone_photo", zone.getBitmapStream());
        SQLdb = helper.getWritableDatabase();
        SQLdb.insert("zones", null, values);
        SQLdb.close();
    }

    public void addField(Field field) {
        ContentValues values = new ContentValues();
        values.put("field_id", field.getID());
        values.put("field_name", field.getName());
        values.put("actual_area", field.getActualArea());
        values.put("doc_area", field.getDocArea());
        values.put("measurer", field.getMeasurer());
        values.put("has_almonds", field.hasAlmonds());
        values.put("has_gates", field.hasGates());
        values.put("field_notes", field.getNote());
        values.put("field_photo", field.getBitmapStream());
        values.put("zone_id", field.getZoneID());
        SQLdb = helper.getWritableDatabase();
        SQLdb.insert("field", null, values);
        SQLdb.close();

    }

    public List getFields() {

        List fields = new ArrayList();
        SQLdb = helper.getReadableDatabase();
        Cursor cursor = SQLdb.rawQuery("SELECT * from fields", null);

        if (cursor != null) {
            cursor.moveToFirst();
            Field field;
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                field = new Field();
                field.setID(cursor.getInt(cursor.getColumnIndex("field_id")));
                field.setName(cursor.getString(cursor.getColumnIndex("field_name")));
                field.setActualArea(cursor.getDouble(cursor.getColumnIndex("actual_area")));
                field.setDocArea(cursor.getDouble(cursor.getColumnIndex("doc_area")));
                field.setMeasurer(cursor.getString(cursor.getColumnIndex("measurer")));
                field.setAlmonds(cursor.getInt(cursor.getColumnIndex("has_almonds")));
                field.setGates(cursor.getInt(cursor.getColumnIndex("has_gates")));
                field.setNotes(cursor.getString(cursor.getColumnIndex("field_notes")));
                field.setPhoto(cursor.getBlob(cursor.getColumnIndex("field_photo")));
                field.setZoneID(cursor.getInt(cursor.getColumnIndex("zone_id")));


                fields.add(field);
                cursor.moveToNext();
            }
        }

        SQLdb.close();
        return fields;
    }
}
