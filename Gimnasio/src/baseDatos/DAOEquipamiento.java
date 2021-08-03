package baseDatos;

import java.sql.*;
import aplicacion.Ejemplar;
import aplicacion.Equipamiento;
import aplicacion.Establecimiento;

/**
 *
 * @author sofiamartinezparada
 */
public class DAOEquipamiento extends AbstractDAO {

    public DAOEquipamiento(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Equipamiento consultarEquipamiento(int id) {
        Equipamiento equipamientoActual = null;
        Connection con;
        PreparedStatement stmEquipamientos = null;
        ResultSet rsEquipamientos = null;

        con = this.getConexion();

        String consulta = "select modelo, id_equipamiento from equipamiento where id_equipamiento = ?";

        try {
            stmEquipamientos = con.prepareStatement(consulta);
            stmEquipamientos.setInt(1, id);
            rsEquipamientos = stmEquipamientos.executeQuery();
            while (rsEquipamientos.next()) {
                equipamientoActual = new Equipamiento(rsEquipamientos.getInt("id_equipamiento"), rsEquipamientos.getString("modelo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamientos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return equipamientoActual;
    }

    public java.util.List<Equipamiento> obtenerEquipamiento(Integer id) {
        java.util.List<Equipamiento> equipamiento = new java.util.ArrayList<>();
        Equipamiento equipamientoActual;
        Connection con;
        PreparedStatement stmEquipamientos = null;
        ResultSet rsEquipamientos = null;

        con = this.getConexion();
        String consulta = null;
        if (id != null) {
            consulta = "select id_equipamiento, modelo from equipamiento where id_equipamiento = ?";
        }
        try {
            stmEquipamientos = con.prepareStatement(consulta);
            stmEquipamientos.setInt(1, id);

            rsEquipamientos = stmEquipamientos.executeQuery();

            while (rsEquipamientos.next()) {
                equipamientoActual = new Equipamiento(rsEquipamientos.getInt("id_equipamiento"), rsEquipamientos.getString("modelo"));

                equipamiento.add(equipamientoActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamientos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return equipamiento;
    }

    public java.util.List<Equipamiento> obtenerEquipamiento() {
        java.util.List<Equipamiento> equipamiento = new java.util.ArrayList<>();
        Equipamiento equipamientoActual;
        Connection con;
        PreparedStatement stmEquipamientos = null;
        ResultSet rsEquipamientos = null;

        con = this.getConexion();
        String consulta = null;
        consulta = "select id_equipamiento, modelo from equipamiento";

        try {
            stmEquipamientos = con.prepareStatement(consulta);

            rsEquipamientos = stmEquipamientos.executeQuery();

            while (rsEquipamientos.next()) {
                equipamientoActual = new Equipamiento(rsEquipamientos.getInt("id_equipamiento"), rsEquipamientos.getString("modelo"));

                equipamiento.add(equipamientoActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamientos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return equipamiento;
    }

    public void insertarEquipamiento(Equipamiento equipamiento) {
        Connection con;
        PreparedStatement stmEquipamiento = null;

        con = super.getConexion();

        try {
            stmEquipamiento = con.prepareStatement("insert into equipamiento(modelo, id_equipamiento) "
                    + "values (?,?)");
            stmEquipamiento.setString(1, equipamiento.getModelo());
            stmEquipamiento.setInt(2, equipamiento.getId());
            
            con.setAutoCommit(true);
            stmEquipamiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarEquipamiento(Equipamiento equipamiento) {
        Connection con;
        PreparedStatement stmEquipamiento = null;

        con = super.getConexion();

        try {
            stmEquipamiento = con.prepareStatement("update equipamiento "
                    + "set modelo=?, "
                    + "    id_equipamiento=? "
                    + "where id_equipamiento=?");

            stmEquipamiento.setString(1, equipamiento.getModelo());    
            stmEquipamiento.setInt(2, equipamiento.getId());
            stmEquipamiento.setInt(3, equipamiento.getId());
            
            con.setAutoCommit(true);
            stmEquipamiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarEquipamiento(Equipamiento equipamiento) {
        Connection con;
        PreparedStatement stmEquipamiento = null;
        String consulta="";

        con = super.getConexion();

        try {         
            consulta ="delete from equipamiento where id_equipamiento=?";
            stmEquipamiento = con.prepareStatement(consulta);
            stmEquipamiento.setInt(1, equipamiento.getId());
            
            con.setAutoCommit(true);
            stmEquipamiento.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public boolean comprobarBorrado(Equipamiento eq){
        java.util.List<Equipamiento> equipamiento = new java.util.ArrayList<>();
        Equipamiento equipamientoActual;
        Connection con;
        PreparedStatement stmEquipamientos = null;
        ResultSet rsEquipamientos = null;

        con = this.getConexion();
        String consulta = null;
               consulta = "select j.id_ejemplar "
                        + "from equipamiento as e join ejemplar as j"
                        +   "on e.id_equipamiento = j.equipamiento"
                        + "where e.id_equipamiento = ?";

        try {
            stmEquipamientos = con.prepareStatement(consulta);
            stmEquipamientos.setInt(1, eq.getId());

            rsEquipamientos = stmEquipamientos.executeQuery();

            while (rsEquipamientos.next()) {
                equipamientoActual = new Equipamiento(rsEquipamientos.getInt("id_equipamiento"), rsEquipamientos.getString("modelo"));

                equipamiento.add(equipamientoActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamientos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        if(equipamiento.isEmpty()) return true;
        else return false;
    }

    public void crearEquipamientoEjemplares(Equipamiento equipamiento, int ejemplares, Establecimiento est) {
        Connection con;
        PreparedStatement stmEquipamiento = null;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();

        try {
            stmEquipamiento = con.prepareStatement("insert into equipamiento(modelo, id_equipamiento) "
                    + "values (?,?)");
            stmEquipamiento.setString(1, equipamiento.getModelo());
            stmEquipamiento.setInt(2, equipamiento.getId());
            
            con.setAutoCommit(true);
            stmEquipamiento.executeUpdate();
            con.setAutoCommit(false);

            for (int i = 0; i < ejemplares; i++) {
                Ejemplar e = new Ejemplar(equipamiento, est.getId_establecimiento());

                stmEjemplar = con.prepareStatement("insert into ejemplar(equipamiento, descripcion, ano_compra, establecimiento) "
                        + "values (?,?,?,?)");

                stmEjemplar.setInt(1, equipamiento.getId());
                stmEjemplar.setString(2, e.getDescripcion());
                stmEjemplar.setInt(3, e.getAno_compra());
                stmEjemplar.setInt(4, e.getEstablecimiento());
                stmEjemplar.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEquipamiento.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}
