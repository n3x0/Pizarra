package com.estudioskelon.pizarra;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;

import java.util.Random;

/**
 * Created by Nexo on 22/08/2016.
 */
public class Utils {
    public static int rand(int b, int a){
        Random r = new Random();
        return r.nextInt(a - b) + b;
    }

    public static Point getDeviceScreenSize(Activity act){
        Display display = act.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static void log(boolean force, String className, String msg) {
        Log.i(className, msg);
    }
}
