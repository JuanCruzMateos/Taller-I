package org.modelo;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Mesa {
    private static int sigNro = 0;
    private final int nroMesa;
    private char ocupada;

    public Mesa() {
        this.nroMesa = ++Mesa.sigNro;
        this.ocupada = 'L';
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public boolean isOcupada() {
        return this.ocupada == 'O';
    }

    public void ocupar() {
        this.ocupada = 'O';
    }

    public double cerrarMesa() {
        ArrayList<String> listadoProd = Carta.getInstance().getListadoProductos();
        Random rand = new Random();
        double total = 0;
        int index;

        this.ocupada = 'L';
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {
            index = rand.nextInt(listadoProd.size());
            total += Carta.getInstance().getCosto(listadoProd.get(index));
        }
        return total;
    }
}
