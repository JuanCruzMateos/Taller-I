package sistema.persistencia.dto;

//import sistema.ambulatorio.ModuloAtencionAmbulatoria;
import sistema.atencion.ModuloAtencion;
import sistema.egreso.ModuloEgreso;
import sistema.ingreso.ModuloIngreso;
import sistema.personas.medicos.IMedico;

import java.io.Serializable;
import java.util.HashMap;

public class ClinicaDTO implements Serializable {
    private String nombre;
    private String direccion;
    private String ciudad;
    private Long telefono;
    private HashMap<Integer, IMedico> medicos = new HashMap<>();
    private ModuloIngreso moduloIngreso = new ModuloIngreso();
    private ModuloAtencion moduloAtencion = new ModuloAtencion();
    private ModuloEgreso moduloEgreso = new ModuloEgreso();
//    private ModuloAtencionAmbulatoria moduloAtencionAmbulatoria = new ModuloAtencionAmbulatoria();
    // Habitacioens
    private double costoAsignacion;
    // Medicos
    private double sueldoBasico;
    private double aumentoCirujano;
    private double aumentoClinico;
    private double aumentoPediatra;
    private int nroHistoriaClinica;
    private double aumentoDoctor;
    private double aumentoMagister;
    private double aumentoPermanente;
    private double aumentoTemporario;
    // modulo Ingreso
    private int nroOrden;
    // Factura
    private int sigNroFactura;
    private double costoHabCompartida;
    private double costoHabPrivada;
    private double costoHabTerapiaIntensiva;

    public double getCostoAsignacion() {
        return costoAsignacion;
    }

    public void setCostoAsignacion(double costoAsignacion) {
        this.costoAsignacion = costoAsignacion;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getAumentoCirujano() {
        return aumentoCirujano;
    }

    public void setAumentoCirujano(double aumentoCirujano) {
        this.aumentoCirujano = aumentoCirujano;
    }

    public double getAumentoClinico() {
        return aumentoClinico;
    }

    public void setAumentoClinico(double aumentoClinico) {
        this.aumentoClinico = aumentoClinico;
    }

    public double getAumentoPediatra() {
        return aumentoPediatra;
    }

    public void setAumentoPediatra(double aumentoPediatra) {
        this.aumentoPediatra = aumentoPediatra;
    }

    public int getNroHistoriaClinica() {
        return nroHistoriaClinica;
    }

    public void setNroHistoriaClinica(int nroHistoriaClinica) {
        this.nroHistoriaClinica = nroHistoriaClinica;
    }

    public double getAumentoDoctor() {
        return aumentoDoctor;
    }

    public void setAumentoDoctor(double aumentoDoctor) {
        this.aumentoDoctor = aumentoDoctor;
    }

    public double getAumentoMagister() {
        return aumentoMagister;
    }

    public void setAumentoMagister(double aumentoMagister) {
        this.aumentoMagister = aumentoMagister;
    }

    public double getAumentoPermanente() {
        return aumentoPermanente;
    }

    public void setAumentoPermanente(double aumentoPermanente) {
        this.aumentoPermanente = aumentoPermanente;
    }

    public double getAumentoTemporario() {
        return aumentoTemporario;
    }

    public void setAumentoTemporario(double aumentoTemporario) {
        this.aumentoTemporario = aumentoTemporario;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    public int getSigNroFactura() {
        return sigNroFactura;
    }

    public void setSigNroFactura(int sigNroFactura) {
        this.sigNroFactura = sigNroFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public HashMap<Integer, IMedico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<Integer, IMedico> medicos) {
        this.medicos = medicos;
    }

    public ModuloIngreso getModuloIngreso() {
        return moduloIngreso;
    }

    public void setModuloIngreso(ModuloIngreso moduloIngreso) {
        this.moduloIngreso = moduloIngreso;
    }

    public ModuloAtencion getModuloAtencion() {
        return moduloAtencion;
    }

    public void setModuloAtencion(ModuloAtencion moduloAtencion) {
        this.moduloAtencion = moduloAtencion;
    }

    public ModuloEgreso getModuloEgreso() {
        return moduloEgreso;
    }

    public void setModuloEgreso(ModuloEgreso moduloEgreso) {
        this.moduloEgreso = moduloEgreso;
    }

//    public ModuloAtencionAmbulatoria getModuloAtencionAmbulatoria() {
//        return moduloAtencionAmbulatoria;
//    }
//
//    public void setModuloAtencionAmbulatoria(ModuloAtencionAmbulatoria moduloAtencionAmbulatoria) {
//        this.moduloAtencionAmbulatoria = moduloAtencionAmbulatoria;
//    }

    public double getCostoHabCompartida() {
        return costoHabCompartida;
    }

    public void setCostoHabCompartida(double costoHabCompartida) {
        this.costoHabCompartida = costoHabCompartida;
    }

    public double getCostoHabPrivada() {
        return costoHabPrivada;
    }

    public void setCostoHabPrivada(double costoHabPrivada) {
        this.costoHabPrivada = costoHabPrivada;
    }

    public double getCostoHabTerapiaIntensiva() {
        return costoHabTerapiaIntensiva;
    }

    public void setCostoHabTerapiaIntensiva(double costoHabTerapiaIntensiva) {
        this.costoHabTerapiaIntensiva = costoHabTerapiaIntensiva;
    }
}
