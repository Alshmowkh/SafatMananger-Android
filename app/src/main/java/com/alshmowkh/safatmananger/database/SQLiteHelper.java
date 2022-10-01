package com.alshmowkh.safatmananger.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bakee on 10-Jun-19.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DBname = "safatDB.db";
    private final String T_zones = "zones";
    private final String T_fields = "fields";
    private final String T_appendixes = "appendixes";
    private final String T_products = "products";
    private final String T_history = "history";
    private final String T_ownership = "ownership";

    private static final int version = 1;

    public SQLiteHelper(Context context) {
        super(context, DBname, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + T_zones + "(" +
                "zone_id INTEGER PRIMARY KEY NOT NULL," +
                "zone_name TEXT UNIQUE NOT NULL," +
                "zone_notes TEXT," +
                "zone_photo BLOB" +
                ");");
        db.execSQL("CREATE TABLE " + T_fields + "(" +
                "field_id INTEGER PRIMARY KEY NOT NULL," +
                "field_name TEXT NOT NULL," +
                "actual_area REAL," +
                "doc_area REAL," +
                "measurer TEXT DEFAULT 'لبنة'," +
                "has_almonds INTEGER," +
                "has_gates INTEGER," +
                "field_notes TEXT," +
                "field_photo BLOB," +
                "zone_id INTEGER NOT NULL," +
                "FOREIGN KEY (zone_id) REFERENCES " + T_zones + "(zone_id)"+
                ");");
        db.execSQL("CREATE TABLE " + T_appendixes + "(" +
                "appendix_id INTEGER PRIMARY KEY NOT NULL," +
                "appendix_type TEXT NOT NULL," +
                "field_name TEXT," +
                "actual_area REAL," +
                "doc_area REAL," +
                "measurer TEXT DEFAULT 'متر'," +
                "has_almonds INTEGER," +
                "has_gates INTEGER," +
                "appendix_notes TEXT," +
                "appendix_photo BLOB," +
                "field_id INTEGER," +
                "FOREIGN KEY (field_id) REFERENCES " + T_fields + "(field_id)"+
                ");");
        db.execSQL("CREATE TABLE " + T_products + "(" +
                "product_id INTEGER PRIMARY KEY NOT NULL," +
                "product_year INTEGER NOT NULL," +
                "assessed_prod INTEGER," +
                "actual_prod INTEGER," +
                "measurer TEXT DEFAULT 'ثماني'," +
                "product_notes TEXT," +
                "product_photo BLOB," +
                "field_id INTEGER NOT NULL," +
                "appendix_id INTEGER NOT NULL," +
                "FOREIGN KEY (field_id) REFERENCES " + T_fields + "(field_id),"+
                "FOREIGN KEY (appendix_id) REFERENCES " + T_appendixes + "(appendix_id)"+
                ");");
        db.execSQL("CREATE TABLE " + T_ownership + "(" +
                "own_id INTEGER PRIMARY KEY NOT NULL," +
                "own_owner TEXT NOT NULL," +
                "field_type TEXT," +
                "own_date TEXT," +
                "actual_area REAL," +
                "doc_area REAL," +
                "measurer TEXT DEFAULT 'لبنة'," +
                "in_almonds INTEGER," +
                "in_gates INTEGER," +
                "own_notes TEXT," +
                "field_id INTEGER NOT NULL," +
                "FOREIGN KEY (field_id) REFERENCES " + T_fields + "(field_id)"+
                ");");
        db.execSQL("CREATE TABLE " + T_history + "(" +
                "record_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "record_title TEXT," +
                "record_description TEXT," +
                "record_date TEXT," +
                "record_notes TEXT," +
                "record_photo BLOB" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
