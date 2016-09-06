package com.estudioskelon.pizarra;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nexo on 06/09/2016.
 */
public class SPrefs {

    public static final String TAG = "SPrefs";

    private static final String PREFS_NAME = "MyPrefsFile";
    public static final String KEY_CAMPO = "campo";

    public static void save(Context ctx, Object obj, String key){
        SharedPreferences savedValues = ctx.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = savedValues.edit();

        if (obj instanceof Boolean){
            editor.putBoolean(key, (Boolean) obj);
        }else if (obj instanceof String){
            editor.putString(key, (String) obj);
        }
        editor.commit();
    }

    public static Object load(Context ctx, String key, String type){
        SharedPreferences savedValues = ctx.getSharedPreferences(PREFS_NAME, 0);
        switch (type){
            case "int":
                savedValues.getInt(key, 0);
            case "String":
            default:
                return savedValues.getString(key, "");
        }
    }
}
