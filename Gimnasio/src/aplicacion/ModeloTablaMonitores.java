package aplicacion;

import aplicacion.Monitor;
import javax.swing.table.*;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaMonitores extends AbstractTableModel{
    private java.util.List<Monitor> monitores;
    
    public ModeloTablaMonitores(){
        this.monitores= new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public int getRowCount(){
        return monitores.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre= "DNI:"; break;
            case 1: nombre= "Nombre"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass (int col){
        Class clase= null;
        
        switch(col){
            case 0: clase= java.lang.String.class; break;
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
                resultado= monitores.get(row).getDni();
                break;
            case 1:
                resultado= monitores.get(row).getNombre();
                break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Monitor> monitores){
        this.monitores= monitores;
        fireTableDataChanged();
    }
    
    public Monitor obtenerMonitor(int i){
        return this.monitores.get(i);
    }
}
