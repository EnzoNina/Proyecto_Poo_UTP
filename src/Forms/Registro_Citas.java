package Forms;
/*
Estoy probando este codigo todavia
Falta mantenimiento de citas
El numero de cita incrementa solo, en el jdatechooser ya se pone la Hora mas 
*/
import Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Registro_Citas extends javax.swing.JFrame {
    //Instanciamos objetos
    Cliente ob_cliente = new Cliente();    
    //Conexion a la base de datos. Por ahora no es necesario    
    //Atributos
    Date fecha;
    SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd HH:mm");//objeto Data format
    String dni;
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    static Connection conexion;
    //Arrays
    ArrayList<Persona> array_persona = new ArrayList<Persona>();    
    ArrayList<Cita> array_cita = new ArrayList<Cita>();
    //Datos de la tabla
    String [] titulos= {"DNI","NOMBRE","APELLIDO","TELEFONO","FECHA NACIMIENTO","DISTRITO"};
    DefaultTableModel tabla_defult = new DefaultTableModel(null, titulos);
    public Registro_Citas(Connection conectar,ArrayList<Persona> array_pasado, ArrayList<Cita>array_cita_pasada, String dni) {
        conexion=conectar;//nos conectaamos
        initComponents();
        array_persona=array_pasado;      
        array_cita=array_cita_pasada;
        setLocationRelativeTo(null);
        this.dni=dni;
    }   
    public void buscar(){   
        tabla_defult.setRowCount(0);
        tabla_doctores.setModel(ob_cliente.buscar_doctor(tabla_defult,array_persona, Jcb_buscar.getSelectedItem().toString(),txt_buscador.getText()));        
    }
    public void agendarCita(){
        int nro_cita;
        if(array_cita.size()==0){
            nro_cita=1;
        }else{
            nro_cita=array_cita.size()+1;
        }
        int seleccion=tabla_doctores.getSelectedRow();        
        fecha=J_cho_cita.getDate();
        //String fecha_String=((JTextField)J_cho_cita.getDateEditor().getUiComponent()).getText();
        String fecha_String=objSDF.format(fecha);
        //int nro, String dni_doctor, String dni_paciente, boolean estado, Date fecha_naci
        Cita ob_cita = new Cita(nro_cita,String.valueOf(tabla_doctores.getValueAt(seleccion,0)), dni, true, fecha);
        array_cita.add(ob_cita);
        //Ingresar a la base de datos
        try {
           PreparedStatement ingresar = conexion.prepareStatement("insert into cita(dni_doctor,dni_cliente,fecha_hora,estado) values (?,?,?,?)");
           ingresar.setString(1,String.valueOf(tabla_doctores.getValueAt(seleccion,0)));
           ingresar.setString(2,dni);
           ingresar.setString(3,fecha_String);
           ingresar.setBoolean(4,true);
           ingresar.executeUpdate();
        }catch (Exception e){            
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void mostrarCita(){
        for (Cita cita : array_cita) {
            JOptionPane.showMessageDialog(null,cita.getNro() +  "\n"+cita.getDni_doctor() +  
                                "\n"+ cita.getDni_paciente()+  "\n" + cita.getFecha_hora());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Btn_agendar_cita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_doctores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Jcb_buscar = new javax.swing.JComboBox<>();
        txt_buscador = new javax.swing.JTextField();
        btn_mostrar_horario = new javax.swing.JButton();
        btn_buscar_doct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        J_cho_cita = new com.toedter.calendar.JDateChooser();
        btn_mostrarCita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Btn_agendar_cita.setText("Agendar Cita");
        Btn_agendar_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agendar_citaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla_doctores);

        jLabel2.setText("Buscar por:");

        Jcb_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Codigo" }));

        btn_mostrar_horario.setText("Mostrar horario del doctor");

        btn_buscar_doct.setText("Buscar Doctor");
        btn_buscar_doct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_doctActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha de la cita:");

        J_cho_cita.setDateFormatString("yyyy/MM/dd HH:mm");

        btn_mostrarCita.setText("Mostrar Cita ");
        btn_mostrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jcb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_mostrar_horario)
                            .addComponent(J_cho_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_mostrarCita)
                            .addComponent(Btn_agendar_cita)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btn_buscar_doct)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Jcb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar_doct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mostrar_horario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J_cho_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(Btn_agendar_cita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_mostrarCita)
                .addGap(13, 13, 13))
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
        agendarCita();
    }//GEN-LAST:event_Btn_agendar_citaActionPerformed

    private void btn_buscar_doctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_doctActionPerformed
        buscar();
    }//GEN-LAST:event_btn_buscar_doctActionPerformed

    private void btn_mostrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarCitaActionPerformed
        mostrarCita();
    }//GEN-LAST:event_btn_mostrarCitaActionPerformed


    public static void main(String args[]) {
        
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Registro_Citas(conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_agendar_cita;
    private com.toedter.calendar.JDateChooser J_cho_cita;
    private javax.swing.JComboBox<String> Jcb_buscar;
    private javax.swing.JButton btn_buscar_doct;
    private javax.swing.JButton btn_mostrarCita;
    private javax.swing.JButton btn_mostrar_horario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_doctores;
    private javax.swing.JTextField txt_buscador;
    // End of variables declaration//GEN-END:variables
}
