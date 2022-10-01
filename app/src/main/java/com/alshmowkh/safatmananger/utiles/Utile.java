package com.alshmowkh.safatmananger.utiles;

import android.content.Context;
import android.widget.Toast;

import com.alshmowkh.safatmananger.MainActivity;

/**
 * Created by bakee on 12-Jun-19.
 */
public class Utile {

    public static void message(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
