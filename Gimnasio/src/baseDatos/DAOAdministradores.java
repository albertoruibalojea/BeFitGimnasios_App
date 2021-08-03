package baseDatos;

import aplicacion.Administrador;
import aplicacion.Establecimiento;
import java.sql.*;

/**
 *
 * @author sofiamartinezparada
 */
public class DAOAdministradores extends AbstractDAO {

    public DAOAdministradores(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Administrador validarAdministrador(String dni_admin, String contrasena) {
        Administrador resultado = null;
        Connection con;
        PreparedStatement stmAdministrador = null;
        ResultSet rsAdministrador;

        con = this.getConexion();

        String consulta = "select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento from administrador where dni_admin = ? and contrasena = ? ";
        try {
            stmAdministrador = con.prepareStatement(consulta);
            stmAdministrador.setString(1, dni_admin);
            stmAdministrador.setString(2, contrasena);

            rsAdministrador = stmAdministrador.executeQuery();
            
            if (rsAdministrador.next()) {
                resultado = new Administrador(rsAdministrador.getString("contrasena"), rsAdministrador.getString("dni_admin"),
                        rsAdministrador.getString("nombre"), rsAdministrador.getString("telefono"),
                        rsAdministrador.getString("email"), 
                        rsAdministrador.getInt("establecimiento"), rsAdministrador.getInt("ano_contratacion"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdministrador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public Administrador validarAdministrador(String dni_admin) {
        Administrador resultado = null;
        Connection con;
        PreparedStatement stmAdministrador = null;
        ResultSet rsAdministrador;

        con = this.getConexion();

        String consulta = "select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento from administrador where dni_admin = ? ";
        try {
            stmAdministrador = con.prepareStatement(consulta);
            stmAdministrador.setString(1, dni_admin);

            rsAdministrador = stmAdministrador.executeQuery();
            if (rsAdministrador.next()) {
                resultado = new Administrador(rsAdministrador.getString("contrasena"), rsAdministrador.getString("dni_admin"),
                        rsAdministrador.getString("nombre"), rsAdministrador.getString("telefono"),
                        rsAdministrador.getString("email"), 
                        rsAdministrador.getInt("establecimiento"), rsAdministrador.getInt("ano_contratacion"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdministrador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public Administrador validarSuperUser(String dni_admin, String contrasena) {
        Administrador resultado = null;
        Connection con;
        PreparedStatement stmAdministrador = null;
        ResultSet rsAdministrador;

        con = this.getConexion();

        String consulta = "select dni_admin, contrasena, nombre, telefono, email, horario, sueldo, ano_contratacion, superuser from administrador where dni_admin = ? and contrasena = ?";
        try {
            stmAdministrador = con.prepareStatement(consulta);
            stmAdministrador.setString(1, dni_admin);
            stmAdministrador.setString(2, contrasena);

            rsAdministrador = stmAdministrador.executeQuery();
            if (rsAdministrador.next()) {
                resultado = new Administrador(rsAdministrador.getString("contrasena"), rsAdministrador.getString("dni_admin"),
                        rsAdministrador.getString("nombre"), rsAdministrador.getString("telefono"),
                        rsAdministrador.getString("email"), 
                        rsAdministrador.getInt("establecimiento"), rsAdministrador.getInt("ano_contratacion"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdministrador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Administrador> obtenerAdmins(Integer establecimiento, String dni) {
        java.util.List<Administrador> resultado = new java.util.ArrayList<>();
        Administrador adminActual;
        Connection con;
        PreparedStatement stmAdmins = null;
        ResultSet rsAdmins;

        con = this.getConexion();

        String consulta = "select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento "
                + "from administrador as a "
                + "where dni_admin like ? and establecimiento like ?";

        try {
            stmAdmins = con.prepareStatement(consulta);
            stmAdmins.setString(1, "%" + dni + "%");
            stmAdmins.setInt(2, establecimiento);

            rsAdmins = stmAdmins.executeQuery();

            while (rsAdmins.next()) {
                adminActual = new Administrador(rsAdmins.getString("contrasena"), rsAdmins.getString("dni_admin"),
                        rsAdmins.getString("nombre"), rsAdmins.getString("telefono"),
                        rsAdmins.getString("email"), rsAdmins.getInt("establecimiento"),
                        rsAdmins.getInt("ano_contratacion"));

                resultado.add(adminActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmins.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public Administrador obtenerAdministrador(Establecimiento est){
        Administrador adminActual = null;
        Connection con;
        PreparedStatement stmAdmins = null;
        ResultSet rsAdmins;

        con = this.getConexion();

        String consulta = "select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento "
                + "from administrador as a "
                + "where establecimiento = ?";

        try {
            stmAdmins = con.prepareStatement(consulta);
            stmAdmins.setInt(1, est.getId_establecimiento());

            rsAdmins = stmAdmins.executeQuery();

            if (rsAdmins.next()) {
                adminActual = new Administrador(rsAdmins.getString("contrasena"), rsAdmins.getString("dni_admin"),
                        rsAdmins.getString("nombre"), rsAdmins.getString("telefono"),
                        rsAdmins.getString("email"), rsAdmins.getInt("establecimiento"),
                        rsAdmins.getInt("ano_contratacion"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmins.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return adminActual;
    }
    
    public java.util.List<Administrador> obtenerAdmins() {
        java.util.List<Administrador> admins = new java.util.ArrayList<>();
        Administrador adminActual;
        Connection con;
        PreparedStatement stmAdmins = null;
        ResultSet rsAdmins = null;

        con = this.getConexion();
        String consulta = null;
        consulta = "select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento "
                    + "from administrador as a ";

        try {
            stmAdmins = con.prepareStatement(consulta);

            rsAdmins = stmAdmins.executeQuery();

            while (rsAdmins.next()) {
                adminActual = new Administrador(rsAdmins.getString("contrasena"), rsAdmins.getString("dni_admin"),
                        rsAdmins.getString("nombre"), rsAdmins.getString("telefono"),
                        rsAdmins.getString("email"), rsAdmins.getInt("establecimiento"),
                        rsAdmins.getInt("ano_contratacion"));

                admins.add(adminActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmins.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return admins;
    }
    
    public Administrador visualizarAdmin(String dni) {
        Administrador resultado=null;
        Connection con;
        PreparedStatement stmAdmin = null;
        ResultSet rsAdmin= null;
        
        con= super.getConexion();
        
        try{
            stmAdmin= con.prepareStatement("select dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento "
                + "from administrador as a "
                + "where dni_admin = ? ");
            stmAdmin.setString(1, dni);
            rsAdmin= stmAdmin.executeQuery();
            
            if(rsAdmin.next()){
                resultado= new Administrador(rsAdmin.getString("contrasena"), rsAdmin.getString("dni_admin"),
                        rsAdmin.getString("nombre"), rsAdmin.getString("telefono"),
                        rsAdmin.getString("email"), rsAdmin.getInt("establecimiento"),
                        rsAdmin.getInt("ano_contratacion"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmAdmin.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public String visualizarAdmin(Integer est) {
        Administrador resultado=null;
        Connection con;
        PreparedStatement stmAdmin = null;
        ResultSet rsAdmin= null;
        
        con= super.getConexion();
        
        try{
            stmAdmin= con.prepareStatement("select a.contrasena, a.dni_admin, a.nombre, a.telefono, a.email, a.establecimiento, a.ano_contratacion " +
            "from administrador as a join establecimiento as e on a.establecimiento = e.id_establecimiento " +
            " and a.establecimiento = ? ");
            stmAdmin.setInt(1, est);
            rsAdmin= stmAdmin.executeQuery();
            
            if(rsAdmin.next()){
                resultado= new Administrador(rsAdmin.getString("contrasena"), rsAdmin.getString("dni_admin"),
                        rsAdmin.getString("nombre"), rsAdmin.getString("telefono"),
                        rsAdmin.getString("email"), rsAdmin.getInt("establecimiento"),
                        rsAdmin.getInt("ano_contratacion"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{
                stmAdmin.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado.getNombre();
    }
    
    public void insertarAdmin(Administrador admin) {
        Connection con;
        PreparedStatement stmAdmin = null;

        con = super.getConexion();

        try {
            stmAdmin = con.prepareStatement("insert into administrador(dni_admin, contrasena, nombre, telefono, email, sueldo, ano_contratacion, establecimiento) "
                    + "values (?,?,?,?,?,?,?,?)");
            stmAdmin.setString(1, admin.getDni());
            stmAdmin.setString(2, admin.getContrasena());
            stmAdmin.setString(3, admin.getNombre());
            stmAdmin.setString(4, admin.getTelefono());
            stmAdmin.setString(5, admin.getEmail());
            stmAdmin.setInt(6, admin.getSueldo());
            stmAdmin.setInt(7, admin.getAno_contratacion());
            stmAdmin.setInt(8, admin.getEstablecimiento());
            
            //synchronized(this){
                //Para evitar que se introduzca más de un admin
                Establecimiento est = new Establecimiento(admin.getEstablecimiento(), null, null, null, null);
                if(this.obtenerAdministrador(est) == null){

                    con.setAutoCommit(true);
                    stmAdmin.executeUpdate();
                    con.setAutoCommit(false);
                } else this.getFachadaAplicacion().muestraExcepcion("Ya existe un/a administrador/a.");
            //}

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmin.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarAdmin(Administrador admin) {
        Connection con;
        PreparedStatement stmAdmin = null;

        con = super.getConexion();

        try {
            stmAdmin = con.prepareStatement("update administrador "
                    + "set dni_admin=?, "
                    + "    contrasena=?, "
                    + "    nombre=?, "
                    + "    telefono=?, "
                    + "    email=?, "
                    + " establecimiento = ? "
                    + "where dni_admin=?");
            
            stmAdmin.setString(1, admin.getDni());
            stmAdmin.setString(2, admin.getContrasena());
            stmAdmin.setString(3, admin.getNombre());
            stmAdmin.setString(4, admin.getTelefono());
            stmAdmin.setString(5, admin.getEmail());
            stmAdmin.setInt(6, admin.getEstablecimiento());
            
            con.setAutoCommit(true);
            stmAdmin.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmin.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void borrarAdmin(Administrador admin) {
        Connection con;
        PreparedStatement stmAdmin = null;

        con = super.getConexion();

        try {
            stmAdmin = con.prepareStatement("delete from administrador "
                    + "where dni_admin=?");
            stmAdmin.setString(1, admin.getDni());
            
            con.setAutoCommit(true);
            stmAdmin.executeUpdate();
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAdmin.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
}
