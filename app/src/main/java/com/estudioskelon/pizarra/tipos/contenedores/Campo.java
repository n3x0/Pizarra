package com.estudioskelon.pizarra.tipos.contenedores;

import com.estudioskelon.pizarra.tipos.figuras.Ficha;

import java.util.HashMap;

/**
 * Created by Nexo on 30/08/2016.
 */
public class Campo {
    private enum Tipo {futbol, futbito, baloncesto, hockey, rugby, balonmano};

    private HashMap<String, Ficha> fichas;
    private Tipo tipo;
    private boolean medio;

    public Campo(){
        fichas = new HashMap<>();
        tipo = Tipo.futbol;
        medio = false;
    }

    public Campo(HashMap<String, Ficha> fichas, Tipo tipo, boolean medio) {
        this.fichas = fichas;
        this.tipo = tipo;
        this.medio = medio;
    }

    public boolean addFicha(Ficha ficha){
        if (fichas.put(ficha.getNumero(), ficha)!=null)
            return true;
        else
            return false;
    }
}
