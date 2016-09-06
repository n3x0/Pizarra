package com.estudioskelon.pizarra.activities.pizarra;

import android.content.Context;

import com.estudioskelon.pizarra.SPrefs;
import com.estudioskelon.pizarra.Utils;
import com.estudioskelon.pizarra.tipos.contenedores.Campo;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;
import com.google.gson.Gson;

/**
 * Created by Nexo on 01/09/2016.
 */
public class PizarraM {

    private static final String TAG = "PizarraM";
    private PizarraP presenter;
    private Campo campo;

    public PizarraM(PizarraP pizarraP) {
        presenter = pizarraP;
        campo = new Campo();
    }

    public void addFicha() {
        Ficha ficha = new Ficha();
        if (campo.addFicha(ficha)) {
            presenter.backAddFicha(ficha);
        } else {
            presenter.backAddFicha(null);
        }
    }

    public void saveCampo(Context ctx) {
        //aquí deberiamos guardar el xml con los datos
        Gson gson = new Gson();
        String jsonString = gson.toJson(campo);
        //Usando SPrefs
        SPrefs.save(ctx, jsonString, SPrefs.KEY_CAMPO);
        Utils.log(true, TAG, "Hemos guardado: " + jsonString);
    }

    public void loadCampo(Context ctx) {
        Gson gson = new Gson();
        Campo campo = new Campo();
        String jsonString = (String) SPrefs.load(ctx, SPrefs.KEY_CAMPO, "string");
        campo = gson.fromJson(jsonString, Campo.class);
        Utils.log(true, TAG, "Hemos recuperado: " + jsonString);
        if (campo != null){
            presenter.backLoadCampo(campo);
        }
    }
}
