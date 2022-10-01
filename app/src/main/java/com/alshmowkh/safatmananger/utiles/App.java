package com.alshmowkh.safatmananger.utiles;

import android.app.Application;
import android.content.Context;

/**
 * Created by bakee on 12-Jun-19.
 */
public class App extends Application {
    private  static Context context;


    public void onCreate(){
        super.onCreate();
        App.context=getApplicationContext();
    }
    public static Context getContext(){
        return App.context;
    }
}
