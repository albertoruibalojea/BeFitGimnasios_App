package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Equipamiento {
    private String modelo;
    private Integer id;

    public Equipamiento(int id, String modelo) {
        this.modelo = modelo;
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }
    
    public String getIdString(){
        return this.id.toString();
    }
 
    public void setId(Integer id) {
        this.id = id;
    } 
    
    
}
