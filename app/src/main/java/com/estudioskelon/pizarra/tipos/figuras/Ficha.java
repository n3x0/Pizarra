package com.estudioskelon.pizarra.tipos.figuras;

import android.graphics.Color;
import android.util.Pair;

import com.estudioskelon.pizarra.Utils;

/**
 * Created by Nexo on 25/08/2016.
 */
public class Ficha {
    private enum Tipo {jugador, pelota, bandera, equis};

    private int id;
    private int color; //Será reemplazado en el futuro supongo por un drawable o algo así
    private Tipo tipo;
    private Pair<Integer, Integer> pos;
    private String numero;

    public Ficha(){
        id = Utils.rand(0,100);
        color = Color.GREEN;
        tipo = Tipo.jugador;
        pos = new Pair<>(0,0);
        numero = "0";
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Pair<Integer, Integer> getPos() {
        return pos;
    }

    public void setPos(Pair<Integer, Integer> pos) {
        this.pos = pos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
