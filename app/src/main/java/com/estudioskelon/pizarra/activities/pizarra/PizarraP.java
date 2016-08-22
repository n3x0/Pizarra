package com.estudioskelon.pizarra.activities.pizarra;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.estudioskelon.pizarra.R;
import com.estudioskelon.pizarra.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class PizarraP extends Activity{

    private Context ctx;

    private PizarraM model;
    private PizarraV view;

    //Butterknife views
    @BindView(R.id.rojo) ImageView rojo;
    @BindView(R.id.naranja) ImageView naranja;
    @BindView(R.id.campo) RelativeLayout campo;

    //modelo
    private ArrayList<View> vistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizarra);
        ctx = this;
        ButterKnife.bind(this);
        vistas = new ArrayList<>();
        Log.v("LOL", "LOL");
    }

    @OnClick({R.id.rojo, R.id.naranja})
    public void click(View view) {

        RelativeLayout.LayoutParams imParams = new RelativeLayout.LayoutParams(40, 40);
        ImageView vista = new ImageView(ctx);
        campo.addView(vista,imParams);


        if (view == rojo) {
            vista.setBackgroundColor(0x00FF0000);
        } else if (view == naranja){
            vista.setBackgroundColor(0x00FF9900);
        }

        vistas.add(vista);
        Utils.log(true, "LOL", "Ahora tenemos " + vistas.size() + " vistas");

    }

    @OnClick(R.id.campo)
    public void cambioColor(RelativeLayout rl){
        rl.setBackgroundColor(0x00FF0000);
        Log.v("LAL", "LAL");
    }
}
