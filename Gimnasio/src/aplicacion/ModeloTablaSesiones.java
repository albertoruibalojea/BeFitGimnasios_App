/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaSesiones extends AbstractTableModel {

    private java.util.List<Sesion> sesiones;

    public ModeloTablaSesiones() {
        this.sesiones = new ArrayList<Sesion>();
    }

    public int getRowCount() {
        return sesiones.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "ID Sesion";
                break;
            case 1:
                nombre = "ID Actividad";
                break;
            case 2:
                nombre = "DNI Monitor";
                break;
            case 3:
                nombre = "Fecha inicio";
                break;
            case 4:
                nombre = "Num plazas";
                break;
        }
        return nombre;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;

        switch (columnIndex) {
            case 0:
                resultado = sesiones.get(rowIndex).getIdSesion();
                break;
            case 1:
                resultado = sesiones.get(rowIndex).getIdActividad();
                break;
            case 2:
                resultado = sesiones.get(rowIndex).getDniMonitor();
                break;
            case 3:
                resultado = sesiones.get(rowIndex).getFecha_inicio();
                break;
            case 4:
                resultado = sesiones.get(rowIndex).getPlazas();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Sesion> sesiones) {
        this.sesiones = sesiones;
        fireTableDataChanged();
    }

    public Sesion obtenerSesion(int i) {
        return this.sesiones.get(i);
    }

    public List<Sesion> obtenerSesiones() {
        return this.sesiones;
    }
}
