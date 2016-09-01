package com.estudioskelon.pizarra.activities.pizarra;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.estudioskelon.pizarra.R;
import com.estudioskelon.pizarra.Utils;
import com.estudioskelon.pizarra.tipos.contenedores.Campo;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;

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
    private View vTRojo;
    private View vTNaranja;


    private PizarraP presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizarra);
        presenter = new PizarraP(this);
        enlazar();
    }

    private void enlazar() {
        bTGuardar = (Button) findViewById(R.id.bTGuardar);
        bTGuardar.setOnClickListener(this);
        vTRojo = (View) findViewById(R.id.rojo);
        vTRojo.setOnClickListener(this);
        vTNaranja = (View) findViewById(R.id.naranja);
        vTNaranja.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bTGuardar:
                presenter.saveCampo();
                break;
            case R.id.rojo:
            case R.id.naranja:
                presenter.addFicha();
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

    public void updateFicha(Ficha ficha) {
        Utils.log(true, TAG, "Error al actualizar ficha");
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
}
