package com.estudioskelon.pizarra.activities.pizarra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.estudioskelon.pizarra.R;
import com.estudioskelon.pizarra.Utils;
import com.estudioskelon.pizarra.tipos.contenedores.Campo;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.estudioskelon.pizarra.tipos.contenedores.Campo.Tipo.futbol;

/**
 * Created by Nexo on 01/09/2016.
 * La vista debe ser responsable de:
 * Instantiating the Presenter, and its binding/unbinding mechanism
 * Informing the Presenter of relevant lifecycle events
 * Informing the Presenter of input events
 * Laying out the views and binding data to them
 * Animations
 * Event tracking
 * Navigating to other screens

 */
public class PizarraV extends Activity implements View.OnClickListener {
    private static final String TAG = "PizarraV";

    private Button bTGuardar;
    private Button bTCargar;
    private View vTRojo;
    private View vTNaranja;
    private RelativeLayout rLCampo;

    private PizarraP presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizarra);
        presenter = new PizarraP(this);
        enlazar();
        Utils.log(true, TAG, "El tamaño de la pantalla es: " + Utils.getDeviceScreenSize(this).toString());
    }

    private void enlazar() {
        bTGuardar = (Button) findViewById(R.id.bTGuardar);
        bTGuardar.setOnClickListener(this);
        vTRojo = (View) findViewById(R.id.rojo);
        vTRojo.setOnClickListener(this);
        vTNaranja = (View) findViewById(R.id.naranja);
        vTNaranja.setOnClickListener(this);
        rLCampo = (RelativeLayout) findViewById(R.id.campo);
        bTCargar = (Button) findViewById(R.id.bTCargar);
        bTCargar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bTGuardar:
                presenter.saveCampo(this);
                break;
            case R.id.rojo:
            case R.id.naranja:
                presenter.addFicha();
                break;
            case R.id.bTCargar:
                presenter.loadCampo(this);
                break;
            default:break;
        }
    }

    public void showAddFichaLoading() {
        //Puede servir para poner una pantlla de carga o lo que sea
        Utils.log(true, TAG, "Mostrando pantalla de añadiendo ficha");
    }

    public void hideAddFichaLoading() {
        //Escondemos la pantlla de carga
        Utils.log(true, TAG, "Escondiendo pantalla de añadiendo ficha");
    }

    public void addFicha(Ficha ficha) {
        View v = new View(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(40, 40);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        v.setBackgroundColor(ficha.getColor());
        v.setVisibility(View.VISIBLE);
        v.requestLayout();
        params.leftMargin = ficha.getPos().first;
        params.topMargin = ficha.getPos().second;
        rLCampo.addView(v, params);
        rLCampo.requestLayout();
    }

    public void updateFicha(Ficha ficha) {
        if (ficha != null){
            Utils.log(true, TAG, "Actualizando ficha");
        }else{
            Utils.log(true, TAG, "Error al actualizar ficha");
        }
    }


    public void failedAddFicha() {
        Utils.log(true, TAG, "Error al intentar añadir ficha");
    }

    public void showSaveCampoLoading() {
        Utils.log(true, TAG, "Guardando campo");
        //Puede servir para poner una pantlla de carga o lo que sea
    }

    public void hideSaveCampoLoading() {
        Utils.log(true, TAG, "Campo guardado");
        //Escondemos la pantalla de cargando
    }

    public void updateCampo(Campo campo) {
        Utils.log(true, TAG, "Actualizando campo");
    }

    public void failSaveCampo() {
        Utils.log(true, TAG, "Error al intentar guardar el campo");

    }

    public void showLoadCampoLoading() {
        Utils.log(true, TAG, "Mostrando la pantalla de carga de los campos guardados");
    }

    public void hideLoadCampoLoading() {
        Utils.log(true, TAG, "Ocultando la pantalla de carga de los campos");
    }

    public void failedLoadCampo() {
        Utils.log(true, TAG, "Error al intentar cargar un campo");
    }

    public void loadCampo(Campo campo) {
        loadSurface(campo);
        loadPallete(campo);
        loadPieces(campo);
    }

    private void loadPieces(Campo campo) {
        HashMap fichas = campo.getFichas();
        for (Ficha ficha : campo.getFichas().values()){
            addFicha(ficha);
            Utils.log(true, TAG, ficha.toString());
        }
    }

    private void loadPallete(Campo campo) {
        Utils.log(true, TAG, "Cargando paleta de herramientas");
    }

    private void loadSurface(Campo campo) {
        switch(campo.getTipo()){
            case futbol:
                rLCampo.setBackgroundColor(Color.GREEN);
                break;
            default:
                rLCampo.setBackgroundColor(Color.RED);
                break;

        }
    }
}
