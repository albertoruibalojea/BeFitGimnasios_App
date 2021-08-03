
package aplicacion;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author sofiamartinezparada
 */
public class ModeloTablaEstablecimientos extends AbstractTableModel{
    
    private java.util.List<Establecimiento> establecimientos;
    
    public ModeloTablaEstablecimientos (){
        this.establecimientos = new java.util.ArrayList<>();
    }
    
    
     @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public int getRowCount(){
        return establecimientos.size();
    }
    
     @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre= "ID: "; break;
            case 1: nombre= "Nombre: "; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass (int col){
        Class clase= null;
        
        switch(col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
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
                resultado= establecimientos.get(row).getId_establecimiento();
                break;
            case 1:
                resultado= establecimientos.get(row).getNombre();
                break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Establecimiento> establecimientos){
        this.establecimientos= establecimientos;
        fireTableDataChanged();
    }
    
    public Establecimiento obtenerEstablecimiento(int i){
        return this.establecimientos.get(i);
    }
}
