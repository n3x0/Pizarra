package com.estudioskelon.pizarra.activities.pizarra;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.estudioskelon.pizarra.R;

public class PizarraP extends Activity {

    private PizarraM model;
    private PizarraV view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pizarra);
    }
}
