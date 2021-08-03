/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Actividad;
import aplicacion.Monitor;
import aplicacion.Sesion;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumnogreibd
 */
class DAOSesiones extends AbstractDAO{
    public DAOSesiones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    
    public java.util.List<Sesion> obtenerSesionesUsuario(Usuario u, Integer est){
        java.util.List<Sesion> resultado = new java.util.ArrayList<Sesion>();
        Sesion sesionActual;
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion;

        con = this.getConexion();
        
        String consulta = "select sesion.id_sesion, sesion.actividad, sesion.dni_monitor, sesion.fecha_inicio, sesion.plazas, sesion.establecimiento "
                        + "from sesion inner join usuario_en_sesion "
                        + "  on usuario_en_sesion.sesion = sesion.id_sesion "
                        + "where usuario_en_sesion.usuario like ? and sesion.establecimiento = ? ";
        
        try {
            stmSesion = con.prepareStatement(consulta);
            stmSesion.setString(1, u.getDni_usuario());
            stmSesion.setInt(2, est);
            rsSesion = stmSesion.executeQuery();
            while (rsSesion.next()) {
                sesionActual =  new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
                        rsSesion.getInt("plazas"), rsSesion.getInt("establecimiento"));
                
                resultado.add(sesionActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSesion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public Sesion obtenerSesion(Integer s){
        Sesion resultado=null;
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion= null;
        
        con= super.getConexion();
        
        try{
            stmSesion= con.prepareStatement("select id_sesion, actividad, dni_monitor, fecha_inicio, plazas, establecimiento "
                    + "from sesion "
                    + "where id_sesion = ? ");
            stmSesion.setInt(1, s);
            rsSesion= stmSesion.executeQuery();
            if(rsSesion.next()){
                resultado= new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
                         rsSesion.getInt("plazas"), rsSesion.getInt("establecimiento"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmSesion.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Sesion> obtenerSesiones(Integer s, Actividad a, Integer establecimiento){
        java.util.List<Sesion> resultado= new java.util.ArrayList<Sesion>();
        Sesion sesionActual = null;
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion= null;
        
        con= super.getConexion();
        
        try{
            stmSesion= con.prepareStatement("select id_sesion, actividad, dni_monitor, fecha_inicio, plazas, establecimiento "
                    + "from sesion "
                    + "where id_sesion = ? and actividad = ? and establecimiento = ?");
            stmSesion.setInt(1, s);
            stmSesion.setInt(2, a.getId());
            stmSesion.setInt(3, establecimiento);
            rsSesion= stmSesion.executeQuery();
            if(rsSesion.next()){
                sesionActual= new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
                        rsSesion.getInt("plazas"), rsSesion.getInt("establecimiento"));
                resultado.add(sesionActual);
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmSesion.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Sesion> obtenerSesiones(Actividad a, Integer establecimiento){
        java.util.List<Sesion> resultado= new java.util.ArrayList<Sesion>();
        Sesion sesionActual = null;
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion= null;
        
        con= super.getConexion();
        
        try{
            stmSesion= con.prepareStatement("select id_sesion, actividad, dni_monitor, fecha_inicio, plazas, establecimiento "
                    + "from sesion "
                    + "where actividad = ? and establecimiento = ?");
            stmSesion.setInt(1, a.getId());
            stmSesion.setInt(2, establecimiento);
            rsSesion= stmSesion.executeQuery();
            if(rsSesion.next()){
                sesionActual= new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
                        rsSesion.getInt("plazas"), rsSesion.getInt("establecimiento"));
                resultado.add(sesionActual);
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmSesion.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Sesion> obtenerSesiones(){
        java.util.List<Sesion> resultado=null;
        Sesion sesionActual = null;
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion= null;
        
        con= super.getConexion();
        
        try{
            stmSesion= con.prepareStatement("select id_sesion, actividad, dni_monitor, fecha_inicio, plazas, establecimiento "
                    + "from sesion ");
            rsSesion= stmSesion.executeQuery();
            if(rsSesion.next()){
                sesionActual= new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
                        rsSesion.getInt("plazas"), rsSesion.getInt("establecimiento"));
                resultado.add(sesionActual);
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmSesion.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void borrarSesion(Sesion s){
        Connection con;
        PreparedStatement stmSesion = null;

        con = super.getConexion();

        try {
            stmSesion = con.prepareStatement("delete from sesion "
                    + "where id_sesion=?");
            stmSesion.setInt(1, s.getIdSesion());
            
            con.setAutoCommit(true);
            stmSesion.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSesion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void addUserToSesion(Usuario user, Integer sesion, Integer establecimiento){
        Connection con;
        PreparedStatement stmSesion = null;

        con = super.getConexion();

        try {
            stmSesion = con.prepareStatement("insert into usuario_en_sesion(usuario, sesion, establecimiento) values (?,?,?)");
            stmSesion.setString(1, user.getDni_usuario());
            stmSesion.setInt(2, sesion);
            stmSesion.setInt(3, establecimiento);

            con.setAutoCommit(true);
            stmSesion.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSesion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void insertarSesion(Actividad actividad, Monitor monitor, String fecha_inicio, Integer np, Integer establecimiento){
        Connection con;
        PreparedStatement stmSesion = null;
        
        con= super.getConexion();
        
        try{
            stmSesion = con.prepareStatement("insert into sesion (actividad, dni_monitor, fecha_inicio, plazas, establecimiento) "
            + "values (?,?,?,?,?)");
            stmSesion.setInt(1, actividad.getId());
            stmSesion.setString(2, monitor.getDni());
            stmSesion.setString(3, fecha_inicio);
            stmSesion.setInt(4, np);
            stmSesion.setInt(5, establecimiento);
            
            con.setAutoCommit(true);
            stmSesion.executeUpdate();
            con.setAutoCommit(false);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmSesion.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void eliminarUsuarioSesion(Usuario u, Integer sesion, Integer establecimiento){
        Connection con;
        PreparedStatement stmSesion = null;

        con = super.getConexion();

        try {
            stmSesion = con.prepareStatement("DELETE FROM usuario_en_sesion"
            + " WHERE usuario = ? and sesion = ? and establecimiento = ?");
            stmSesion.setString(1, u.getDni_usuario());
            stmSesion.setInt(2, sesion);
            stmSesion.setInt(3, establecimiento);

            con.setAutoCommit(true);
            stmSesion.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSesion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
    }
    
    public String visualizarUsuarioSesion(String u){
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        String dni;
        Usuario user = null;
        
        con= super.getConexion();
        
        String consulta = "select from usuario_en_sesion where usuario = ?";
        try{
            stmUsuario =con.prepareStatement(consulta);
            stmUsuario.setString(1, u);
            rsUsuario= stmUsuario.executeQuery();
            if(rsUsuario.next()){
                user= new Usuario (rsUsuario.getString("dni_usuario"), 
                        rsUsuario.getString("nombre"), rsUsuario.getString("email"), 
                        rsUsuario.getString("telefono"), rsUsuario.getBoolean("socio"));
                
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmUsuario.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return user.getDni_usuario();
    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(String user, Integer idSesion) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUser = null;
        ResultSet rsUsers;

        con = this.getConexion();

        String consulta = "select u.*"
                + " from usuario as u"
                + " except"
                + " select u.*"
                + " from usuario_en_sesion as s, usuario as u"
                + " where s.sesion = ? and s.usuario = ?"
                + "   and s.establecimiento = ?";

        try {
            stmUser = con.prepareStatement(consulta);
            stmUser.setInt(1, idSesion);
            stmUser.setString(2, user);
            stmUser.setInt(3, super.getFachadaAplicacion().getEstablecimientoActual().getId_establecimiento());
            rsUsers = stmUser.executeQuery();
            while (rsUsers.next()) {
                usuarioActual = new Usuario(rsUsers.getString("dni_usuario"), rsUsers.getString("nombre"),
                        rsUsers.getString("email"), rsUsers.getString("telefono"),
                        rsUsers.getBoolean("socio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUser.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;

    }
    
    public java.util.List<Usuario> consultarPosiblesUsuarios(Integer idSesion) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUser = null;
        ResultSet rsUsers;

        con = this.getConexion();

        String consulta = "select u.*"
                + " from usuario as u"
                + " except"
                + " select u.*"
                + " from usuario_en_sesion as s, usuario as u"
                + " where s.usuario = u.dni_usuario"
                + "   and s.sesion = ? and s.establecimiento = ?";

        try {
            stmUser = con.prepareStatement(consulta);
            stmUser.setInt(1, idSesion);
            stmUser.setInt(2, super.getFachadaAplicacion().getEstablecimientoActual().getId_establecimiento());
            rsUsers = stmUser.executeQuery();
            while (rsUsers.next()) {
                usuarioActual = new Usuario(rsUsers.getString("dni_usuario"), rsUsers.getString("nombre"),
                        rsUsers.getString("email"), rsUsers.getString("telefono"),
                        rsUsers.getBoolean("socio"));
                resultado.add(usuarioActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUser.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;

    }
    
    public java.util.List<Usuario> consultarUsuariosDeUnaSesion(String user, Integer idSesion) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUser = null;
        ResultSet rsUsers;

        con = this.getConexion();

        String consulta = "select u.* "
            + "from usuario as u right join usuario_en_sesion as s on u.dni_usuario = s.usuario "
            + "where s.sesion = ? and s.usuario = ? and s.establecimiento = ?";

        try {
            stmUser = con.prepareStatement(consulta);
            stmUser.setInt(1, idSesion);
            stmUser.setString(2, user);
            stmUser.setInt(3, super.getFachadaAplicacion().getEstablecimientoActual().getId_establecimiento());
            rsUsers = stmUser.executeQuery();
            while (rsUsers.next()) {
                usuarioActual = new Usuario(rsUsers.getString("dni_usuario"), rsUsers.getString("nombre"),
                        rsUsers.getString("email"), rsUsers.getString("telefono"),
                        rsUsers.getBoolean("socio"));
                resultado.add(usuarioActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUser.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;

    }
    
    public java.util.List<Usuario> consultarUsuariosDeUnaSesion(Integer idSesion) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUser = null;
        ResultSet rsUsers;

        con = this.getConexion();

        String consulta = "select u.* "
            + "from usuario as u right join usuario_en_sesion as s on u.dni_usuario = s.usuario "
            + "where s.sesion = ? and s.establecimiento = ?";

        try {
            stmUser = con.prepareStatement(consulta);
            stmUser.setInt(1, idSesion);
            stmUser.setInt(2, super.getFachadaAplicacion().getEstablecimientoActual().getId_establecimiento());
            rsUsers = stmUser.executeQuery();
            while (rsUsers.next()) {
                usuarioActual = new Usuario(rsUsers.getString("dni_usuario"), rsUsers.getString("nombre"),
                        rsUsers.getString("email"), rsUsers.getString("telefono"),
                        rsUsers.getBoolean("socio"));
                resultado.add(usuarioActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUser.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;

    }
}
