package org.controlador;

import org.excepciones.CapacidadExcedidaException;
import org.excepciones.MesaAbiertaException;
import org.excepciones.MesaInexistenteException;
import org.excepciones.MesaOcupadaException;
import org.modelo.BeerHouse;
import org.vista.IVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador del movelo MVC.<br>
 * Implementa patron Singleton.<br>
 */
public class Controlador implements ActionListener {
    private static Controlador instance = null;
    private IVista ventana;
    private BeerHouse beerHouse;

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

    public void setBeerHouse(BeerHouse beerHouse) {
        this.beerHouse = beerHouse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Abrir" -> this.abrirLocal(this.ventana.abrirLocal());
            case "Cerrar" -> this.cerrarMesa(this.ventana.cerrarMesa());
            case "Ocupar" -> this.ocuparMesa(this.ventana.ocuparMesa());
        }
    }

    /**
     * Ocupa un mesa validando previamente de que se trate de un numero posible.<br>
     *
     * @param nroMesa nro de mesa recibido de la ventena sin validacion.<br>
     */
    private void ocuparMesa(int nroMesa) {
        if (nroMesa <= 0)
            JOptionPane.showMessageDialog(null, "Ingrese un numero de mesa positivo.");
        else {
            try {
                this.beerHouse.ocuparMesa(nroMesa);
                JOptionPane.showMessageDialog(null, "Mesa " + nroMesa + " ocupada!");
            } catch (MesaOcupadaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (MesaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.ventana.resetTextFieldOcupar();
    }

    /**
     * Cierra un mesa validando previamente de que se trate de un numero posible.<br>
     *
     * @param nroMesa nro de mesa recibido de la ventena sin validacion.<br>
     */
    private void cerrarMesa(int nroMesa) {
        if (nroMesa <= 0)
            JOptionPane.showMessageDialog(null, "Ingrese un numero de mesa positivo.");
        else {
            try {
                double total = this.beerHouse.cerrarMesa(nroMesa);
                JOptionPane.showMessageDialog(null, "Mesa " + nroMesa + " cerrada!\n Total = " + total);
            } catch (MesaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (MesaAbiertaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.ventana.resetTextFieldCerrar();
    }

    /**
     * Abre el local previamente validando que se trate de un numero posible.<br>
     *
     * @param cantMesas cantidad de mesas recibido de la ventena sin validacion.<br>
     */
    private void abrirLocal(int cantMesas) {
        if (cantMesas <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad de mesas positiva.");
        } else {
            try {
                this.beerHouse.abrirLocal(cantMesas);
                JOptionPane.showMessageDialog(null, "Local abierto con " + cantMesas + " mesas!");
            } catch (CapacidadExcedidaException e) {
                JOptionPane.showMessageDialog(null, "Capacidad del local excedida!\n Limite = " + e.getCapacidad());
            }
        }
        this.ventana.resetTextFieldAbrir();
    }
}
