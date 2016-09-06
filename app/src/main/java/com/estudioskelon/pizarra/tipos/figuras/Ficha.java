package com.estudioskelon.pizarra.tipos.figuras;

import android.graphics.Color;
import android.util.Pair;

import com.estudioskelon.pizarra.Utils;

import java.util.Random;

/**
 * Created by Nexo on 25/08/2016.
 */
public class Ficha {
    public enum Tipo {jugador, pelota, bandera, equis};

    private int id;
    private int color; //Será reemplazado en el futuro supongo por un drawable o algo así
    private Tipo tipo;
    private Pair<Integer, Integer> pos;
    private String dorsal;

    public Ficha(){
        Random rnd = new Random();
        id = Utils.rand(1,100);
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        tipo = Tipo.jugador;
        pos = new Pair<>(rnd.nextInt(600), rnd.nextInt(976));
        dorsal = rnd.nextInt(100)+"";
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

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

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "id=" + id +
                ", color=" + color +
                ", tipo=" + tipo +
                ", pos=" + pos.first + "," + pos.second +
                ", dorsal='" + dorsal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof Ficha){
            if (((Ficha) obj).getId() == this.id){
                equals = true;
            }
        }
        return equals;
    }
}
