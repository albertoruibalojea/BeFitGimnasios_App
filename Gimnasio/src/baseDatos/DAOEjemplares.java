package baseDatos;

import java.sql.*;
import aplicacion.Ejemplar;
import aplicacion.Equipamiento;
import aplicacion.Establecimiento;

/**
 *
 * @author alumnogreibd
 */
public class DAOEjemplares extends AbstractDAO {

    public DAOEjemplares(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Ejemplar> consultarEjemplares(Integer establecimiento, Equipamiento equipamiento) {
        java.util.List<Ejemplar> resultado = new java.util.ArrayList<Ejemplar>();
        Ejemplar ejemplarActual;
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;
        Integer id= equipamiento.getId();

        con = this.getConexion();

        String consulta = "select equipamiento, id_ejemplar, descripcion, ano_compra, establecimiento "
                + "from ejemplar as e "
                + "where establecimiento = ? and"
                + " equipamiento = ?";

        try {
            stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, establecimiento);
            stmEjemplar.setInt(2, id);
            rsEjemplar = stmEjemplar.executeQuery();
            while (rsEjemplar.next()) {
                ejemplarActual = new Ejemplar(equipamiento, rsEjemplar.getInt("id_ejemplar"), rsEjemplar.getString("descripcion"), rsEjemplar.getInt("ano_compra"), rsEjemplar.getInt("establecimiento"));
                resultado.add(ejemplarActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    
    public java.util.List<Ejemplar> consultarEjemplares(Integer id,  Integer establecimiento, Equipamiento equipamiento) {
        java.util.List<Ejemplar> resultado = new java.util.ArrayList<Ejemplar>();
        Ejemplar ejemplarActual;
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;
        Integer id_equipamiento= equipamiento.getId();

        con = this.getConexion();

        String consulta = "select equipamiento, id_ejemplar, descripcion, ano_compra, establecimiento "
                + "from ejemplar as e "
                + "where establecimiento = ? and"
                + " equipamiento = ? and id_ejemplar = ?";

        try {
            stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, establecimiento);
            stmEjemplar.setInt(2, id_equipamiento);
            stmEjemplar.setInt (3, id);
            rsEjemplar = stmEjemplar.executeQuery();
            while (rsEjemplar.next()) {
                ejemplarActual = new Ejemplar(equipamiento, rsEjemplar.getInt("id_ejemplar"), rsEjemplar.getString("descripcion"), rsEjemplar.getInt("ano_compra"), rsEjemplar.getInt("establecimiento"));
                resultado.add(ejemplarActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
     public java.util.List<Ejemplar> consultarEjemplares(Establecimiento establecimiento) {
        java.util.List<Ejemplar> resultado = new java.util.ArrayList<Ejemplar>();
        Ejemplar ejemplarActual;
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;

        con = this.getConexion();

        String consulta = "select equipamiento, id_ejemplar, descripcion, ano_compra, establecimiento "
                + "from ejemplar as e "
                + "where establecimiento = ?";

        try {
            stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, establecimiento.getId_establecimiento());
            rsEjemplar = stmEjemplar.executeQuery();
            while (rsEjemplar.next()) {
                ejemplarActual = new Ejemplar(rsEjemplar.getInt("id_ejemplar"), rsEjemplar.getString("descripcion"), rsEjemplar.getInt("ano_compra"), rsEjemplar.getInt("establecimiento"));
                resultado.add(ejemplarActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void insertarEjemplar(Integer equipamiento, Ejemplar ej) {
        Connection con;
        PreparedStatement stmEjemplar = null;
        con = super.getConexion();

        String consulta = "insert into ejemplar (equipamiento, descripcion, ano_compra, establecimiento) "
                + "values (?,?,?,?)";
        try {
            stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, equipamiento);
            stmEjemplar.setString(2, ej.getDescripcion());
            stmEjemplar.setInt(3, ej.getAno_compra());
            stmEjemplar.setInt(4, ej.getEstablecimiento());
            
            con.setAutoCommit(true);
            stmEjemplar.executeUpdate();
            con.setAutoCommit(false);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public Ejemplar consultarEjemplar(Integer ejemplar, Equipamiento equipamiento, Integer establecimiento) {
        Ejemplar resultado = null;
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;
        Integer id= equipamiento.getId();

        con = super.getConexion();

        String consulta = "select equipamiento, id_ejemplar, descripcion, ano_compra, establecimiento "
                + "from ejemplar as e "
                + "where establecimiento = ? and"
                + " equipamiento = ? and id_ejemplar = ?";

        try {
             stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, establecimiento);
            stmEjemplar.setInt(2, id);
            stmEjemplar.setInt(3, ejemplar);
            rsEjemplar = stmEjemplar.executeQuery();
            while (rsEjemplar.next()) {
                resultado = new Ejemplar(equipamiento, rsEjemplar.getInt("id_ejemplar"), rsEjemplar.getString("descripcion"), rsEjemplar.getInt("ano_compra"), rsEjemplar.getInt("establecimiento"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void borrarEjemplar(Integer idej, Equipamiento equipamiento, Integer establecimiento) {
        Connection con; 
        PreparedStatement stmEjemplar= null;
        
        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("delete from ejemplar "
                    + "where equipamiento=? and id_ejemplar=? and establecimiento=?");
            stmEjemplar.setInt(1, equipamiento.getId());
            stmEjemplar.setInt(2, idej);
            stmEjemplar.setInt(3, establecimiento);
            
            con.setAutoCommit(true);
            stmEjemplar.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void modificarEjemplar(Ejemplar e){
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();

        String consulta = "update ejemplar "
                + "set equipamiento=?, id_ejemplar=?, descripcion=?, ano_compra=?, establecimiento=?"
                + "where id_ejemplar=? and equipamiento=? and establecimiento=?";
        try {
            stmEjemplar = con.prepareStatement(consulta);
            stmEjemplar.setInt(1, e.getEquipamiento().getId());
            stmEjemplar.setInt(2, e.getId_ejemplar());
            stmEjemplar.setString(3, e.getDescripcion());
            stmEjemplar.setInt(4, e.getAno_compra());
            stmEjemplar.setInt(5, e.getEstablecimiento());
            stmEjemplar.setInt(6, e.getId_ejemplar());
            stmEjemplar.setInt(7, e.getEquipamiento().getId());
            stmEjemplar.setInt(8, e.getEstablecimiento());

            con.setAutoCommit(true);
            stmEjemplar.executeUpdate();
            con.setAutoCommit(false);
            
            
        } catch (SQLException x) {
            System.out.println(x.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(x.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException x) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
}
