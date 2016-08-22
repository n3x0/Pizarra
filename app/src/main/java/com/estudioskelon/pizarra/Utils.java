package com.estudioskelon.pizarra;

import android.util.Log;

import java.util.Random;

/**
 * Created by Nexo on 22/08/2016.
 */
public class Utils {
    public static int rand(int a, int b){
        Random r = new Random();
        return r.nextInt(a - b) + b;
    }

    public static void log(boolean force, String className, String msg) {
        Log.i(className, msg);
    }
}
