package aplicacion;

import java.util.Calendar;

/**
 *
 * @author sofiamartinezparada
 */
public abstract class Empleado {

    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    Integer sueldo;
    private Integer ano_contratacion;
    private Integer establecimiento;

    public Empleado(String dni, String nombre, String telefono, String email, Integer establecimiento, Integer ano) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        //El sueldo se calcula segun el tipo de empleado
        this.sueldo = null;
        this.establecimiento = establecimiento;
        if (ano == null) {
            this.setAno_contratacion();
        } else {
            this.ano_contratacion = ano;
        }
    }
    
    public Empleado(String dni, String nombre, String telefono, String email, Integer establecimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        //El sueldo se calcula segun el tipo de empleado
        this.sueldo = null;
        this.establecimiento = establecimiento;
        this.setAno_contratacion();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public Integer getAno_contratacion() {
        return ano_contratacion;
    }

    public void setEstablecimiento(int establecimiento) {
        this.establecimiento = establecimiento;
    }

    public int getEstablecimiento() {
        return establecimiento;
    }
    
    public String getEstablecimientoString(){
        return this.establecimiento.toString();
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public void setAno_contratacion() {
        Calendar c = Calendar.getInstance();
        Integer year = c.get(Calendar.YEAR);
        this.ano_contratacion = year;
    }

}
