package Forms;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro_Citas extends javax.swing.JFrame {
    Date fecha,fecha1,fecha2;
    SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    public Registro_Citas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendarBeanInfo1 = new com.toedter.calendar.JCalendarBeanInfo();
        jCalendarBeanInfo2 = new com.toedter.calendar.JCalendarBeanInfo();
        dateUtil1 = new com.toedter.calendar.DateUtil();
        dateChooserPanelBeanInfo1 = new com.toedter.calendar.demo.DateChooserPanelBeanInfo();
        birthdayEvaluator1 = new com.toedter.calendar.demo.BirthdayEvaluator();
        jMonthChooserBeanInfo1 = new com.toedter.calendar.JMonthChooserBeanInfo();
        testDateEvaluator1 = new com.toedter.calendar.demo.TestDateEvaluator();
        minMaxDateEvaluator1 = new com.toedter.calendar.MinMaxDateEvaluator();
        localeEditor1 = new com.toedter.components.LocaleEditor();
        jCalendarTheme1 = new com.toedter.plaf.JCalendarTheme();
        birthdayEvaluator2 = new com.toedter.calendar.demo.BirthdayEvaluator();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        Btn_agendar_cita = new javax.swing.JButton();
        J_cho_cita = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Jcb_doctor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Jcb_buscar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Btn_agendar_cita.setText("Agendar Cita");
        Btn_agendar_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agendar_citaActionPerformed(evt);
            }
        });

        J_cho_cita.setDateFormatString("yyyy/MM/dd HH:mm");

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Doctor:");

        Jcb_doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Buscar por:");

        Jcb_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Codigo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Btn_agendar_cita))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(Jcb_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(J_cho_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Jcb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Jcb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcb_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addComponent(J_cho_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(Btn_agendar_cita)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_agendar_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agendar_citaActionPerformed
        //fecha=jCalendar1.getDate();
        //fecha1=Jsd_fecha.getDate();
        fecha2=J_cho_cita.getDate();
        //String prueba1=objSDF.format(fecha);
        //String prueba2=objSDF.format(fecha1);
        String prueba3=objSDF.format(fecha2);
        //System.out.println("fecha " +prueba1);        
        //System.out.println("fecha 1 " +prueba2);        
        System.out.println("fecha 2 " +prueba3);       
    }//GEN-LAST:event_Btn_agendar_citaActionPerformed


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
            java.util.logging.Logger.getLogger(Registro_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_agendar_cita;
    private com.toedter.calendar.JDateChooser J_cho_cita;
    private javax.swing.JComboBox<String> Jcb_buscar;
    private javax.swing.JComboBox<String> Jcb_doctor;
    private com.toedter.calendar.demo.BirthdayEvaluator birthdayEvaluator1;
    private com.toedter.calendar.demo.BirthdayEvaluator birthdayEvaluator2;
    private com.toedter.calendar.demo.DateChooserPanelBeanInfo dateChooserPanelBeanInfo1;
    private com.toedter.calendar.DateUtil dateUtil1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendarBeanInfo jCalendarBeanInfo1;
    private com.toedter.calendar.JCalendarBeanInfo jCalendarBeanInfo2;
    private com.toedter.plaf.JCalendarTheme jCalendarTheme1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.components.LocaleEditor localeEditor1;
    private com.toedter.calendar.MinMaxDateEvaluator minMaxDateEvaluator1;
    private com.toedter.calendar.demo.TestDateEvaluator testDateEvaluator1;
    // End of variables declaration//GEN-END:variables
}
