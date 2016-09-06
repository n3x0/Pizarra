package com.estudioskelon.pizarra.tipos.contenedores;

import com.estudioskelon.pizarra.Utils;
import com.estudioskelon.pizarra.tipos.figuras.Ficha;

import java.util.HashMap;

/**
 * Created by Nexo on 30/08/2016.
 */
public class Campo {
    private static final String TAG = "Campo";

    public enum Tipo {futbol, futbito, baloncesto, hockey, rugby, balonmano};

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

    public HashMap<String, Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(HashMap<String, Ficha> fichas) {
        this.fichas = fichas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isMedio() {
        return medio;
    }

    public void setMedio(boolean medio) {
        this.medio = medio;
    }

    public boolean addFicha(Ficha ficha){
        Utils.log(true, TAG, "Vamos a añadir la ficha: " + ficha);
        fichas.put(ficha.getId()+"", ficha);
        Ficha ficha2 = fichas.get(ficha.getId()+"");
        if (ficha.equals(ficha2)) {
            Utils.log(true, TAG, "Ficha " + ficha + " añadida correctamente.");
            Utils.log(true, TAG, "El campo ahora es: " + fichas.toString());
            return true;
        } else {
            Utils.log(true, TAG, "Ficha " + ficha + " no se ha añadido correctamente.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Campo{" +
                "fichas=" + fichas +
                ", tipo=" + tipo +
                ", medio=" + medio +
                '}';
    }
}
