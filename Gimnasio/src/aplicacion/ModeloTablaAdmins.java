/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaAdmins extends AbstractTableModel {
    
    private java.util.List<Administrador> admins;

    public ModeloTablaAdmins() {
        this.admins = new java.util.ArrayList<>();
    }
    
    public List<Administrador> getAdmins() {
        return this.admins;
    }

    public void setAdmins(List<Administrador> admins) {
        this.admins = admins;
    }
    
    public void nuevoAdmin(Administrador a){
        this.admins.add(a);
        fireTableRowsInserted(this.admins.size()-1, this.admins.size()-1);
    }

    public void borrarAdmin(int indice){
        this.admins.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Administrador obtenerAdmin(int i){
        return this.admins.get(i);
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return admins.size();
    }

    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Establecimiento";
                break;
            case 1:
                nombre = "DNI";
                break;
        }

        return nombre;
    }

    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.Integer.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
        }

        return clase;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = admins.get(row).getEstablecimiento();
                break;
            case 1:
                resultado = admins.get(row).getDni();
                break;
        }

        return resultado;
    }
    
    public void setFilas(java.util.List<Administrador> admins){
        this.admins=admins;
        fireTableDataChanged();
    }
    
    
    
}
