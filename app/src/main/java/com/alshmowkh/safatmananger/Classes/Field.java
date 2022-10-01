package com.alshmowkh.safatmananger.Classes;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.ByteArrayOutputStream;

/**
 * Created by bakee on 13-Jun-19.
 */
public class Field {
    private int id;
    private String name;
    private Double areaR;
    private Double areaD;
    private int almonds;
    private int gates;
    private String note;
    private Bitmap photo;
    private String zoneName;
    private String measurer;
    private int zoneID;
    private String notes;

    public Field(int id, String name, Double areaR, Double areaD, int almonds, int gates, String note, Bitmap photo,int zoneID, String zoneName) {

        this.id = id;
        this.name = name;
        this.areaR = areaR;
        this.areaD = areaD;
        this.almonds = almonds;
        this.gates = gates;
        this.note = note;
        this.photo = photo;
        this.zoneName = zoneName;
    }

    public Field() {

    }

    public int getID() {
        return Integer.parseInt(String.valueOf(id));
    }

    public String getName() {
        return name;
    }

    public double getActualArea() {
        return Double.parseDouble(String.valueOf(areaR));
    }

    public double getDocArea() {
        return Double.parseDouble(String.valueOf(areaD));
    }

    public String getMeasurer() {
        return measurer;
    }

    public int hasAlmonds() {
        return Integer.parseInt(String.valueOf(almonds));
    }

    public int hasGates() {
        return Integer.parseInt(String.valueOf(gates));
    }

    public String getNote() {
        return note;
    }

    public Image getPhoto() {
        return null;
    }

    public byte[] getBitmapStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    public int getZoneID() {
        return zoneID;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasurer(String measurer) {
        this.measurer = measurer;
    }


    public void setAlmonds(int almonds) {
        this.almonds = almonds;
    }

    public void setGates(int gates) {
        this.gates = gates;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPhoto(byte[] photo) {
       // this.photo = photo;
    }

    public void setZoneID(int zoneID) {
        this.zoneID = zoneID;
    }

    public void setActualArea(double actualArea) {
        this.areaR = actualArea;
    }

    public void setDocArea(double actualArea) {
        this.areaR = actualArea;
    }
}
