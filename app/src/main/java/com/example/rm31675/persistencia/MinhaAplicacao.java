package com.example.rm31675.persistencia;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by rm31675 on 12/12/2016.
 */
public class MinhaAplicacao extends Application {
    public void onCreate(){
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
