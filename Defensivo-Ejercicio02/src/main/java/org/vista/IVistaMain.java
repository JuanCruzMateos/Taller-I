package org.vista;

public interface IVistaMain {
    void inicializarSurtidor(double carga);

    void cargarSurtidor(double carga);

    void desgargaManguera1();

    void desgargaManguera2();

    double getExistenciaDeposito();

    double getAcumuladoManguera1();

    double getAcumuladoManguera2();

    double getUltimaVentaManguera1();

    double getUltimaVentaManguera2();

    void visible(boolean b);
}
