/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

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
public class DAOUsuarios extends AbstractDAO {
    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Usuario> consultarUsuarios(String dni) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;

        con = this.getConexion();

        String consulta = "select dni_usuario, nombre, email, telefono, socio "
                + "from usuario as u "
                + "where dni_usuario like ?";

        try {
            stmUsuarios = con.prepareStatement(consulta);
            stmUsuarios.setString(1, "%" + dni + "%");

            rsUsuarios = stmUsuarios.executeQuery();

            while (rsUsuarios.next()) {
                usuarioActual = new Usuario(rsUsuarios.getString("dni_usuario"), rsUsuarios.getString("nombre"),
                        rsUsuarios.getString("email"), rsUsuarios.getString("telefono"),
                        rsUsuarios.getBoolean("socio"));

                resultado.add(usuarioActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuarios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public Usuario visualizarUsuario(String dni) {
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario= null;
        
        con= super.getConexion();
        
        try{
            stmUsuario= con.prepareStatement("select dni_usuario, nombre, email, telefono, socio "
            + "from usuario "
            + "where dni_usuario = ? ");
            stmUsuario.setString(1, dni);
            rsUsuario= stmUsuario.executeQuery();
            if(rsUsuario.next()){
                resultado= new Usuario (rsUsuario.getString("dni_usuario"), 
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
        return resultado;
    }
       
    public void insertarUsuario(Usuario usuario) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("insert into usuario(dni_usuario, nombre, email, telefono, socio) "
                    + "values (?,?,?,?,?)");
            stmUsuario.setString(1, usuario.getDni_usuario());
            stmUsuario.setString(2, usuario.getNombre());
            stmUsuario.setString(3, usuario.getEmail());
            stmUsuario.setString(4, usuario.getTelefono());
            stmUsuario.setBoolean(5, usuario.isSocio());
            
            con.setAutoCommit(true);
            stmUsuario.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarUsuario(Usuario usuario) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("update usuario "
                    + "set nombre=?, "
                    + "    email=?, "
                    + "    telefono=?, "
                    + "    socio=? "
                    + "where dni_usuario=?");
            
            stmUsuario.setString(1, usuario.getNombre());
            stmUsuario.setString(2, usuario.getEmail());
            stmUsuario.setString(3, usuario.getTelefono());
            stmUsuario.setBoolean(4, usuario.isSocio());
            stmUsuario.setString(5, usuario.getDni_usuario());
            
            con.setAutoCommit(true);
            stmUsuario.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void borrarUsuario(Usuario usuario) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("delete from usuario "
                    + "where dni_usuario=?");
            stmUsuario.setString(1, usuario.getDni_usuario());
            
            con.setAutoCommit(true);
            stmUsuario.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public int consultarNumEst(Usuario u){
        java.util.List<Sesion> resultado = new java.util.ArrayList<Sesion>();
        Connection con;
        PreparedStatement stm = null;
        ResultSet rs;

        con = super.getConexion();

        try {
            stm = con.prepareStatement("select s.id_sesion, s.actividad, s.dni_monitor, s.fecha_inicio, s.plazas, s.establecimiento "
                    + "from sesion as s inner join usuario_en_sesion as u "
                    + " on u.sesion = s.id_sesion "
                    + " where u.usuario like ? ");

            stm.setString(1, "%" + u.getDni_usuario() + "%");
            rs = stm.executeQuery();

            while (rs.next()) {
                
                resultado.add(new Sesion(rs.getInt("id_sesion"), rs.getInt("actividad"), rs.getString("dni_monitor"), rs.getString("fecha_inicio"),
                        rs.getInt("plazas"), rs.getInt("establecimiento")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado.size();
    }
}
