package aplicacion;


import javax.swing.table.AbstractTableModel;
/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaEjemplares extends AbstractTableModel{
    private java.util.List<Ejemplar> ejemplares;
    
    public ModeloTablaEjemplares(){
        this.ejemplares= new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public int getRowCount(){
        return ejemplares.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre= "";
        
        switch(col){
            case 0:
                nombre= "Modelo:";
                break;
            case 1:
                nombre= "Id:";
                break;  
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass (int col){
        Class clase= null;
        
        switch(col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Integer.class; break;
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;
        
        switch(col){
            case 0:
                resultado= ejemplares.get(row).getEquipamiento().getModelo();
                break;
            case 1:
                resultado= ejemplares.get(row).getId_ejemplar();
                break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Ejemplar> ejemplares){
        this.ejemplares= ejemplares;
        fireTableDataChanged();
    }
    
    public Ejemplar obtenerEjemplar(int i){
        return this.ejemplares.get(i);
    }
}
