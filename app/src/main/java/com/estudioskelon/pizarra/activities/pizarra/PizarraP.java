package com.estudioskelon.pizarra.activities.pizarra;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.estudioskelon.pizarra.R;
import com.estudioskelon.pizarra.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class PizarraP extends Activity implements View.OnTouchListener, View.OnDragListener {

    private Context ctx;

    private PizarraM model;
    private PizarraV view;

    //Butterknife views
    @BindView(R.id.rojo)
    ImageView rojo;
    @BindView(R.id.naranja)
    ImageView naranja;
    @BindView(R.id.campo)
    RelativeLayout campo;

    //modelo
    private ArrayList<View> vistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizarra);
        ctx = this;
        ButterKnife.bind(this);
        vistas = new ArrayList<>();
        campo.setOnDragListener(this);
        Log.v("LOL", "LOL");
    }

    @OnClick({R.id.rojo, R.id.naranja})
    public void click(View view) {
        ImageView iv = new ImageView(ctx);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(40, 40);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        iv.setBackgroundColor(Color.BLACK);
        iv.setVisibility(View.VISIBLE);
        iv.requestLayout();
        //De momento vamos a taggear las vistas que creemos como fichas para poder moverlas
        iv.setTag("ficha");
        params.leftMargin = Utils.rand(400, 0);
        params.topMargin = Utils.rand(700, 0);

        campo.addView(iv, params);
        campo.requestLayout();

        iv.setOnTouchListener(this);
        Utils.log(true, "LOL", "Ahora tenemos " + vistas.size() + " vistas");
    }

    @OnClick(R.id.campo)
    public void cambioColor(RelativeLayout rl) {
        rl.setBackgroundColor(0x00FF0000);
        Log.v("LAL", "LAL");
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getTag().equals("ficha")) {
            //Es una ficha tiene que poder moverse por el terreno
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundColor(Color.CYAN);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundColor(Color.GREEN);
                break;
            case DragEvent.ACTION_DROP:
                // Dropped, reassign View to ViewGroup
                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                RelativeLayout container = (RelativeLayout) v;
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(40, 40);
                params.leftMargin = (int)event.getX()-20;
                params.topMargin = (int)event.getY()-20;
                container.addView(view, params);
                view.setVisibility(View.VISIBLE);
                Utils.log(true, this.getLocalClassName(), "Drag hasta " + event.getX() + ","+ event.getY());
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setBackgroundColor(Color.GREEN);
            default:
                break;
        }
        return true;
    }
}
