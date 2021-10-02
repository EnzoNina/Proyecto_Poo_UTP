/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
//Importaciones
import java.sql.Connection;
import Clases.*;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author msi
 */
public final class PreguntandoUsuario extends javax.swing.JFrame {
    //objetos de jframe
     Persona objpersona;
     Login objlogin;
     
    //DECLARANDO OBJETOS y datos para conectarme con la bsd 
    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String cadena;
    
    String barra = File.separator;    //Separador de ubicacion Direccion de la base de datos                                      
    String url = System.getProperty("user.dir") + barra + "Datos" + barra + "consulta.db";//Get property sirve para obtener la ubicacion el proyecto
    Connection Conectar; 
    //
    public PreguntandoUsuario() {
        initComponents();
        conexion();//me conecto a la bsd 
        
        
    }
    //metodo getter and setter 

    public String getCadena() {
        return cadena;
    }
    
    //METODO PARA CONECTARME
    public void conexion() {
        try {
            Class.forName("org.sqlite.JDBC");//Clase para corregir el error de la base de datos //este da a entender más la unión a la base de datos para que el prigrma nose paltee
            Conectar = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");//Hacemos conexion con la base de datos, el root es para entrar como administrador
            if (Conectar != null) {
                System.out.println("Conectado");//Si la conexcion es exitosa nos muestra el mensaje
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelAdmi = new javax.swing.JLabel();
        labeldoctor = new javax.swing.JLabel();
        labelpaciente = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Ingrese su tipo de usuario ");

        labelAdmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Admi.png"))); // NOI18N
        labelAdmi.setText("jLabel1");
        labelAdmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAdmiMouseClicked(evt);
            }
        });

        labeldoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/doctor.png"))); // NOI18N
        labeldoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labeldoctorMouseClicked(evt);
            }
        });

        labelpaciente.setBackground(new java.awt.Color(255, 51, 51));
        labelpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cliente.png"))); // NOI18N
        labelpaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelpacienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAdmi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(labelpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(labeldoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAdmi)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labeldoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelAdmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAdmiMouseClicked
        // si es Admi
        objlogin=new Login(Conectar);
        objlogin.setVisible(true);//ingreso al login
        this.dispose();
        //le digo que si es Admi 
        
        objpersona=new Persona();
        if(objpersona.getAdmi())
            cadena="Admi";
        //objpersona.getAdmi();//al que este lo llame lo vuelve true 
        //Persona.EsAdmi=true;
    }//GEN-LAST:event_labelAdmiMouseClicked

    private void labelpacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelpacienteMouseClicked
        // si es paciente 
        objlogin=new Login(Conectar);
        objlogin.setVisible(true);//ingreso al login
        this.dispose();
        //correcto
        objpersona=new Persona();
        if(objpersona.getPaciente())
            cadena="Paciente";
       
    }//GEN-LAST:event_labelpacienteMouseClicked

    private void labeldoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labeldoctorMouseClicked
        // si es doctor 
        objlogin=new Login(Conectar);
        objlogin.setVisible(true);//ingreso al login
        this.dispose();
        //le digo si es doctor 
       objpersona=new Persona();
        if(objpersona.getdoctor())
            cadena="Doctor";
        //objpersona.get
    }//GEN-LAST:event_labeldoctorMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PreguntandoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreguntandoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreguntandoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreguntandoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreguntandoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAdmi;
    private javax.swing.JLabel labeldoctor;
    private javax.swing.JLabel labelpaciente;
    // End of variables declaration//GEN-END:variables
}
