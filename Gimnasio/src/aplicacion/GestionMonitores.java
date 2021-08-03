package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.Calendar;
/**
 *
 * @author alumnogreibd
 */
public class GestionMonitores {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionMonitores (FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd= fbd;
    }
    
    public java.util.List<Monitor> obtenerMonitores(String dni_monitor, Integer establecimiento){
        return fbd.consultarMonitores(dni_monitor, establecimiento);
    }

    public java.util.List<Monitor> obtenerMonitores(Establecimiento establecimiento) {
        return fbd.consultarMonitores(establecimiento);
    }
    
    public java.util.List<Monitor> obtenerPosiblesMonitores (Integer establecimiento, String fecha_inicio, String horario){
        return fbd.consultarPosiblesMonitores(establecimiento, fecha_inicio, horario);
    }
    
    public Monitor visualizarMonitor(String dni_monitor) {
        return fbd.consultarMonitor(dni_monitor);
    }
    
    public void actualizarMonitor (Monitor m){
        String dni_monitor;
        if(fbd.validarMonitor(m.getDni())==null){
            fbd.insertarMonitor(m);
        }else{
            fbd.modificarMonitor(m);
        }
    }
    
    public void borrarMonitor (String dni){
        fbd.borrarMonitor(dni);
    }

    public int getNumSesiones (Monitor m){
        return fbd.getNumSesiones(m);
    }



}
