package Interfaz;

import aplicacion.Administrador;
import aplicacion.Ejemplar;
import aplicacion.Establecimiento;
import aplicacion.ModeloTablaEstablecimientos;
import aplicacion.Monitor;
import javax.swing.JTable;

/**
 *
 * @author alumnogreibd
 */
public class VBGimnasios extends javax.swing.JDialog {
    
    aplicacion.FachadaAplicacion fa;
    private Integer id;
    private ModeloTablaEstablecimientos mte;
    private VBPrincipal padre;
    private Establecimiento establecimiento;

    /**
     * Creates new form VSUGimnasios
     */
    public VBGimnasios(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        
        this.mte = new ModeloTablaEstablecimientos();
        tablaGyms.setModel(mte);
        if (mte.getRowCount() > 0) {
            tablaGyms.setRowSelectionInterval(0, 0);
        }
        
        textoID.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textoIDBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGyms = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoCiudad = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gesti??n de gimnasios");

        jLabel1.setText("ID:");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaGyms.setModel(new ModeloTablaEstablecimientos());
        tablaGyms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGymsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGyms);

        jLabel2.setText("GESTIONAR DATOS DEL GIMNASIO");

        jLabel3.setText("ID: ");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Ciudad:");

        jLabel6.setText("Tel??fono:");

        jLabel7.setText("Direcci??n:");

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

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoDireccion)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(111, 111, 111))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoIDBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoIDBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnGuardar)
                            .addComponent(btnCerrar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.fa.muestraExcepcion("??Est??s seguro/a de borrarlo?");
        boolean a = this.fa.comprobacionBoss("??BORRAR GIMNASIO?.");
        if (a) {
            borrarEstablecimiento();
        } else {
            this.fa.muestraExcepcion("No puede cerrar el gimnasio.");
        }

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        textoID.setText(null);
        textoNombre.setText(null);
        textoCiudad.setText(null);
        textoDireccion.setText(null);
        textoTelefono.setText(null);
        textoID.setEditable(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarGimnasios();
        
        mte = (ModeloTablaEstablecimientos) tablaGyms.getModel();
        id = mte.obtenerEstablecimiento(tablaGyms.getSelectedRow()).getId_establecimiento();
        
        this.establecimiento = fa.buscarEstablecimiento(id);
        textoID.setText(establecimiento.getId_establecimiento().toString());
        textoNombre.setText(establecimiento.getNombre());
        textoCiudad.setText(establecimiento.getCiudad());
        textoDireccion.setText(establecimiento.getDireccion());
        textoTelefono.setText(establecimiento.getTelefono());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!textoID.getText().isEmpty()) {
            Establecimiento e;
            e = new Establecimiento(Integer.parseInt(textoID.getText()), textoNombre.getText(), textoCiudad.getText(), textoTelefono.getText(), textoDireccion.getText());
            fa.actualizarEstablecimiento(e);
            actualizarTabla();
        } else {
            fa.muestraExcepcion("El ID ha de ser introducido.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaGymsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGymsMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        id = Integer.parseInt(source.getModel().getValueAt(row, 0) + "");
        Establecimiento est = fa.buscarEstablecimiento(id);
        
        textoID.setText(est.getId_establecimiento().toString());
        textoNombre.setText(est.getNombre());
        textoCiudad.setText(est.getCiudad());
        textoTelefono.setText(est.getTelefono());
        textoDireccion.setText(est.getDireccion());

    }//GEN-LAST:event_tablaGymsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGyms;
    private javax.swing.JTextField textoCiudad;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoIDBuscar;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    public void buscarGimnasios() {
        ModeloTablaEstablecimientos mte;
        
        mte = (ModeloTablaEstablecimientos) tablaGyms.getModel();
        if (!textoIDBuscar.getText().isEmpty()) {
            mte.setFilas(fa.obtenerEstablecimientos(Integer.parseInt(textoIDBuscar.getText())));
            
        } else {
            mte.setFilas(fa.obtenerEstablecimientos());
        }
        if (mte.getRowCount() > 0) {
            tablaGyms.setRowSelectionInterval(0, 0);
        }
    }

    //Actualizar la tabla de gimnasios
    public void actualizarTabla() {
        buscarGimnasios();
        this.mte = (ModeloTablaEstablecimientos) tablaGyms.getModel();
        this.id = this.mte.obtenerEstablecimiento(tablaGyms.getSelectedRow()).getId_establecimiento();
        
        this.establecimiento = fa.buscarEstablecimiento(id);
        textoID.setText(establecimiento.getId_establecimiento().toString());
        textoNombre.setText(establecimiento.getNombre());
        textoCiudad.setText(establecimiento.getCiudad());
        textoTelefono.setText(establecimiento.getTelefono());
        textoDireccion.setText(establecimiento.getDireccion());
        
        this.tablaGyms.updateUI();
    }
    
    public void borrarEstablecimiento() {
        if (!textoID.getText().isEmpty()) {
            java.util.List<Monitor> monitores = new java.util.ArrayList<>();
            java.util.List<Ejemplar> ejemplares = new java.util.ArrayList<>();
            
            establecimiento = fa.buscarEstablecimiento(Integer.parseInt(textoID.getText()));
            monitores = fa.obtenerMonitores(establecimiento);
            ejemplares = fa.obtenerEjemplares(establecimiento);
            Administrador adm = fa.obtenerAdministrador(establecimiento);
            
            establecimiento = fa.buscarEstablecimiento(Integer.parseInt(textoID.getText()));
            fa.borrarEstablecimiento(establecimiento, monitores, ejemplares, adm);
            actualizarTabla();
            
        } else {
            fa.muestraExcepcion("Seleccione el establecimiento que quiere cerrar.");
        }
    }
}
