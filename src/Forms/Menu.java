package Forms;
import java.sql.Connection;

public class Menu extends javax.swing.JFrame {
    static Connection conexion;
    
    public Menu(Connection Conectar) {        
        conexion=Conectar;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_atencion_cliente = new javax.swing.JLabel();
        lbl_registro_cita = new javax.swing.JLabel();
        lbl_mante_doctor = new javax.swing.JLabel();
        lbl_mante_cliente = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_atencion_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        lbl_atencion_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_atencion_clienteMouseClicked(evt);
            }
        });

        lbl_registro_cita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        lbl_registro_cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_registro_citaMouseClicked(evt);
            }
        });

        lbl_mante_doctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/3.png"))); // NOI18N
        lbl_mante_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mante_doctorMouseClicked(evt);
            }
        });

        lbl_mante_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/4.png"))); // NOI18N
        lbl_mante_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mante_clienteMouseClicked(evt);
            }
        });

        btn_salir.setText("SALIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_atencion_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_registro_cita))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_mante_doctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_mante_cliente)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_registro_cita)
                    .addComponent(lbl_atencion_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mante_doctor)
                    .addComponent(lbl_mante_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_atencion_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_atencion_clienteMouseClicked
        Atencion_Pacientes ob_ate= new Atencion_Pacientes(conexion);
        ob_ate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_atencion_clienteMouseClicked

    private void lbl_registro_citaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_registro_citaMouseClicked
        Registro_Citas ob_cita= new Registro_Citas(conexion);
        ob_cita.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_registro_citaMouseClicked

    private void lbl_mante_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mante_doctorMouseClicked
        Mante_doc ob_doc= new Mante_doc(conexion);
        ob_doc.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lbl_mante_doctorMouseClicked

    private void lbl_mante_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mante_clienteMouseClicked
        Mante_clien ob_clien=new Mante_clien(conexion);
        ob_clien.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_mante_clienteMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new Menu(conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_atencion_cliente;
    private javax.swing.JLabel lbl_mante_cliente;
    private javax.swing.JLabel lbl_mante_doctor;
    private javax.swing.JLabel lbl_registro_cita;
    // End of variables declaration//GEN-END:variables
}