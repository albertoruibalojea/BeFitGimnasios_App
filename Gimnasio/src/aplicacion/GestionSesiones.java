package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author alumnogreibd
 */
public class GestionSesiones {
    FachadaGui  fgui;
    FachadaBaseDatos fbd;
    
    public GestionSesiones(FachadaGui  fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
    
    public java.util.List<Sesion> obtenerSesionesUsuario(Usuario u, Integer est){
        return fbd.obtenerSesionesUsuario(u, est);
    }
    
    public Sesion obtenerSesion(Integer s){
        return fbd.obtenerSesion(s);
    }
    
    public java.util.List<Sesion> obtenerSesiones(Integer s, Actividad a, Integer establecimiento){
        return fbd.obtenerSesiones(s, a, establecimiento);
    }
    
    public java.util.List<Sesion> obtenerSesiones(Actividad a, Integer establecimiento){
        return fbd.obtenerSesiones(a, establecimiento);
    }
    
    public java.util.List<Sesion> obtenerSesiones(){
        return fbd.obtenerSesiones();
    }
    
    public void borrarSesion(Sesion s){
        fbd.borrarSesion(s);
    }
    
    public void addUserToSesion(Usuario usuario, Integer sesion, Integer est){
        fbd.addUserToSesion(usuario, sesion, est);
    }
    
    public void insertarSesion(Actividad actividad, Monitor monitor, String fecha_inicio, Integer np, Integer establecimiento){
        fbd.insertarSesion( actividad, monitor, fecha_inicio, np, establecimiento);
    }
    
    public void eliminarUsuarioSesion (Usuario u, Integer sesion, Integer est){
        fbd.eliminarUsuarioSesion(u, sesion, est);
    }
    
    public String visualizarUsuarioSesion(String u){
        return fbd.visualizarUsuarioSesion(u);
    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(String user, Integer idSesion){
        return fbd.consultarPosiblesUsuarios(user, idSesion);
    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(Integer idSesion){
        return fbd.consultarPosiblesUsuarios(idSesion);
    }
    
    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(String user, Integer idSesion){
        return fbd.consultarUsuariosdeUnaSesion(user, idSesion);
    }
    
    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(Integer idSesion){
        return fbd.consultarUsuariosdeUnaSesion(idSesion);
    }
}
