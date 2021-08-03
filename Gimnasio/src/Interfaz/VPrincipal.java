package Interfaz;

import aplicacion.FachadaAplicacion;

/**
 *
 * @author alumnogreibd
 */
public class VPrincipal extends javax.swing.JFrame {
    aplicacion.FachadaAplicacion fa;
    FachadaGui fgui;
    /**
     * Creates new form VPrincipal
     */
    public VPrincipal(aplicacion.FachadaAplicacion fa, FachadaGui fgui) {
        this.fa=fa;
        this.fgui=fgui;
        initComponents();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BeFit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnEstablecimiento = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEjemplares = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BeFit Gimnasios");
        setBackground(javax.swing.UIManager.getDefaults().getColor("window"));

        BeFit.setFont(new java.awt.Font("eufm10", 2, 24)); // NOI18N
        BeFit.setText("BeFit Gimnasios");
        BeFit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeFitMouseClicked(evt);
            }
        });

        jLabel3.setText("GESTIÓN DEL GIMNASIO");

        jLabel4.setText("Usuarios/as");

        jLabel5.setText("Personal");

        jLabel8.setText("Datos del establecimiento");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setText("OTRAS OPCIONES");

        jLabel10.setText("Sesiones");

        btnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("Ir");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPersonal.setBackground(new java.awt.Color(255, 255, 255));
        btnPersonal.setText("Ir");
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        btnEstablecimiento.setBackground(new java.awt.Color(255, 255, 255));
        btnEstablecimiento.setText("Ir");
        btnEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstablecimientoActionPerformed(evt);
            }
        });

        btnSesiones.setBackground(new java.awt.Color(255, 255, 255));
        btnSesiones.setText("Ir");
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });

        jLabel2.setText("Ejemplares");

        btnEjemplares.setBackground(new java.awt.Color(255, 255, 255));
        btnEjemplares.setText("Ir");
        btnEjemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjemplaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addComponent(BeFit))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPersonal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEstablecimiento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEjemplares))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSesiones))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(BeFit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnUsuarios))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnPersonal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnEstablecimiento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnEjemplares))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnSesiones))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        fgui.iniciaUsuario();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        fgui.iniciaPersonal();
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnEjemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjemplaresActionPerformed
        fgui.iniciaEjemplar();
    }//GEN-LAST:event_btnEjemplaresActionPerformed

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionesActionPerformed
        fgui.iniciaSesiones();
    }//GEN-LAST:event_btnSesionesActionPerformed

    private void btnEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstablecimientoActionPerformed
        fgui.iniciaVEstablecimiento();
    }//GEN-LAST:event_btnEstablecimientoActionPerformed

    private void BeFitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeFitMouseClicked
        fa.muestraExcepcion("Bienvenida a BeFit, " + fa.visualizarAdmin(fa.getEstablecimientoActual().getId_establecimiento()));
    }//GEN-LAST:event_BeFitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeFit;
    private javax.swing.JButton btnEjemplares;
    private javax.swing.JButton btnEstablecimiento;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnSesiones;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}