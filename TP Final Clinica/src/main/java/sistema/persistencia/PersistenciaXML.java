package sistema.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Clase encargada de la persistencia XML.<br>
 */
public class PersistenciaXML implements IPersistencia {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;

    @Override
    public void openInput(String fileName) throws Exception {
        this.fileInputStream = new FileInputStream(fileName);
        this.xmlDecoder = new XMLDecoder(this.fileInputStream);
    }

    @Override
    public void closeInput() throws Exception {
        if (this.xmlDecoder != null)
            this.xmlDecoder.close();
    }

    @Override
    public void openOutput(String fileName) throws Exception {
        this.fileOutputStream = new FileOutputStream(fileName);
        this.xmlEncoder = new XMLEncoder(this.fileOutputStream);
    }

    @Override
    public void closeOutput() throws Exception {
        if (this.xmlEncoder != null)
            this.xmlEncoder.close();
    }

    @Override
    public void write(Object obj) throws Exception {
        if (this.xmlEncoder != null)
            this.xmlEncoder.writeObject(obj);
    }

    @Override
    public Object read() throws Exception {
        Object object = null;

        if (this.xmlDecoder != null)
            object = this.xmlDecoder.readObject();
        return object;
    }
}
