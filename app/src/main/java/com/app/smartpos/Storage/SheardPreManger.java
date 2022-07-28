package com.app.smartpos.Storage;

import android.content.Context;
import android.content.SharedPreferences;


public class SheardPreManger {
    private static final  String SARAD_PREF_NAME="my_sherad_pre";
    private static SheardPreManger mInstance;
    private Context mctx;
    private SheardPreManger(Context mctx){
        this.mctx=mctx;
    }

   public static synchronized SheardPreManger getInstance(Context mctx){
        if (mInstance== null){

            mInstance=new SheardPreManger(mctx);
        }
        return mInstance;
   }
   public  boolean isLoggedIn()
   {
       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
       return sharedPreferences.getInt("id",-1)!=1;

   }

   public  void clear(){
       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.clear();
       editor.apply();

   }
}
