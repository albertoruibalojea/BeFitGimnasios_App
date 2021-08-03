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
public class ModeloTablaUsuarios extends AbstractTableModel {

    private java.util.List<Usuario> usuarios;

    public ModeloTablaUsuarios() {
        this.usuarios = new java.util.ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void nuevoUsuario(Usuario u){
        this.usuarios.add(u);
        fireTableRowsInserted(this.usuarios.size()-1, this.usuarios.size()-1);
    }

    public void borrarUsuario(int indice){
        this.usuarios.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Usuario obtenerUsuario(int i){
        return this.usuarios.get(i);
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return usuarios.size();
    }

    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "DNI";
                break;
            case 1:
                nombre = "Nombre";
                break;
        }

        return nombre;
    }

    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
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
                resultado = usuarios.get(row).getDni_usuario();
                break;
            case 1:
                resultado = usuarios.get(row).getNombre();
                break;
        }

        return resultado;
    }

    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            case 0:
                usuarios.get(row).getDni_usuario();
                break;
            case 1:
                usuarios.get(row).setNombre((String) v);
                break;
        }
    }
    
    public void setFilas(java.util.List<Usuario> usuarios){
        this.usuarios=usuarios;
        fireTableDataChanged();
    }

}
