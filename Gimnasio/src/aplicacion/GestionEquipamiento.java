/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author alumnogreibd
 */
class GestionEquipamiento {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionEquipamiento(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
    public java.util.List<Equipamiento> obtenerEquipamiento(Integer id){
        return fbd.obtenerEquipamiento(id);
    }
    
    public java.util.List<Equipamiento> obtenerEquipamiento(){
        return fbd.obtenerEquipamiento();
    }
    
    public Equipamiento consultarEquipamiento(int id){
        return fbd.consultarEquipamiento(id);
    }
    
    public void actualizarEquipamiento(Equipamiento e){
        if (this.consultarEquipamiento(e.getId()) == null) {
            fbd.insertarEquipamiento(e);
        } else {
            fbd.modificarEquipamiento(e);
        }
    }
    
    public void borrarEquipamiento(Equipamiento e){
        fbd.borrarEquipamiento(e);
    }
    
    public void crearEquipamientoEjemplares(Equipamiento e, int ejemplares, Establecimiento est){
        fbd.crearEquipamientoEjemplares(e, ejemplares, est);
    }
    
    public boolean comprobacionBorrarEquipamiento(Equipamiento e){
        return fbd.comprobacionBorrarEquipamiento(e);
    }
    
}
