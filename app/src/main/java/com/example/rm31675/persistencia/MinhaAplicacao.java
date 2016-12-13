package com.example.rm31675.persistencia;

import android.app.Application;
import android.content.Context;

import com.example.rm31675.persistencia.dao.DBHelper;
import com.example.rm31675.persistencia.dao.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * Created by rm31675 on 12/12/2016.
 */
public class MinhaAplicacao extends Application {

    private static Context ctx;

    public void onCreate(){
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        this.ctx = this.getApplicationContext();
        DatabaseManager.initializeInstance(new DBHelper());
    }

    public static Context getContext(){
        return ctx;
    }
}
