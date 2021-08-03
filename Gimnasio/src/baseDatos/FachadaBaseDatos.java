package baseDatos;

import aplicacion.Administrador;
import aplicacion.Ejemplar;
import aplicacion.Equipamiento;
import aplicacion.Establecimiento;
import aplicacion.Monitor;
import aplicacion.Sesion;
import aplicacion.Actividad;
import aplicacion.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import javax.crypto.spec.SecretKeySpec;
import aplicacion.ProtectedConfigFile;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author sofiamartinezparada
 */
public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOAdministradores daoAdministradores;
    private DAOMonitores daoMonitores;
    private DAOUsuarios daoUsuarios;
    private DAOEstablecimientos daoEstablecimientos;
    private DAOEquipamiento daoEquipamiento;
    private DAOEjemplares daoEjemplares;
    private DAOSesiones daoSesiones;
    private DAOActividades daoActividades;

    private Properties configuracion;
    private Properties boss;
    private ProtectedConfigFile pf;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) throws NoSuchAlgorithmException, InvalidKeySpecException, GeneralSecurityException {
        configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;
        try {
            //Tratado del encriptado del archivo de configuración
            String password = "secret";
            // The salt (probably) can be stored along with the encrypted data
            byte[] salt = new String("12345678").getBytes();

            // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
            int iterationCount = 40000;
            int keyLength = 128;
            //Clave de desencriptado para las contraseñas
            SecretKeySpec key = pf.createSecretKey(password.toCharArray(),
                    salt, iterationCount, keyLength);
            
            
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);

            Properties usuario = new Properties();
            boss = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", pf.decrypt(configuracion.getProperty("clave"), key));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            boss.setProperty("user", configuracion.getProperty("boss"));
            boss.setProperty("password", pf.decrypt(configuracion.getProperty("bosspwd"), key));

            arqConfiguracion.close();

            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoAdministradores = new DAOAdministradores(conexion, fa);
            daoMonitores = new DAOMonitores(conexion, fa);
            daoEstablecimientos = new DAOEstablecimientos(conexion, fa);
            daoEquipamiento = new DAOEquipamiento(conexion, fa);
            daoEjemplares = new DAOEjemplares(conexion, fa);
            daoSesiones = new DAOSesiones(conexion, fa);
            daoActividades = new DAOActividades(conexion, fa);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

    /*ADMINISTRADOR*/
    public Administrador validarAdministrador(String id, String contra) {
        return daoAdministradores.validarAdministrador(id, contra);
    }

    public java.util.List<Administrador> obtenerAdmins(Integer establecimiento, String dni) {
        return daoAdministradores.obtenerAdmins(establecimiento, dni);
    }

    public Administrador obtenerAdministrador(Establecimiento est) {
        return daoAdministradores.obtenerAdministrador(est);
    }

    public java.util.List<Administrador> obtenerAdmins() {
        return daoAdministradores.obtenerAdmins();
    }

    public Administrador visualizarAdmin(String dni) {
        return daoAdministradores.visualizarAdmin(dni);
    }

    public String visualizarAdmin(Integer est) {
        return daoAdministradores.visualizarAdmin(est);
    }

    public Administrador validarAdmin(String dni) {
        return daoAdministradores.validarAdministrador(dni);
    }

    public void insertarAdmin(Administrador admin) {
        daoAdministradores.insertarAdmin(admin);
    }

    public void modificarAdmin(Administrador admin) {
        daoAdministradores.modificarAdmin(admin);
    }

    public void borrarAdmin(Administrador admin) {
        daoAdministradores.borrarAdmin(admin);
    }

    /*USUARIOS*/
    public Usuario visualizarUsuario(String dni) {
        return daoUsuarios.visualizarUsuario(dni);
    }

    public java.util.List<Usuario> obtenerUsuarios(String dni) {
        return daoUsuarios.consultarUsuarios(dni);
    }

    public void insertarUsuario(Usuario u) {
        daoUsuarios.insertarUsuario(u);
    }

    public void modificarUsuario(Usuario u) {
        daoUsuarios.modificarUsuario(u);
    }

    public void borrarUsuario(Usuario u) {
        daoUsuarios.borrarUsuario(u);
    }

    public int consultarNumEstUsuario(Usuario u) {
        return daoUsuarios.consultarNumEst(u);
    }

    public java.util.List<Sesion> obtenerSesionesUsuario(Usuario u, Integer est) {
        return daoSesiones.obtenerSesionesUsuario(u, est);
    }

    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(String user, Integer idSesion) {
        return daoSesiones.consultarUsuariosDeUnaSesion(user, idSesion);
    }

    public java.util.List<Usuario> consultarUsuariosdeUnaSesion(Integer idSesion) {
        return daoSesiones.consultarUsuariosDeUnaSesion(idSesion);
    }

    public java.util.List<Usuario> consultarPosiblesUsuarios(String user, Integer idSesion) {
        return daoSesiones.consultarPosiblesUsuarios(user, idSesion);
    }

    public java.util.List<Usuario> consultarPosiblesUsuarios(Integer idSesion) {
        return daoSesiones.consultarPosiblesUsuarios(idSesion);
    }

    /*ESTABLECIMIENTOS*/
    public java.util.List<Establecimiento> consultarEstablecimientos(Integer id) {
        return daoEstablecimientos.consultarEstablecimientos(id);
    }

    public java.util.List<Establecimiento> consultarEstablecimientos() {
        return daoEstablecimientos.consultarEstablecimientos();
    }

    public Establecimiento buscarEstablecimiento(int id_establecimiento) {
        return daoEstablecimientos.buscarEstablecimiento(id_establecimiento);
    }

    public void insertarEstablecimiento(Establecimiento e) {
        daoEstablecimientos.insertarEstablecimiento(e);
    }

    public void modificarEstablecimiento(Establecimiento e) {
        daoEstablecimientos.modificarEstablecimiento(e);
    }

    public void borrarEstablecimiento(Establecimiento e, java.util.List<Monitor> monitores, java.util.List<Ejemplar> ejemplares, Administrador adm) {
        daoEstablecimientos.borrarEstablecimiento(e, monitores, ejemplares, adm);
    }

    /*EMPLEADOS*/
    public java.util.List<Monitor> consultarMonitores(String dni_monitor, Integer establecimiento) {
        return daoMonitores.consultarMonitores(dni_monitor, establecimiento);
    }

    public java.util.List<Monitor> consultarMonitores(Establecimiento establecimiento) {
        return daoMonitores.consultarMonitores(establecimiento);
    }

    public java.util.List<Monitor> consultarPosiblesMonitores(Integer establecimiento, String fecha_inicio, String horario) {
        return daoMonitores.consultarPosiblesMonitores(establecimiento, fecha_inicio, horario);
    }

    public Monitor consultarMonitor(String dni_monitor) {
        return daoMonitores.consultarMonitor(dni_monitor);
    }

    public Monitor validarMonitor(String dni) {
        return daoMonitores.validarMonitor(dni);
    }

    public void insertarMonitor(Monitor m) {
        daoMonitores.insertarMonitor(m);
    }

    public void modificarMonitor(Monitor m) {
        daoMonitores.modificarMonitor(m);
    }

    public void borrarMonitor(String dni) {
        daoMonitores.borrarMonitor(dni);
    }

    public int getNumSesiones(Monitor m) {
        return daoMonitores.getNumSesiones(m);
    }


    /*EQUIPAMIENTOS*/
    public java.util.List<Equipamiento> obtenerEquipamiento(Integer id) {
        return daoEquipamiento.obtenerEquipamiento(id);
    }

    public java.util.List<Equipamiento> obtenerEquipamiento() {
        return daoEquipamiento.obtenerEquipamiento();
    }

    public Equipamiento consultarEquipamiento(int id) {
        return daoEquipamiento.consultarEquipamiento(id);
    }

    public void crearEquipamientoEjemplares(Equipamiento e, int ejemplares, Establecimiento est) {
        daoEquipamiento.crearEquipamientoEjemplares(e, ejemplares, est);
    }

    public void insertarEquipamiento(Equipamiento e) {
        daoEquipamiento.insertarEquipamiento(e);
    }

    public void modificarEquipamiento(Equipamiento e) {
        daoEquipamiento.modificarEquipamiento(e);
    }

    public void borrarEquipamiento(Equipamiento e) {
        daoEquipamiento.borrarEquipamiento(e);
    }

    public boolean comprobacionBorrarEquipamiento(Equipamiento e) {
        return daoEquipamiento.comprobarBorrado(e);
    }

    /*EJEMPLARES*/
    public java.util.List<Ejemplar> consultarEjemplares(Integer establecimiento, Equipamiento equipamiento) {
        return daoEjemplares.consultarEjemplares(establecimiento, equipamiento);
    }

    public java.util.List<Ejemplar> consultarEjemplares(Integer id, Integer establecimiento, Equipamiento equipamiento) {
        return daoEjemplares.consultarEjemplares(id, establecimiento, equipamiento);
    }

    public java.util.List<Ejemplar> consultarEjemplares(Establecimiento establecimiento) {
        return daoEjemplares.consultarEjemplares(establecimiento);
    }

    public Ejemplar consultarEjemplar(Integer ejemplar, Equipamiento equipamiento, Integer establecimiento) {
        return daoEjemplares.consultarEjemplar(ejemplar, equipamiento, establecimiento);
    }

    public void insertarEjemplar(Integer equipamiento, Ejemplar ej) {
        daoEjemplares.insertarEjemplar(equipamiento, ej);
    }

    public void modificarEjemplar(Ejemplar e) {
        daoEjemplares.modificarEjemplar(e);
    }

    public void borrarEjemplar(Integer idej, Equipamiento equipamiento, Integer establecimiento) {
        daoEjemplares.borrarEjemplar(idej, equipamiento, establecimiento);
    }

    /*ACTIVIDADES*/
    public Actividad consultarActividad(int id) {
        return daoActividades.visualizarActividad(id);
    }

    public java.util.List<Actividad> obtenerActividades(Integer id, String nombre) {
        return daoActividades.obtenerActividades(id, nombre);
    }

    public java.util.List<Actividad> obtenerActividades(Integer id) {
        return daoActividades.obtenerActividades(id);
    }

    public java.util.List<Actividad> obtenerActividades(String nombre) {
        return daoActividades.obtenerActividades(nombre);
    }

    public java.util.List<Actividad> obtenerActividades() {
        return daoActividades.obtenerActividades();
    }

    public void borrarActividad(Actividad a) {
        daoActividades.borrarActividad(a);
    }

    public void modificarActividad(Actividad a) {
        daoActividades.modificarActividad(a);
    }

    public void insertarActividad(Actividad a) {
        daoActividades.insertarActividad(a);
    }
    
    public boolean consultarActividadRepetida(String nombre){
        if(daoActividades.obtenerActividades(nombre).size() != 0) return true;
        else return false;
    }

    /* SESIONES */
    public Sesion obtenerSesion(Integer s) {
        return daoSesiones.obtenerSesion(s);
    }

    public java.util.List<Sesion> obtenerSesiones(Integer s, Actividad a, Integer establecimiento) {
        return daoSesiones.obtenerSesiones(s, a, establecimiento);
    }

    public java.util.List<Sesion> obtenerSesiones(Actividad a, Integer establecimiento) {
        return daoSesiones.obtenerSesiones(a, establecimiento);
    }

    public java.util.List<Sesion> obtenerSesiones() {
        return daoSesiones.obtenerSesiones();
    }

    public void borrarSesion(Sesion s) {
        daoSesiones.borrarSesion(s);
    }

    public void addUserToSesion(Usuario usuario, Integer sesion, Integer est) {
        daoSesiones.addUserToSesion(usuario, sesion, est);
    }

    public void insertarSesion(Actividad actividad, Monitor monitor, String fecha_inicio, Integer np, Integer establecimiento) {
        daoSesiones.insertarSesion(actividad, monitor, fecha_inicio, np, establecimiento);
    }

    public void eliminarUsuarioSesion(Usuario u, Integer sesion, Integer est) {
        daoSesiones.eliminarUsuarioSesion(u, sesion, est);
    }

    public String visualizarUsuarioSesion(String u) {
        return daoSesiones.visualizarUsuarioSesion(u);
    }

    /*BOSS*/
    public Boolean validarBoss(String dni_admin, String password) {
        if (this.boss.getProperty("user").contentEquals(dni_admin)) {
            if (this.boss.getProperty("password").contentEquals(password)) {
                return true;
            }
        }
        return false;
    }
    
    

    //Método de encriptado en el archivo de configuración
    //String encryptedPasswordAdmin = pf.encrypt(configuracion.getProperty("clave"), key);
    //String encryptedPasswordBoss = pf.encrypt(configuracion.getProperty("bosspwd"), key);
//            String uuu = configuracion.getProperty("clave");
//            String ee = configuracion.getProperty("bosspwd");
//            String uuudd = pf.decrypt(uuu, key);
//            String eedd = pf.decrypt(ee, key);
    
}
