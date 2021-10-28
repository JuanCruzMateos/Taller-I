package sistema.persistencia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sistema.persistencia.dto.ClinicaDTO;
import sistema.persistencia.dto.DTOConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class AccesoDatosTest {
    private File file;

    @Before
    public void setUp() {
        this.file = new File(AccesoDatos.getFILENAME());
        if (this.file.exists())
            this.file.delete();
    }

    @After
    public void tearDown() {
        this.file = null;
    }

    @Test
    public void lanzaExcpecionAlIntentarLeerArchivoInexistenteTest() {
        try {
            AccesoDatos.despersistirClinica();
        } catch (FileNotFoundException e) {
            //ok
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crearArchivoConExitoTest() {
        try {
            AccesoDatos.persistirClinica(DTOConverter.ClinicaDTOFromClinica());
            assertTrue("Deberia generarse el archivo " + AccesoDatos.getFILENAME(), file.exists());
//            System.out.println(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            fail("Deberia generarse el archivo");
        } catch (IOException e) {
            fail("No deberia lanzarse ninguna excepcion");
        }
    }

    @Test
    public void verificaLectoEscrituraVacioTest() {
        try {
            ClinicaDTO dto = DTOConverter.ClinicaDTOFromClinica();
            AccesoDatos.persistirClinica(dto);

            ClinicaDTO desp = AccesoDatos.despersistirClinica();
            assertEquals("Deberian ser iguales", dto, desp);
        } catch (FileNotFoundException e) {
            fail("Deberia encontrarse el archivo");
        } catch (IOException ioe) {
            fail("No deberia lanzarse ninguna excepcion");
        }
    }

    @Test
    public void verificaLectoEscrituraLlenoTest() {
        try {
            DTOConverter.ClinicaFromClinicaDTO(new ClinicaDTO());
            AccesoDatos.initClinica();

            ClinicaDTO dto = DTOConverter.ClinicaDTOFromClinica();
            AccesoDatos.persistirClinica(dto);

            ClinicaDTO desp = AccesoDatos.despersistirClinica();
            assertEquals("Deberian ser iguales", dto, desp);
        } catch (FileNotFoundException e) {
            fail("Deberia encontrarse el archivo");
        } catch (IOException ioe) {
            fail("No deberia lanzarse ninguna excepcion");
        }
    }
}