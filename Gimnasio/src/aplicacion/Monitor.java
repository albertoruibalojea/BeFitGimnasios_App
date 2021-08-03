package aplicacion;

import java.util.Calendar;

/**
 *
 * @author alumnogreibd
 */
public final class Monitor extends Empleado{
    public String horario;

    public Monitor(String dni, String nombre, String telefono, String email, String horario, Integer establecimiento, int ano) {
        super(dni, nombre, telefono, email, establecimiento, ano);
        this.horario= horario;
        this.setSueldo(this.getSueldo());
    }
    
    public Monitor(String dni, String nombre, String telefono, String email, String horario, Integer establecimiento) {
        super(dni, nombre, telefono, email, establecimiento);
        this.horario= horario;
        this.setSueldo(this.getSueldo());
    }

    @Override
    public Integer getSueldo() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Integer sueldo;
        int anos_contratado;
        anos_contratado= year- super.getAno_contratacion();
        sueldo= 1100+(anos_contratado*10);
        return sueldo;
    }
    
    
    @Override
    public void setSueldo(Integer i) {
        this.sueldo= i;
    }
    

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
    
    
    
}
