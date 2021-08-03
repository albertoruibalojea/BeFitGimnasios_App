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
public class GestionUsuarios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public java.util.List<Usuario> obtenerUsuarios(String dni) {
        return fbd.obtenerUsuarios(dni);
    }

    public Usuario visualizarUsuario(String dni) {
        return fbd.visualizarUsuario(dni);
    }

    public void actualizarUsuario(Usuario u) {
        if (fbd.visualizarUsuario(u.getDni_usuario()) == null) {
            fbd.insertarUsuario(u);
        } else {
            fbd.modificarUsuario(u);
        }
    }
    
    public void borrarUsuario(Usuario u){
        fbd.borrarUsuario(u);
    }
    
    public int consultarEstablecimientos(Usuario u){
        return fbd.consultarNumEstUsuario(u);
    }
    
    public void insertarUsuario (Usuario u){
        fbd.insertarUsuario(u);
    }

}
