package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Usuario {
    private String dni_usuario;
    private String nombre;
    private String email;
    private String telefono;
    private boolean socio;

    public Usuario(String dni_usuario, String nombre, String email, String telefono, boolean socio) {
        this.dni_usuario = dni_usuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.socio = socio;
    }

    public String getDni_usuario() {
        return dni_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isSocio() {
        return socio;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }
    
    
    
}
