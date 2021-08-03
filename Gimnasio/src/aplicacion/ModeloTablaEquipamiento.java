/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaEquipamiento extends AbstractTableModel{
    private java.util.List<Equipamiento> equipamientos;
    
    public ModeloTablaEquipamiento(){
        this.equipamientos= new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public int getRowCount(){
        return equipamientos.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre= "ID"; break;
            case 1: nombre= "Modelo"; break;
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
                resultado= equipamientos.get(row).getId();
                break;
            case 1:
                resultado= equipamientos.get(row).getModelo();
                break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Equipamiento> equipamientos){
        this.equipamientos= equipamientos;
        fireTableDataChanged();
    }
    
    public Equipamiento obtenerEquipamiento(int i){
        return this.equipamientos.get(i);
    }
}
