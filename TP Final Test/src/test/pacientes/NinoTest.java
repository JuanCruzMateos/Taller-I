package test.pacientes;

import org.junit.Test;
import pacientes.Joven;
import pacientes.Mayor;
import pacientes.Nino;

import static org.junit.Assert.*;

public class NinoTest {
    @Test
    public void constructorGettersTest() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        assertEquals("fallo constructor dni", "38443617", nino.getDNI());
        assertEquals("fallo constructor dni", "Juan Cruz Mateos", nino.getNombre());
        assertEquals("fallo constructor nombre", "155937802", nino.getTelefono());
        assertEquals("fallo constructor domicilio", "Almafuerte 1016", nino.getDomicilio());
        assertEquals("fallo constructor ciudad", "Mar del Plata", nino.getCiudad());
        assertEquals("fallo constructor huist clinica", 1, nino.getNumHistoria());
    }

    @Test
    public void setGetCiudadTest() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        nino.setCiudad("Buenos Aires");
        assertEquals("Error en setter/getter de ciudad", "Buenos Aires", nino.getCiudad());
    }

    @Test
    public void setGetDomicilioTest() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        nino.setDomicilio("Falucho 1234");
        assertEquals("Error en setter/getter de ciudad", "Falucho 1234", nino.getDomicilio());
    }

    @Test
    public void setGetTelefonoTest() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        nino.setTelefono("4521478");
        assertEquals("Error en setter/getter de ciudad", "4521478", nino.getTelefono());
    }

    @Test
    public void beatsNino() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        Nino otro = new Nino("40443617", "Carlos perez", "4152369", "Quintana 1016", "Mar del Plata", 8);
        assertTrue("Deberia quedar nuevo nino", nino.beats(otro));
    }

    @Test
    public void beatsJoven() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        Joven otro = new Joven("40443617", "Carlos perez", "4152369", "Quintana 1016", "Mar del Plata", 8);
        assertTrue("Deberia quedar nuevo nino", nino.beats(otro));
    }

    @Test
    public void beatsMayor() {
        Nino nino = new Nino("38443617", "Juan Cruz Mateos", "155937802", "Almafuerte 1016", "Mar del Plata", 1);
        Mayor otro = new Mayor("40443617", "Carlos perez", "4152369", "Quintana 1016", "Mar del Plata", 8);
        assertFalse("Deberia quedar nuevo nino", nino.beats(otro));
    }
}