package org.vista;

public interface IVistaMain {
    double cargarSurtidor();

    void activaManguera1();

    void activaManguera2();

    void desactivaManguera1();

    void desactivaManguera2();

    void setCombustible(double cantidad);

    void setAcumuladoM1(double cantidad);

    void setAcumuladoM2(double cantidad);

    void visible(boolean b);

    void refresh();

    void setUltimaVentaM2(double ultimaVentaMG2);

    void setUltimaVentaM1(double ultimaVentaMG1);
}
