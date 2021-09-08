package org.controlador;

import org.excepciones.CapacidadExcedidaException;
import org.modelo.BeerHouse;
import org.vista.IVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class Controlador implements ActionListener {
    private static Controlador instance = null;
    private IVista ventana;
    private BeerHouse modelo;

    private Controlador() {
        // Singleton
    }

    public static Controlador getInstance() {
        if (Controlador.instance == null)
            Controlador.instance = new Controlador();
        return Controlador.instance;
    }

    public void setVentana(IVista ventana) {
        this.ventana = ventana;
    }

    public void setModelo(BeerHouse modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Abrir" -> this.abrirLocal(this.ventana.abrirLocal());
            case "Cerrar" -> this.cerrarMesa(this.ventana.cerrarMesa());
            case "Ocupar" -> this.ocuparMesa(this.ventana.ocuparMesa());
        }
    }

    private void ocuparMesa(int nroMesa) {
        this.ventana.resetTextFieldOcupar();
    }

    private void cerrarMesa(int nroMesa) {
        this.ventana.resetTextFieldCerrar();
    }

    private void abrirLocal(int cantMesas) {
        try {
            this.modelo.abrirLocal(cantMesas);
        } catch (CapacidadExcedidaException e) {
            JOptionPane.showMessageDialog(null, "Capacidad del local excedida!\n Limite = " + e.getCapacidad());
        } finally {
            this.ventana.resetTextFieldAbrir();
        }
    }
}
