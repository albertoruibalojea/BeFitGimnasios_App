package aplicacion;

import java.util.Calendar;

/**
 *
 * @author alumnogreibd
 */
public class Ejemplar {
    private Equipamiento equipamiento;
    private Integer id_ejemplar;
    private String descripcion;
    private Integer ano_compra;
    private Integer establecimiento;
    

    public Ejemplar(Equipamiento equipamiento, Integer id_ejemplar, String descripcion, Integer ano_compra, Integer establecimiento) {
        this.equipamiento = equipamiento;
        this.id_ejemplar = id_ejemplar;
        this.descripcion = descripcion;
        this.ano_compra = ano_compra;
        this.establecimiento = establecimiento;
    }
    
    public Ejemplar(Equipamiento equipamiento, String descripcion, Integer establecimiento) {
        this.equipamiento = equipamiento;
        this.descripcion = descripcion;
        Calendar c = Calendar.getInstance();
        Integer year = c.get(Calendar.YEAR);
        this.ano_compra = year;
        this.establecimiento = establecimiento;
    }
    
    public Ejemplar(Equipamiento equipamiento, Integer establecimiento) {
        this.equipamiento = equipamiento;
        this.descripcion = "";
        Calendar c = Calendar.getInstance();
        Integer year = c.get(Calendar.YEAR);
        this.ano_compra = year;
        this.establecimiento = establecimiento;
    }
    
    public Ejemplar(Integer id_ejemplar, String descripcion, Integer ano_compra, Integer establecimiento) {
        this.equipamiento = null;
        this.id_ejemplar = id_ejemplar;
        this.descripcion = descripcion;
        this.ano_compra = ano_compra;
        this.establecimiento = establecimiento;
    }

    public Equipamiento getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(Equipamiento equipamiento) {
        this.equipamiento = equipamiento;
    }

    public Integer getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(Integer id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAno_compra() {
        return ano_compra;
    }

    public void setAno_compra(Integer ano_compra) {
        this.ano_compra = ano_compra;
    }

    public Integer getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Integer establecimiento) {
        this.establecimiento = establecimiento;
    }
    
    
    
    
}
