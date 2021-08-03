package aplicacion;

import Interfaz.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author alumnogreibd
 */
public class GestionEstablecimientos {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionEstablecimientos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui= fgui;
        this.fbd= fbd;
    }

    public Establecimiento buscarEstablecimiento(int id_establecimiento) {
        return fbd.buscarEstablecimiento (id_establecimiento);
    }
    
    public java.util.List<Establecimiento> obtenerEstablecimientos(Integer id){
        return fbd.consultarEstablecimientos(id);
    }
    
    public java.util.List<Establecimiento> obtenerEstablecimientos(){
        return fbd.consultarEstablecimientos();
    }
    
    public void modificarEstablecimiento (Establecimiento e){
        fbd.modificarEstablecimiento(e);
    }

    public void actualizarEstablecimiento (Establecimiento e){
        if(fbd.buscarEstablecimiento(e.getId_establecimiento())==null){
            fbd.insertarEstablecimiento(e);
        }else{
            fbd.modificarEstablecimiento(e);
        }
    }
    
    public void borrarEstablecimiento(Establecimiento e, java.util.List<Monitor> monitores, java.util.List<Ejemplar> ejemplares, Administrador adm){
        fbd.borrarEstablecimiento(e, monitores, ejemplares, adm);
    }
    
}
