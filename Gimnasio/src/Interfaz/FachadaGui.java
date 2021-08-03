package Interfaz;

import aplicacion.Actividad;
import aplicacion.Administrador;
import aplicacion.Equipamiento;
import aplicacion.Establecimiento;
import aplicacion.Sesion;
import aplicacion.Usuario;
import java.awt.Toolkit;

/**
 *
 * @author sofiamartinezparada
 */
public class FachadaGui {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VBPrincipal vpb;
    aplicacion.Establecimiento establecimiento;
    aplicacion.Administrador adminLogueado;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa, this);
        this.vpb = new VBPrincipal(fa, this);
        this.establecimiento = null;
        this.adminLogueado = null;

    }

    public void iniciaVista() {
        VAutentificacion va;
        va = new VAutentificacion(vp, true, fa);
        va.setVisible(true);
        va.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public boolean comprobacionBoss(String mensaje){
        VAutentificacion va;
        va = new VAutentificacion(vp, true, fa);
        va.setTitle(mensaje);
        va.setVisible(true);
        va.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
        
        return va.comprobar();
        
    }
    
    public boolean comprobacionAdmin(String mensaje){
        VAutentificacion va;
        va = new VAutentificacion(vp, true, fa);
        va.setTitle(mensaje);
        va.setVisible(true);
        va.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
        
        return va.comprobarAdmin();
        
    }
    
    public void iniciarVPrincipal() {
        
        vp = new VPrincipal(fa, this);
        vp.setVisible(true);
        vp.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));

    }
    
    public void iniciaVBPrincipal(){
        vpb = new VBPrincipal(fa, this);
        vpb.setVisible(true);
        vpb.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void iniciaVBGimnasio() {
        VBGimnasios vsug;

        vsug = new VBGimnasios(vpb, true, fa);

        vsug.setVisible(true);
        vsug.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void iniciaVBAdmins() {
        VBAdmins vsua;

        vsua = new VBAdmins(vpb, true, fa);

        vsua.setVisible(true);
        vsua.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
        va.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void iniciaUsuario() {
        VUsuario vusuario = new VUsuario(vp, true, fa);
        vusuario.setVisible(true);
        vusuario.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public void iniciaUsuarioSesiones(Usuario u){
        VUsuarioSesiones vus = new VUsuarioSesiones(vp, true, fa, u);
        vus.setVisible(true);
        vus.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void iniciaPersonal() {
        VPersonal vpersonal = new VPersonal(vp, true, fa);
        vpersonal.setVisible(true);
        vpersonal.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public void iniciaVEstablecimiento(){
        VEstablecimiento vest = new VEstablecimiento(vp, true, fa);
        vest.setVisible(true);
        vest.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }

    public void iniciaVBEquipamiento() {
        VBEquipamiento vequipamiento = new VBEquipamiento(vp, true, fa);
        vequipamiento.setVisible(true);
        vequipamiento.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public void iniciaVBActividad(){
        VBActividad vactividad = new VBActividad(vp, true, fa);
        vactividad.setVisible(true);
        vactividad.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public void iniciaEjemplar(){
        VEjemplar veejemplar = new VEjemplar(vp, true, fa);
        veejemplar.setVisible(true);
        veejemplar.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));
    }
    
    public void iniciaSesiones(){
        VSesiones vsesiones = new VSesiones(vp, true, fa);
        vsesiones.setVisible(true);
        vsesiones.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));        
    }

    public void iniciaVGestionarUsersSesiones(Sesion s, Actividad a){
        VGestionarUsersSesiones vus = new VGestionarUsersSesiones(vp, true, fa, s, a);
        vus.setVisible(true);
        vus.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));        

    }
    public void iniciaVCrearSesion(){
        VCrearSesion vcs = new VCrearSesion(vp, true, fa);
        vcs.setVisible(true);
        vcs.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/gym.png")));        
    }
    public void setAdminLogueado(Administrador adminLogueado) {
        this.adminLogueado = adminLogueado;        
        this.establecimiento= fa.buscarEstablecimiento(adminLogueado.getEstablecimiento());
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }
    
    

}
