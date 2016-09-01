package com.estudioskelon.pizarra.activities.pizarra;

import com.estudioskelon.pizarra.tipos.contenedores.Campo;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;

/**
 * Created by Nexo on 01/09/2016.
 * El presentador debe ser responsable de:
 * Loading models
 * Keeping a reference to the model, and the state of the view
 * Formatting what should be displayed, and instructing the View to display it
 * Interacting with the repositories (database, network, etc.)
 * Deciding the actions to take when input events are received
 *
 * Las operaciones deben ser:
 *      ACCION          PREFIJO
 * Añadir un objeto     add
 * Guardar un objeto    save
 * Volver de callback   back
 */
public class PizarraP implements IPizarra {

    private PizarraV view;
    private PizarraM model;

    public PizarraP(PizarraV pizarraV) {
        view = pizarraV;
        model = new PizarraM(this);

    }

    public void addFicha() {
        //Habría que comprobar si se puede añadir la ficha
        view.showAddFichaLoading();
        model.addFicha();
    }

    @Override
    public void backAddFicha(Ficha ficha) {
        view.hideAddFichaLoading();
        if (ficha == null){
            view.failedAddFicha();
        }else{
            view.updateFicha(ficha);
        }
    }

    public void saveCampo() {
        view.showSaveCampoLoading();
        model.saveCampo();
    }

    @Override
    public void backSaveCampo(Campo campo) {
        view.hideSaveCampoLoading();
        if (campo == null){
            view.failSaveCampo();
        }else{
            view.updateCampo(campo);
        }
    }


}
