package baseDatos;

import aplicacion.Establecimiento;
import aplicacion.Monitor;
import java.sql.*;
import java.util.Calendar;
import aplicacion.Sesion;

/**
 *
 * @author alumnogreibd
 */
public class DAOMonitores extends AbstractDAO {

    public DAOMonitores(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Monitor> consultarMonitores(String dni_monitor, Integer establecimiento) {
        java.util.List<Monitor> resultado = new java.util.ArrayList<Monitor>();
        Monitor monitorActual;
        Connection con;
        PreparedStatement stmMonitor = null;
        ResultSet rsMonitor;

        con = this.getConexion();

        String consulta = "select dni_monitor, nombre, telefono, email, horario, sueldo, ano_contratacion, establecimiento "
                + "from monitor as m "
                + "where establecimiento = ? and"
                + " dni_monitor like ?";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setInt(1, establecimiento);
            stmMonitor.setString(2, "%" + dni_monitor + "%");
            rsMonitor = stmMonitor.executeQuery();
            while (rsMonitor.next()) {
                monitorActual = new Monitor(rsMonitor.getString("dni_monitor"), rsMonitor.getString("nombre"), rsMonitor.getString("telefono"), rsMonitor.getString("email"), rsMonitor.getString("horario"), rsMonitor.getInt("establecimiento"), rsMonitor.getInt("ano_contratacion"));
                resultado.add(monitorActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Monitor> consultarMonitores(Establecimiento establecimiento) {
        java.util.List<Monitor> resultado = new java.util.ArrayList<Monitor>();
        Monitor monitorActual;
        Connection con;
        PreparedStatement stmMonitor = null;
        ResultSet rsMonitor;

        con = this.getConexion();

        String consulta = "select dni_monitor, nombre, telefono, email, horario, sueldo, ano_contratacion, establecimiento "
                + "from monitor as m "
                + "where establecimiento = ? ";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setInt(1, establecimiento.getId_establecimiento());
            rsMonitor = stmMonitor.executeQuery();
            while (rsMonitor.next()) {
                monitorActual = new Monitor(rsMonitor.getString("dni_monitor"), rsMonitor.getString("nombre"), rsMonitor.getString("telefono"), rsMonitor.getString("email"), rsMonitor.getString("horario"), rsMonitor.getInt("establecimiento"), rsMonitor.getInt("ano_contratacion"));
                resultado.add(monitorActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public Monitor consultarMonitor(String dni_monitor) {
        Monitor resultado = null;
        Connection con;
        PreparedStatement stmMonitor = null;
        ResultSet rsMonitor;

        con = super.getConexion();

        String consulta = "select dni_monitor, nombre, telefono, email, horario, sueldo, ano_contratacion, establecimiento "
                + "from monitor as m "
                + "where dni_monitor like ?";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setString(1, "%" + dni_monitor + "%");
            rsMonitor = stmMonitor.executeQuery();
            if (rsMonitor.next()) {
                resultado = new Monitor(rsMonitor.getString("dni_monitor"), rsMonitor.getString("nombre"), rsMonitor.getString("telefono"), rsMonitor.getString("email"), rsMonitor.getString("horario"), rsMonitor.getInt("establecimiento"), rsMonitor.getInt("ano_contratacion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void insertarMonitor(Monitor m) {
        Connection con;
        PreparedStatement stmMonitor = null;
        con = super.getConexion();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        String consulta = "insert into monitor (dni_monitor, nombre, telefono, email, horario, sueldo, ano_contratacion, establecimiento)"
                + "values (?,?,?,?,?,?,?,?)";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setString(1, m.getDni());
            stmMonitor.setString(2, m.getNombre());
            stmMonitor.setString(3, m.getTelefono());
            stmMonitor.setString(4, m.getEmail());
            stmMonitor.setString(5, m.getHorario());
            stmMonitor.setInt(6, m.getSueldo());
            stmMonitor.setInt(7, year);
            stmMonitor.setInt(8, m.getEstablecimiento());

            con.setAutoCommit(true);
            stmMonitor.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarMonitor(Monitor m) {
        Connection con;
        PreparedStatement stmMonitor = null;

        con = super.getConexion();

        String consulta = "update monitor "
                + "set dni_monitor=?, nombre=?, telefono=?, email=?, horario=?, sueldo=?, ano_contratacion=?, establecimiento=? "
                + "where dni_monitor=?";
        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setString(1, m.getDni());
            stmMonitor.setString(2, m.getNombre());
            stmMonitor.setString(3, m.getTelefono());
            stmMonitor.setString(4, m.getEmail());
            stmMonitor.setString(5, m.getHorario());
            stmMonitor.setInt(6, m.getSueldo());
            stmMonitor.setInt(7, m.getAno_contratacion());
            stmMonitor.setInt(8, m.getEstablecimiento());
            stmMonitor.setString(9, m.getDni());

            con.setAutoCommit(true);
            stmMonitor.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarMonitor(String dni_monitor) {
        Connection con;
        PreparedStatement stmMonitor = null;

        con = super.getConexion();

        String consulta = "delete from monitor where dni_monitor = ?";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setString(1, dni_monitor);

            con.setAutoCommit(true);
            stmMonitor.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    public Monitor validarMonitor(String dni) {
        Monitor resultado = null;
        Connection con;
        PreparedStatement stmMonitor = null;
        ResultSet rsMonitor;

        con = this.getConexion();

        String consulta = "select dni_monitor, nombre, telefono, email, horario, sueldo, ano_contratacion, establecimiento "
                + "from monitor as m "
                + "where dni_monitor like ?";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setString(1, dni);
            rsMonitor = stmMonitor.executeQuery();

            if (rsMonitor.next()) {
                resultado = new Monitor(rsMonitor.getString("dni_monitor"), rsMonitor.getString("nombre"), rsMonitor.getString("telefono"), rsMonitor.getString("email"), rsMonitor.getString("horario"), rsMonitor.getInt("establecimiento"), rsMonitor.getInt("ano_contratacion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public int getNumSesiones(Monitor m) {
        Connection con;
        PreparedStatement stmSesion = null;
        ResultSet rsSesion;
        int sesiones = 0;
        java.util.List<Sesion> resultado = new java.util.ArrayList<Sesion>();
        Sesion sesionActual;

        con = this.getConexion();

        String consulta = "select id_sesion, actividad, dni_monitor, fecha_inicio, plazas, establecimiento "
                + "from sesion "
                + "where dni_monitor like ? ";

        try {
            stmSesion = con.prepareStatement(consulta);
            stmSesion.setString(1, m.getDni());
            rsSesion = stmSesion.executeQuery();

            while (rsSesion.next()) {
                sesionActual = new Sesion(rsSesion.getInt("id_sesion"), rsSesion.getInt("actividad"), rsSesion.getString("dni_monitor"), rsSesion.getString("fecha_inicio"),
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
        sesiones = resultado.size();
        return sesiones;

    }

    public java.util.List<Monitor> consultarPosiblesMonitores(Integer establecimiento, String fecha_inicio, String horario) {
        java.util.List<Monitor> resultado = new java.util.ArrayList<Monitor>();
        Monitor monitorActual;
        Connection con;
        PreparedStatement stmMonitor = null;
        ResultSet rsMonitor;

        con = this.getConexion();

        String consulta = "select m.*"
                + " from monitor as m"
                + "  where establecimiento = ? and"
                + " horario like ? \n"
                + " except\n"
                + " select m.*\n"
                + " from sesion as s, monitor as m"
                + " where s.fecha_inicio = ? and s.dni_monitor = m.dni_monitor";

        try {
            stmMonitor = con.prepareStatement(consulta);
            stmMonitor.setInt(1, establecimiento);
            stmMonitor.setString(2, horario);
            stmMonitor.setString(3, fecha_inicio);
            rsMonitor = stmMonitor.executeQuery();
            while (rsMonitor.next()) {
                monitorActual = new Monitor(rsMonitor.getString("dni_monitor"), rsMonitor.getString("nombre"), rsMonitor.getString("telefono"), rsMonitor.getString("email"), rsMonitor.getString("horario"), rsMonitor.getInt("establecimiento"), rsMonitor.getInt("ano_contratacion"));
                resultado.add(monitorActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMonitor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;

    }

}
