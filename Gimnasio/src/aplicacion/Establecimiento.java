/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Establecimiento {
    private final Integer id_establecimiento;
    private String nombre;
    private String ciudad;
    private String telefono;
    private String direccion;

    public Establecimiento(Integer id_establecimiento, String nombre, String ciudad, String telefono, String direccion) {
        this.id_establecimiento = id_establecimiento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Establecimiento(Integer id){
        this.id_establecimiento=id;
        this.ciudad=null;
        this.direccion=null;
        this.nombre=null;
        this.telefono=null;
    }

    public Integer getId_establecimiento() {
        return id_establecimiento;
    }
    
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    
    
    
}
