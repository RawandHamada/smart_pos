package com.app.smartpos.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.smartpos.User;

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
   public void saveUser(User user ){

       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.putString("Email", user.getEmail());
       editor.putString("phone",user.getPhone());
       editor.putString("Password",user.getPassword());
       editor.apply();
   }
   public  boolean isLoggedIn()
   {
       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
       return sharedPreferences.getInt("id",-1)!=1;

   }
   public User getUser(){
       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
return new User(
        sharedPreferences.getString("Email",null)
        ,sharedPreferences.getString("Password",null)
        ,sharedPreferences.getString("phone",null)
        );

   }
   public  void clear(){
       SharedPreferences sharedPreferences=mctx.getSharedPreferences(SARAD_PREF_NAME,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.clear();
       editor.apply();

   }
}
