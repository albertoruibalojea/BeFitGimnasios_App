package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author sofiamartinezparada
 */
public class GestionAdministrador {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionAdministrador(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui= fgui;
        this.fbd= fbd;
    }
    
    public Boolean comprobarAutentificacion(String dni_admin, String password){
        Administrador adm;
        
        adm= fbd.validarAdministrador(dni_admin, password);
        fgui.setAdminLogueado(adm);
        return adm!=null;
    }
    
    public java.util.List<Administrador> obtenerAdmins(Integer establecimiento, String dni){
        return fbd.obtenerAdmins(establecimiento, dni);
    }
    
    public Administrador obtenerAdministrador(Establecimiento est){
        return fbd.obtenerAdministrador(est);
    }
    
    public java.util.List<Administrador> obtenerAdmins(){
        return fbd.obtenerAdmins();
    }
    
    public Administrador visualizarAdmin(String dni){
        return fbd.visualizarAdmin(dni);
    }
    
    public String visualizarAdmin(Integer est){
        return fbd.visualizarAdmin(est);
    }
    
    public void actualizarAdmin(Administrador a){
         if (fbd.validarAdmin(a.getDni()) == null) {
            fbd.insertarAdmin(a);
        } else {
            fbd.modificarAdmin(a);
        }
    }
    
    public void borrarAdmin(Administrador admin){
        fbd.borrarAdmin(admin);
    }
    
    
}
