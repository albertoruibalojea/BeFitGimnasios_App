package baseDatos;

import java.sql.*;
import aplicacion.Actividad;

/**
 *
 * @author sofiamartinezparada
 */
public class DAOActividades extends AbstractDAO {

    public DAOActividades(Connection con, aplicacion.FachadaAplicacion fa) {
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }

    public Actividad visualizarActividad(int id) {
        Actividad actividadActual = null;
        Connection con;
        PreparedStatement stmActividad = null;
        ResultSet rsActividad = null;

        con = this.getConexion();

        String consulta = "select id_actividad, nombre from actividad where id_actividad = ?";

        try {
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setInt(1, id);
            rsActividad = stmActividad.executeQuery();
            while (rsActividad.next()) {
                actividadActual = new Actividad(rsActividad.getInt("id_actividad"), rsActividad.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return actividadActual;
    }

    public java.util.List<Actividad> obtenerActividades(Integer id, String nombre) {
        java.util.List<Actividad> resultado = new java.util.ArrayList<Actividad>();
        Actividad actividadActual = null;
        Connection con;
        PreparedStatement stmActividad = null;
        ResultSet rsActividad = null;

        con = super.getConexion();

        String consulta = "select id_actividad, nombre from actividad where id_actividad = ? and nombre = ?";

        try {
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setInt(1, id);
            stmActividad.setString(2, nombre);
            rsActividad = stmActividad.executeQuery();
            while (rsActividad.next()) {
                actividadActual = new Actividad(rsActividad.getInt("id_actividad"), rsActividad.getString("nombre"));
                resultado.add(actividadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Actividad> obtenerActividades(Integer id) {
        java.util.List<Actividad> resultado = new java.util.ArrayList<Actividad>();
        Actividad actividadActual = null;
        Connection con;
        PreparedStatement stmActividad = null;
        ResultSet rsActividad = null;

        con = super.getConexion();

        String consulta = "select id_actividad, nombre from actividad where id_actividad = ?";

        try {
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setInt(1, id);
            rsActividad = stmActividad.executeQuery();
            while (rsActividad.next()) {
                actividadActual = new Actividad(rsActividad.getInt("id_actividad"), rsActividad.getString("nombre"));
                resultado.add(actividadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Actividad> obtenerActividades(String nombre) {
        java.util.List<Actividad> resultado = new java.util.ArrayList<Actividad>();
        Actividad actividadActual = null;
        Connection con;
        PreparedStatement stmActividad = null;
        ResultSet rsActividad = null;

        con = super.getConexion();

        String consulta = "select id_actividad, nombre from actividad where nombre = ?";

        try {
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setString(1, nombre);
            rsActividad = stmActividad.executeQuery();
            while (rsActividad.next()) {
                actividadActual = new Actividad(rsActividad.getInt("id_actividad"), rsActividad.getString("nombre"));
                resultado.add(actividadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Actividad> obtenerActividades() {
        java.util.List<Actividad> resultado = new java.util.ArrayList<Actividad>();
        Actividad actividadActual = null;
        Connection con;
        PreparedStatement stmActividad = null;
        ResultSet rsActividad = null;

        con = super.getConexion();

        String consulta = "select id_actividad, nombre from actividad ";

        try {
            stmActividad = con.prepareStatement(consulta);
            rsActividad = stmActividad.executeQuery();
            while (rsActividad.next()) {
                actividadActual = new Actividad(rsActividad.getInt("id_actividad"), rsActividad.getString("nombre"));
                resultado.add(actividadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void borrarActividad (Actividad a){
        Connection con;
        PreparedStatement stmActividad= null;
        
        con= super.getConexion();
        
        String consulta= "delete from actividad where id_actividad = ?";
        
        try{
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setInt(1, a.getId());
            
            con.setAutoCommit(true);
            stmActividad.executeUpdate();
            con.setAutoCommit(false);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarActividad (Actividad a){
        Connection con;
        PreparedStatement stmActividad = null;
        
        con = super.getConexion();
        
        String consulta = "update actividad set nombre = ?, id_actividad=? where id_actividad = ? ";
        
        try{
            stmActividad = con.prepareStatement(consulta);
            stmActividad.setString(1, a.getNombre());
            stmActividad.setInt(2, a.getId());
            stmActividad.setInt(3, a.getId());
            
            con.setAutoCommit(true);
            stmActividad.executeUpdate();
            con.setAutoCommit(false);
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void insertarActividad(Actividad actividad){
        Connection con;
        PreparedStatement stmActividad = null;

        con = super.getConexion();

        try {
            stmActividad = con.prepareStatement("insert into actividad(nombre, id_actividad) values (?,?)");
            stmActividad.setString(1, actividad.getNombre());
            stmActividad.setInt(2, actividad.getId());
           
            con.setAutoCommit(true);
            stmActividad.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}
