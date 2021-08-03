package aplicacion;

import java.util.Calendar;

/**
 *
 * @author alumnogreibd
 */
public final class Administrador extends Empleado{
    private String contrasena;

    public Administrador(String contrasena, String dni_admin, String nombre, String telefono, String email, Integer establecimiento, Integer ano) {
        super(dni_admin, nombre, telefono, email, establecimiento, ano);
        this.contrasena = contrasena;
        this.setSueldo(this.getSueldo());
    }
    

    
    @Override
    public Integer getSueldo() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Integer sueldo;
        int anos_contratado;
        anos_contratado= year- super.getAno_contratacion();
        sueldo= 1500+(anos_contratado*10);
        return sueldo;
    }

    public String getContrasena() {
        return contrasena;
    }
    
   
    @Override
    public void setSueldo(Integer i) {
        this.sueldo= i;
    }    
    
}
