package com.estudioskelon.pizarra.activities.pizarra;

import com.estudioskelon.pizarra.tipos.contenedores.Campo;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;

/**
 * Created by Nexo on 01/09/2016.
 */
public class PizarraM {

    private PizarraP presenter;
    private Campo campo;

    public PizarraM(PizarraP pizarraP) {
        presenter = pizarraP;
        campo = new Campo();
    }

    public void addFicha() {
        Ficha ficha = new Ficha();
        if (campo.addFicha(ficha))
            presenter.backAddFicha(ficha);
        else
            presenter.backAddFicha(null);
    }

    public void saveCampo() {
        //aquí deberiamos guardar el xml con los datos
    }
}
