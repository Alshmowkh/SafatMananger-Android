package com.alshmowkh.safatmananger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alshmowkh.safatmananger.Classes.Zone;
import com.alshmowkh.safatmananger.R;

import java.util.List;

/**
 * Created by bakee on 11-Jun-19.
 */
public class ZoneAdapter extends BaseAdapter {

    private List list;
    private Context context;

    public ZoneAdapter(Context context, List list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_layout, parent, false);
        }
        TextView lblZoneName = (TextView) convertView.findViewById(R.id.lblZoneName);
        TextView lblZoneID = (TextView) convertView.findViewById(R.id.lblZoneID);

        Zone zone = (Zone) list.get(position);
        lblZoneName.setText(zone.getName());
        lblZoneID.setText(zone.getID() + "");
        return convertView;
    }
}
