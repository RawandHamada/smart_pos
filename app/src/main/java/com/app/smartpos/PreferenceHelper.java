package com.app.smartpos;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private final String Email = "Email";
    private final String NAME = "firstName";
    private final String PASSWORD = "Password";
    private final String MAC="Mac";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared",
                Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(NAME, loginorout);
        edit.commit();
    }
    public boolean getIsLogin() {
        return app_prefs.getBoolean(NAME, false);
    }

    public void putName(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginorout);
        edit.commit();
    }
    public String getName() {
        return app_prefs.getString(NAME, "");
    }

    public void putPassword(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(PASSWORD, loginorout);
        edit.commit();
    }
    public String getPASSWORD() {
        return app_prefs.getString(Email, "");
    }
}


