package aplicacion;

import java.security.GeneralSecurityException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 *
 */
public class FachadaAplicacion {

    Interfaz.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionAdministrador cadm;
    GestionMonitores cm;
    GestionUsuarios cu;
    GestionEstablecimientos ce;
    GestionEquipamiento ceq;
    GestionEjemplares cej;
    GestionSesiones cs;
    GestionActividades ca;

    public FachadaAplicacion() {
        fgui = new Interfaz.FachadaGui(this);
        try {
            fbd = new baseDatos.FachadaBaseDatos(this);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(FachadaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(FachadaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadm = new GestionAdministrador(fgui, fbd);
        cm = new GestionMonitores(fgui, fbd);
        cu = new GestionUsuarios(fgui, fbd);
        ce = new GestionEstablecimientos(fgui, fbd);
        ceq = new GestionEquipamiento(fgui, fbd);
        cej = new GestionEjemplares(fgui, fbd);
        cs = new GestionSesiones(fgui, fbd);
        ca = new GestionActividades(fgui, fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

        } catch (Exception e) {
            System.err.println("Error cambiando el tema.");
        }

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    /*INICIALIZACIÓN VENTANAS*/
    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    public boolean comprobacionBoss(String mensaje) {
        return fgui.comprobacionBoss(mensaje);
    }
    
    public boolean comprobacionAdmin(String mensaje) {
        return fgui.comprobacionAdmin(mensaje);
    }

    public void iniciaVEjemplar() {
        this.fgui.iniciaEjemplar();
    }

    public void iniciarVPrincipal() {
        fgui.iniciarVPrincipal();
    }

    public void iniciaVBPrincipal() {
        fgui.iniciaVBPrincipal();
    }

    public void iniciaVUsuarioSesiones(Usuario u) {
        fgui.iniciaUsuarioSesiones(u);
    }

    public void iniciaVGestionarUsersSesiones(Sesion s, Actividad a) {
        fgui.iniciaVGestionarUsersSesiones(s, a);
    }

    public void iniciaVCrearSesion() {
        fgui.iniciaVCrearSesion();
    }

    /*EXCEPCIÓN*/
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    /*AUTENTIFICACIONES*/
    public Boolean comprobarAutentificacion(String id, String password) {
        return cadm.comprobarAutentificacion(id, password);
    }

    public Boolean checkBoss(String id, String pass) {
        return fbd.validarBoss(id, pass);
    }

    /*ADMINISTRADORA (PARTE DEL BOSS)*/
    public java.util.List<Administrador> obtenerAdmins(Integer establecimiento, String dni) {
        return cadm.obtenerAdmins(establecimiento, dni);
    }

    public Administrador obtenerAdministrador(Establecimiento est) {
        return cadm.obtenerAdministrador(est);
    }

    public java.util.List<Administrador> obtenerAdmins() {
        return cadm.obtenerAdmins();
    }

    public Administrador visualizarAdmin(String dni) {
        return cadm.visualizarAdmin(dni);
    }
    
    public String visualizarAdmin(Integer est){
        return cadm.visualizarAdmin(est);
    }

    public void actualizarAdmin(Administrador admin) {
        cadm.actualizarAdmin(admin);
    }

    public void borrarAdmin(Administrador admin) {
        cadm.borrarAdmin(admin);
    }

    /*USUARIAS*/
    public java.util.List<Usuario> obtenerUsuarios(String dni) {
        return cu.obtenerUsuarios(dni);
    }

    public Usuario visualizarUsuario(String dniUsuario) {
        return cu.visualizarUsuario(dniUsuario);
    }

    public void actualizarUsuario(Usuario u) {
        cu.actualizarUsuario(u);
    }

    public void borrarUsuario(Usuario u) {
        cu.borrarUsuario(u);
    }

    public void insertarUsuario (Usuario u){
        cu.insertarUsuario(u);
    }
    public int consultarEstablecimientos(Usuario u) {
        return cu.consultarEstablecimientos(u);
    }

    public java.util.List<Sesion> obtenerSesionesUsuario(Usuario u, Integer est) {
        return cs.obtenerSesionesUsuario(u, est);
    }
    
    public void eliminarUsuarioSesion(Usuario u, Integer sesion, Integer est){
        cs.eliminarUsuarioSesion(u, sesion,est);
    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(String user, Integer idSesion){
        return cs.consultarPosiblesUsuarios(user, idSesion);
    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(Integer idSesion){
        return cs.consultarPosiblesUsuarios(idSesion);
    }
    
    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(String user, Integer idSesion){
        return  cs.consultarUsuariosdeUnaSesion(user, idSesion);
    }
    
    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(Integer idSesion){
        return  cs.consultarUsuariosdeUnaSesion(idSesion);
    }

    /*ESTABLECIMIENTOS*/
    public java.util.List<Establecimiento> obtenerEstablecimientos(Integer id) {
        return ce.obtenerEstablecimientos(id);
    }

    public java.util.List<Establecimiento> obtenerEstablecimientos() {
        return ce.obtenerEstablecimientos();
    }

    public Establecimiento buscarEstablecimiento(int id_establecimiento) {
        return ce.buscarEstablecimiento(id_establecimiento);
    }

    public void actualizarEstablecimiento(Establecimiento e) {
        ce.actualizarEstablecimiento(e);
    }
    
    public void modificarEstablecimiento(Establecimiento e){
        ce.modificarEstablecimiento(e);
    }

    public void borrarEstablecimiento(Establecimiento e, java.util.List<Monitor> monitores, java.util.List<Ejemplar> ejemplares, Administrador adm) {
        ce.borrarEstablecimiento(e, monitores, ejemplares, adm);
    }

    /*EMPLEADAS*/
    public java.util.List<Monitor> obtenerMonitores(String dni_monitor, Integer establecimiento) {
        return cm.obtenerMonitores(dni_monitor, establecimiento);
    }

    public java.util.List<Monitor> obtenerMonitores(Establecimiento establecimiento) {
        return cm.obtenerMonitores(establecimiento);
    }
    
    public java.util.List<Monitor> obtenerPosiblesMonitores (Integer establecimiento, String fecha_inicio, String horario){
        return cm.obtenerPosiblesMonitores (establecimiento, fecha_inicio, horario);
    }

    public Monitor visualizarMonitor(String dni_monitor) {
        return cm.visualizarMonitor(dni_monitor);
    }

    public void actualizarMonitor(Monitor m) {
        cm.actualizarMonitor(m);
    }

    public void borrarMonitor(String dni) {
        cm.borrarMonitor(dni);
    }

    public int getNumSesiones(Monitor m) {
        return cm.getNumSesiones(m);
    }

    /*EQUIPAMIENTOS*/
    public java.util.List<Equipamiento> obtenerEquipamiento(Integer id) {
        return ceq.obtenerEquipamiento(id);
    }

    public java.util.List<Equipamiento> obtenerEquipamiento() {
        return ceq.obtenerEquipamiento();
    }

    public Equipamiento consultarEquipamiento(int id) {
        return ceq.consultarEquipamiento(id);
    }

    public void actualizarEquipamiento(Equipamiento e) {
        ceq.actualizarEquipamiento(e);
    }

    public void borrarEquipamiento(Equipamiento equipamiento) {
        ceq.borrarEquipamiento(equipamiento);
    }

    public void crearEquipamientoEjemplares(Equipamiento equipamiento, int ejemplares, Establecimiento est) {
        ceq.crearEquipamientoEjemplares(equipamiento, ejemplares, est);
    }

    public Establecimiento getEstablecimientoActual() {
        return fgui.getEstablecimiento();
    }

    public boolean comprobacionBorrarEquipamiento(Equipamiento e) {
        return ceq.comprobacionBorrarEquipamiento(e);
    }

    /*EJEMPLARES*/
    public Ejemplar visualizarEjemplar(Integer ejemplar, Equipamiento equipamiento, Integer establecimiento) {
        return cej.visualizarEjemplar(ejemplar, equipamiento, establecimiento);
    }

    public java.util.List<Ejemplar> obtenerEjemplares(Establecimiento establecimiento) {
        return cej.obtenerEjemplares(establecimiento);
    }

    public void insertarEjemplar(Integer equipamiento, Ejemplar ej) {
        cej.insertarEjemplar(equipamiento, ej);
    }

    public void modificarEjemplar(Ejemplar e) {
        cej.modificarEjemplar(e);
    }

    public java.util.List<Ejemplar> obtenerEjemplares(Integer establecimiento, Equipamiento equipamiento) {
        return cej.obtenerEjemplares(establecimiento, equipamiento);
    }

    public java.util.List<Ejemplar> obtenerEjemplares(Integer id, Integer establecimiento, Equipamiento equipamiento) {
        return cej.obtenerEjemplares(id, establecimiento, equipamiento);
    }

    public void borrarEjemplar(Integer idej, Equipamiento equipamiento, Integer establecimiento) {
        cej.borrarEjemplar(idej, equipamiento, establecimiento);
    }


    /*ACTIVIDADES*/
    
    public void actualizarActividad(Actividad a) {
        ca.actualizarActividad(a);
    }
    
    public Actividad consultarActividad(int id) {
        return ca.consultarActividad(id);
    }

    public java.util.List<Actividad> obtenerActividades(Integer id, String nombre) {
        return ca.obtenerActividades(id, nombre);
    }

    public java.util.List<Actividad> obtenerActividades(Integer id) {
        return ca.obtenerActividades(id);
    }

    public java.util.List<Actividad> obtenerActividades(String nombre) {
        return ca.obtenerActividades(nombre);
    }

    public java.util.List<Actividad> obtenerActividades() {
        return ca.obtenerActividades();
    }
    
    public void borrarActividad (Actividad a){
        ca.borrarActividad(a);
    }
    
    public boolean consultarActividadRepetida(String nombre){
        return ca.consultarActividadRepetida(nombre);
    }
    

    /* SESIONES */
    public Sesion obtenerSesion(Integer s) {
        return cs.obtenerSesion(s);
    }

    public void borrarSesion(Sesion s) {
        cs.borrarSesion(s);
    }

    public java.util.List<Sesion> obtenerSesiones(Integer s, Actividad a, Integer establecimiento) {
        return cs.obtenerSesiones(s, a, establecimiento);
    }

    public java.util.List<Sesion> obtenerSesiones(Actividad a, Integer establecimiento) {
        return cs.obtenerSesiones(a, establecimiento);
    }

    public java.util.List<Sesion> obtenerSesiones() {
        return cs.obtenerSesiones();
    }

    public void addUserToSesion(Usuario usuario, Integer sesion, Integer actividad) {
        cs.addUserToSesion(usuario, sesion, actividad);
    }
    
    public void insertarSesion(Actividad actividad, Monitor monitor, String fecha_inicio, Integer np, Integer establecimiento){
        cs.insertarSesion(actividad, monitor, fecha_inicio, np, establecimiento);
    }

    public String visualizarUsuarioSesion (String u){
        return cs.visualizarUsuarioSesion(u);
    }
}
