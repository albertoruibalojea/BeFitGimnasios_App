package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author alumnogreibd
 */
public class GestionEjemplares {
    FachadaGui  fgui;
    FachadaBaseDatos fbd;
    
    public GestionEjemplares (FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui= fgui;
        this.fbd= fbd;
    }
    
    public java.util.List<Ejemplar> obtenerEjemplares (Integer establecimiento, Equipamiento equipamiento){
        return fbd.consultarEjemplares(establecimiento, equipamiento);
    }
    public java.util.List<Ejemplar> obtenerEjemplares (Integer id, Integer establecimiento, Equipamiento equipamiento){
        return fbd.consultarEjemplares(id, establecimiento, equipamiento);
    }
    
    public java.util.List<Ejemplar> obtenerEjemplares (Establecimiento establecimiento){
        return fbd.consultarEjemplares(establecimiento);
    }
    
    public Ejemplar visualizarEjemplar(Integer ejemplar, Equipamiento equipamiento, Integer establecimiento) {
        return fbd.consultarEjemplar(ejemplar, equipamiento, establecimiento);
    }

    void borrarEjemplar(Integer idej, Equipamiento equipamiento, Integer establecimiento) {
        fbd.borrarEjemplar(idej, equipamiento, establecimiento);
    }
    
    public void modificarEjemplar(Ejemplar e){
        fbd.modificarEjemplar(e);
    }

    void insertarEjemplar(Integer equipamiento, Ejemplar ej) {
        fbd.insertarEjemplar(equipamiento, ej);
    }
}



