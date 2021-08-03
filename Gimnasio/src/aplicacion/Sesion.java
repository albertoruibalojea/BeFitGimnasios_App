/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class Sesion {

    private Integer idSesion;
    private String fecha_inicio = "";
    private Integer idActividad;
    private Integer plazas;
    private String dniMonitor;
    private List<Usuario> usuarios;
    private Integer idEstablecimiento;

    public Sesion(Integer idSesion, Integer idActividad, String dniMonitor, String fecha_inicio, Integer plazas, Integer idEstablecimiento) {
        this.idSesion = idSesion;
        this.fecha_inicio = fecha_inicio;
        this.idActividad = idActividad;
        this.plazas = plazas;
        this.dniMonitor = dniMonitor;
        this.usuarios=new ArrayList<Usuario>();
        this.idEstablecimiento=idEstablecimiento;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getPlazas() {
        return plazas;
    }

    public void setPlazas(Integer plazas) {
        this.plazas = plazas;
    }

    public String getDniMonitor() {
        return dniMonitor;
    }

    public void setDniMonitor(String dniMonitor) {
        this.dniMonitor = dniMonitor;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }
    
    

}
