package com.alshmowkh.safatmananger.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alshmowkh.safatmananger.list_activities.FieldListActivity;

import java.util.List;

/**
 * Created by bakee on 20-Jun-19.
 */
public class FieldAdapter extends BaseAdapter {


    private final List fields;
    private final Context context;

    public FieldAdapter(Context context, List fields) {
        this.context = context;
        this.fields = fields;

    }

    @Override
    public int getCount() {
        return fields.size();
    }

    @Override
    public Object getItem(int position) {
        return fields.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }
}
