package Forms;

import Clases.Cita;
import Clases.Doctor;
import Clases.historiaClinica;
import java.sql.Connection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import java.sql.Date;

public class Atencion_Pacientes extends javax.swing.JFrame {
    //Atributos
    
    Doctor obdoc = new Doctor();
    static Connection conexion;
    static String datosDoctor[];
    static ArrayList<Cita> array_cita = new ArrayList<Cita>();
    static ArrayList<historiaClinica> array_historiaClinica = new ArrayList<historiaClinica>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/YYYY");
    String titulos[] = {"Nro de cita", "Dni Paciente", "Fecha y hora"};
    DefaultTableModel tabla = new DefaultTableModel(null, titulos);
    //Constructor
    public Atencion_Pacientes(String[] array, Connection conectar, ArrayList<Cita> array_pasado, ArrayList<historiaClinica> array_pasadoHC) {
        Atencion_Pacientes.datosDoctor = array;
        conexion = conectar;
        initComponents();
        array_cita = array_pasado;
        array_historiaClinica = array_pasadoHC;             
        mostrar();
    }
    private void entrarHistorial() throws ParseException {
        int seleccion = Jtable_selec_cita.getSelectedRow();
        String dniCliente = String.valueOf(Jtable_selec_cita.getValueAt(seleccion, 1));
        Date fechaString = sdf.parse(String.valueOf(Jtable_selec_cita.getValueAt(seleccion, 2)));
        historiaClinicaForm obhistoria = new historiaClinicaForm(conexion, datosDoctor[0], dniCliente, fechaString, array_historiaClinica);
        obhistoria.setVisible(true);
        this.dispose();
    }
    //MOSTRAR EN LA TABLA 
    private void mostrar()
    {   tabla.setRowCount(0);
        Jtable_selec_cita.setModel(obdoc.llenarTabla(array_cita, tabla,datosDoctor[0]));
    }
    //Agregar el metodo guardar arraylist clientes
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ate_dni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_selec_cita = new javax.swing.JTable();
        jdate_chooser = new com.toedter.calendar.JDateChooser();
        btn_mostrarCita = new javax.swing.JButton();
        btn_historial = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jdc_fechaHoraCita = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Seleccionar fecha");

        jLabel2.setText("DNI:");

        txt_ate_dni.setEditable(false);

        Jtable_selec_cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable_selec_citaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtable_selec_cita);

        btn_mostrarCita.setText("Mostrar Citas");
        btn_mostrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarCitaActionPerformed(evt);
            }
        });

        btn_historial.setText("Entrar Historial Clinico");
        btn_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historialActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha y Hora:");

        jdc_fechaHoraCita.setDateFormatString("dd/MM/yyyy HH:mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btn_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdate_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(btn_mostrarCita))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ate_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jdc_fechaHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jdate_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_mostrarCita))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ate_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jdc_fechaHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addComponent(btn_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mostrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarCitaActionPerformed
        
        if (jdate_chooser.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione una Fecha", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                //extraigo la fecha 
                String date =sdf1.format(jdate_chooser.getDate());
                tabla.setRowCount(0);                
                Jtable_selec_cita.setModel(obdoc.Busqueda_Atencion_Citas(array_cita,date, tabla));                                
            } catch (ParseException ex) {
                Logger.getLogger(Atencion_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_mostrarCitaActionPerformed

    private void Jtable_selec_citaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtable_selec_citaMouseClicked
        int seleccion = Jtable_selec_cita.getSelectedRow();
        txt_ate_dni.setText(String.valueOf(Jtable_selec_cita.getValueAt(seleccion, 1)));
        Date fechaCita;        
        try {
            fechaCita = sdf.parse(String.valueOf(Jtable_selec_cita.getValueAt(seleccion, 2)));
            jdc_fechaHoraCita.setDate(fechaCita);
        } catch (ParseException ex) {
            Logger.getLogger(Atencion_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jtable_selec_citaMouseClicked

    private void btn_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_historialActionPerformed
        try {
            entrarHistorial();
        } catch (ParseException ex) {
            Logger.getLogger(Atencion_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_historialActionPerformed

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
            java.util.logging.Logger.getLogger(Atencion_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencion_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencion_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencion_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencion_Pacientes(datosDoctor, conexion, array_cita, array_historiaClinica).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_selec_cita;
    private javax.swing.JButton btn_historial;
    private javax.swing.JButton btn_mostrarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_chooser;
    private com.toedter.calendar.JDateChooser jdc_fechaHoraCita;
    private javax.swing.JTextField txt_ate_dni;
    // End of variables declaration//GEN-END:variables
}
