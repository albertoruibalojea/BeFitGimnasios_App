/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import aplicacion.Equipamiento;
import aplicacion.ModeloTablaEquipamiento;
import javax.swing.JTable;

/**
 *
 * @author alumnogreibd
 */
public class VBEquipamiento extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    private ModeloTablaEquipamiento modEquip;
    private int id;
    private Equipamiento equipamiento;

    /**
     * Creates new form VEquipamiento
     */
    public VBEquipamiento(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();

        this.modEquip = new ModeloTablaEquipamiento();
        tablaEquipamiento.setModel(modEquip);
        if (modEquip.getRowCount() > 0) {
            tablaEquipamiento.setRowSelectionInterval(0, 0);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textoIdBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipamiento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoModelo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textoId1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión del equipamiento");

        jLabel2.setText("ID:");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaEquipamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEquipamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEquipamientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEquipamiento);

        jLabel1.setText("GESTIONAR DATOS DE UN EQUIPAMIENTO");

        jLabel3.setText("Modelo:");

        textoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoModeloActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel7.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoId1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnBorrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoModeloActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        this.buscarEquipamiento();

        this.modEquip = (ModeloTablaEquipamiento) tablaEquipamiento.getModel();
        this.id = this.modEquip.obtenerEquipamiento(tablaEquipamiento.getSelectedRow()).getId();

        this.equipamiento = fa.consultarEquipamiento(id);
        this.setFields(equipamiento);

        btnLimpiar.setEnabled(true);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaEquipamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEquipamientoMouseClicked

        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        this.id = Integer.parseInt(source.getModel().getValueAt(row, 0) + "");

        this.equipamiento = fa.consultarEquipamiento(id);
        this.setFields(equipamiento);
        this.textoId1.setEditable(false);

    }//GEN-LAST:event_tablaEquipamientoMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        this.clearFields();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (this.checkFields()) {
            this.equipamiento = new Equipamiento(Integer.parseInt(textoId1.getText()), textoModelo.getText());

            fa.actualizarEquipamiento(this.equipamiento);

            this.actualizarTabla();
        }
        else{
            fa.muestraExcepcion("Por favor, introduzca un modelo y un identificador para el equipamiento");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        if (this.checkFields()) {


            if (fa.comprobacionBorrarEquipamiento(equipamiento)) {
                fa.borrarEquipamiento(this.equipamiento);
                this.actualizarTabla();
                this.clearFields();

                btnLimpiar.setEnabled(false);
            } else fa.muestraExcepcion("No se puede borrar el equipamiento al tener ejemplares.");
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    public void buscarEquipamiento() {

        this.modEquip = (ModeloTablaEquipamiento) tablaEquipamiento.getModel();

        try {
            if (!textoIdBuscar.getText().isEmpty()) {
                modEquip.setFilas(fa.obtenerEquipamiento(Integer.parseInt(textoId1.getText())));
            } else {
                modEquip.setFilas(fa.obtenerEquipamiento());
            }
        } catch (Exception e) {
            this.fa.muestraExcepcion("Ooops, algo ha salido mal en la búsqueda.");
        }

        if (modEquip.getRowCount() > 0) {
            tablaEquipamiento.setRowSelectionInterval(0, 0);
        }

    }

    //Actualizar la tabla de usuarios
    public void actualizarTabla() {
        buscarEquipamiento();
        this.modEquip = (ModeloTablaEquipamiento) tablaEquipamiento.getModel();
        this.id = this.modEquip.obtenerEquipamiento(tablaEquipamiento.getSelectedRow()).getId();

        this.equipamiento = fa.consultarEquipamiento(this.id);
        this.setFields(this.equipamiento);

        this.tablaEquipamiento.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEquipamiento;
    private javax.swing.JTextField textoId1;
    private javax.swing.JTextField textoIdBuscar;
    private javax.swing.JTextField textoModelo;
    // End of variables declaration//GEN-END:variables

    public void setFields(Equipamiento e) {
        this.textoId1.setText(e.getId().toString());
        this.textoModelo.setText(e.getModelo());
        this.textoId1.setEditable(false);
    }

    public void clearFields() {
        this.textoId1.setText(null);
        this.textoModelo.setText(null);
        this.textoId1.setEditable(true);
    }

    //Comprueba si los campos están vacíos o no
    public boolean checkFields() {
        if (!textoId1.getText().isEmpty() && !textoModelo.getText().isEmpty()) {
            return true;
        }
        return false;
    }
}
