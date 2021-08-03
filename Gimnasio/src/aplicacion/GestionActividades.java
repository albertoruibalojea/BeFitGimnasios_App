package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author sofiamartinezparada
 */
public class GestionActividades {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionActividades(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public Actividad consultarActividad(int id){
        return fbd.consultarActividad(id);
    }
    
    public java.util.List<Actividad> obtenerActividades(Integer id, String nombre){
        return fbd.obtenerActividades(id, nombre);
    }
    
    public java.util.List<Actividad> obtenerActividades(Integer id){
        return fbd.obtenerActividades(id);
    }
    
    public java.util.List<Actividad> obtenerActividades(String nombre){
        return fbd.obtenerActividades(nombre);
    }
    
    public java.util.List<Actividad> obtenerActividades(){
        return fbd.obtenerActividades();
    }
    
    public void borrarActividad (Actividad a){
        fbd.borrarActividad(a);
    }
    
    public boolean consultarActividadRepetida(String nombre){
        return fbd.consultarActividadRepetida(nombre);
    }
    
    public void actualizarActividad (Actividad a){
        if(this.consultarActividad(a.getId())== null){
            fbd.insertarActividad(a);
        }else{
            fbd.modificarActividad(a);
        }
    }
    
}
