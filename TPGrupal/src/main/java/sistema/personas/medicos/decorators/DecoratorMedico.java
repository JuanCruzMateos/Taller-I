package sistema.personas.medicos.decorators;

import sistema.personas.medicos.IMedico;

/**
 * Clase que implementa Patron Decorator para modificar responsabiliades en forma dinamica a los medicos.<br>
 */
public abstract class DecoratorMedico implements IMedico {
    protected IMedico encapsulado;

    public DecoratorMedico(IMedico encapsulado) {
        this.encapsulado = encapsulado;
    }

    @Override
    public String getNombre() {
        return encapsulado.getNombre();
    }

    @Override
    public String getApellido() {
        return encapsulado.getApellido();
    }

    @Override
    public String getDescripcion() {
        return this.encapsulado.getDescripcion();
    }

    @Override
    public int getMatricula() {
        return this.encapsulado.getMatricula();
    }

    @Override
    public void setMatricula(Integer matricula) {
        this.encapsulado.setMatricula(matricula);
    }

    @Override
    public String toString() {
        return this.encapsulado.toString();
    }
}
