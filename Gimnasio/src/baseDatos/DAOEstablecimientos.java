package baseDatos;

import aplicacion.Administrador;
import aplicacion.Ejemplar;
import aplicacion.Establecimiento;
import aplicacion.Monitor;
import java.sql.*;

/**
 *
 * @author alumnogreibd
 */
public class DAOEstablecimientos extends AbstractDAO {

    public DAOEstablecimientos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Establecimiento buscarEstablecimiento(int id_establecimiento) {
        Establecimiento resultado = null;
        Connection con;
        PreparedStatement stmEstablecimiento = null;
        ResultSet rsEstablecimiento;

        con = this.getConexion();

        String consulta = "select id_establecimiento, nombre, ciudad, telefono, direccion from establecimiento where id_establecimiento = ?";

        try {
            stmEstablecimiento = con.prepareStatement(consulta);
            stmEstablecimiento.setInt(1, id_establecimiento);

            rsEstablecimiento = stmEstablecimiento.executeQuery();

            if (rsEstablecimiento.next()) {
                resultado = new Establecimiento(rsEstablecimiento.getInt("id_establecimiento"), rsEstablecimiento.getString("nombre"), rsEstablecimiento.getString("ciudad"), rsEstablecimiento.getString("telefono"), rsEstablecimiento.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Establecimiento> consultarEstablecimientos(Integer id) {
        java.util.List<Establecimiento> resultado = new java.util.ArrayList<Establecimiento>();
        Establecimiento establecimientoActual;
        Connection con;
        PreparedStatement stmEstablecimiento = null;
        ResultSet rsEstablecimiento;

        con = this.getConexion();

        String consulta = "select id_establecimiento, nombre, ciudad, telefono, direccion "
                + "from establecimiento as e "
                + "where id_establecimiento = ? ";

        try {
            stmEstablecimiento = con.prepareStatement(consulta);
            stmEstablecimiento.setInt(1, id);
            rsEstablecimiento = stmEstablecimiento.executeQuery();

            while (rsEstablecimiento.next()) {
                establecimientoActual = new Establecimiento(rsEstablecimiento.getInt("id_establecimiento"), rsEstablecimiento.getString("nombre"), rsEstablecimiento.getString("ciudad"), rsEstablecimiento.getString("telefono"), rsEstablecimiento.getString("direccion"));
                resultado.add(establecimientoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Establecimiento> consultarEstablecimientos() {
        java.util.List<Establecimiento> resultado = new java.util.ArrayList<Establecimiento>();
        Establecimiento establecimientoActual;
        Connection con;
        PreparedStatement stmEstablecimiento = null;
        ResultSet rsEstablecimiento;

        con = this.getConexion();

        String consulta = "select id_establecimiento, nombre, ciudad, telefono, direccion "
                + "from establecimiento as e ";

        try {
            stmEstablecimiento = con.prepareStatement(consulta);
            rsEstablecimiento = stmEstablecimiento.executeQuery();

            while (rsEstablecimiento.next()) {
                establecimientoActual = new Establecimiento(rsEstablecimiento.getInt("id_establecimiento"), rsEstablecimiento.getString("nombre"), rsEstablecimiento.getString("ciudad"), rsEstablecimiento.getString("telefono"), rsEstablecimiento.getString("direccion"));
                resultado.add(establecimientoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void insertarEstablecimiento(Establecimiento s) {
        Connection con;
        PreparedStatement stmEstablecimiento = null;
        String dni = null;
        con = super.getConexion();

        String consulta = "insert into establecimiento ( id_establecimiento, nombre, ciudad, telefono, direccion)"
                + "values (?,?,?,?,?)";

        try {
            stmEstablecimiento = con.prepareStatement(consulta);
            stmEstablecimiento.setInt(1, s.getId_establecimiento());
            stmEstablecimiento.setString(2, s.getNombre());
            stmEstablecimiento.setString(3, s.getCiudad());
            stmEstablecimiento.setString(4, s.getTelefono());
            stmEstablecimiento.setString(5, s.getDireccion());

            con.setAutoCommit(true);
            stmEstablecimiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarEstablecimiento(Establecimiento s) {
        Connection con;
        PreparedStatement stmEstablecimiento = null;

        con = super.getConexion();

        String consulta = "update establecimiento "
                + "set id_establecimiento=?, nombre=?, ciudad=?, telefono=?, direccion=?"
                + "where id_establecimiento=?";
        try {
            stmEstablecimiento = con.prepareStatement(consulta);
            stmEstablecimiento.setInt(1, s.getId_establecimiento());
            stmEstablecimiento.setString(2, s.getNombre());
            stmEstablecimiento.setString(3, s.getCiudad());
            stmEstablecimiento.setString(4, s.getTelefono());
            stmEstablecimiento.setString(5, s.getDireccion());
            stmEstablecimiento.setInt(6, s.getId_establecimiento());

            con.setAutoCommit(true);
            stmEstablecimiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarEstablecimiento(Establecimiento est, java.util.List<Monitor> monitores, java.util.List<Ejemplar> ejemplares, Administrador adm) {
        Connection con;
        PreparedStatement stmEstablecimiento = null;
        PreparedStatement stmMonitor = null;
        PreparedStatement stmEjemplar = null;
        PreparedStatement stmAdministrador = null;

        con = super.getConexion();

        String consulta1 = "delete from monitor where dni_monitor = ?";
        String consulta2 = "delete from ejemplar where id_ejemplar = ? and establecimiento = ?";
        String consulta3 = "delete from administrador where establecimiento = ?";
        String consulta4 = "delete from establecimiento "
                + "where id_establecimiento = ? ";

        try {
            if (!monitores.isEmpty()) {
                for (int i = 0; i < monitores.size(); i++) {
                    Monitor m = monitores.get(i);
                    stmMonitor = con.prepareStatement(consulta1);
                    stmMonitor.setString(1, m.getDni());

                    con.setAutoCommit(true);
                    stmMonitor.executeUpdate();
                    con.setAutoCommit(false);

                }
            }
            if (!ejemplares.isEmpty()) {
                for (int i = 0; i < ejemplares.size(); i++) {
                    Ejemplar m = ejemplares.get(i);
                    stmEjemplar = con.prepareStatement(consulta2);
                    stmEjemplar.setInt(1, m.getId_ejemplar());
                    stmEjemplar.setInt(2, m.getEstablecimiento());
                    con.setAutoCommit(true);
                    stmEjemplar.executeUpdate();
                    con.setAutoCommit(false);
                }
            }
            stmAdministrador = con.prepareStatement(consulta3);
            stmAdministrador.setInt(1, adm.getEstablecimiento());
            stmEstablecimiento = con.prepareStatement(consulta4);
            stmEstablecimiento.setInt(1, est.getId_establecimiento());
            con.setAutoCommit(false);
            stmEstablecimiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if(!monitores.isEmpty()) {stmMonitor.close();}
                if(!ejemplares.isEmpty()) {stmEjemplar.close();}
                stmAdministrador.close();
                stmEstablecimiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
