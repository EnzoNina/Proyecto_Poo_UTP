package Forms;
/*
Clase generica para las sentencias del SQL, Login, registrar, VER ESO
*/
import Clases.Doctor;
import Clases.historiaClinica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class historiaClinicaForm extends javax.swing.JFrame{
    //atributos
    static private Connection conexion;
    static private ArrayList<historiaClinica> arrayHistoriaClinica = new ArrayList<historiaClinica>();
    static String dniDoctor,dniPaciente;
    static private Date fecha;
    String titulos[]={"nro Historia","Dni Doctor","Dni Paciente","Diagnostico","Receta","Fecha y Hora"};
    DefaultTableModel tablaDefault=new DefaultTableModel(null,titulos);
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Doctor obdoc = new Doctor();
    public historiaClinicaForm(Connection conectar,String DniDodcor,String dniPaciente,Date Fecha,ArrayList<historiaClinica> arrayPasado) {
        historiaClinicaForm.arrayHistoriaClinica=arrayPasado;        
        //Llenamos los text fild con los datos del paciente     
        historiaClinicaForm.conexion=conectar;
        historiaClinicaForm.dniDoctor=DniDodcor;
        historiaClinicaForm.dniPaciente=dniPaciente;
        historiaClinicaForm.fecha=Fecha;        
        initComponents();                
        cargar_tablas();
        try {            
            llenartxt();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    public void cargar_tablas(){
        //Metodo para cargar el historial clinico del paciente        
        for (historiaClinica clinica : arrayHistoriaClinica) {                        
            if(clinica.getDniCliente().equals(dniPaciente)){
                String fechaFormateada=sdf.format(clinica.getFecha());
                tablaDefault.addRow(new Object[]{clinica.getnroHistoria(),clinica.getDniDoctor(),clinica.getDniCliente(),clinica.getDiagnostico(),clinica.getReceta(),fechaFormateada});
            }            
        }
        jtable_historiaClinica.setModel(tablaDefault);
    }
    public void llenartxt() throws SQLException{
        PreparedStatement cargar=conexion.prepareStatement("Select nombre,apellido from paciente where dni='"+dniPaciente+"'");
        ResultSet resultado = cargar.executeQuery();
        txt_dni.setText(dniPaciente);
        txt_nombre.setText(resultado.getString("nombre"));
        txt_apellido.setText(resultado.getString("apellido"));
    }
    public void registrar() throws ParseException, SQLException{
        LocalDateTime fechHora = LocalDateTime.now();        
        Date out = Date.from(fechHora.atZone(ZoneId.systemDefault()).toInstant());
        String fechaStrn = sdf.format(out);        
        Date fechaFormateada=sdf.parse(fechaStrn);
        int nrohistoria;
        if(arrayHistoriaClinica.isEmpty()){
            nrohistoria=1;
        }else{
            nrohistoria=arrayHistoriaClinica.size()+1;
        }
        obdoc.llenarhistoriaClinica(arrayHistoriaClinica, new historiaClinica(nrohistoria, dniPaciente, dniDoctor, txt_diagnostico.getText(), txt_receta.getText(), fechaFormateada));
        //Solo falta agregarlo a la base de datos
        PreparedStatement agregar = conexion.prepareStatement("insert into historia_clinica(dni_doctor,dni_cliente,diagnostico,receta,Fecha) values(?,?,?,?,?)");
        agregar.setString(1, dniDoctor);
        agregar.setString(2, dniPaciente);
        agregar.setString(3, txt_diagnostico.getText());
        agregar.setString(4, txt_receta.getText());
        agregar.setString(5, fechaStrn);        
        agregar.executeUpdate();
        cargar_tablas();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_historiaClinica = new javax.swing.JTable();
        txt_dni = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_diagnostico = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_receta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_registrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtable_historiaClinica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable_historiaClinica);

        txt_dni.setEditable(false);

        txt_nombre.setEditable(false);

        txt_apellido.setEditable(false);

        txt_receta.setColumns(20);
        txt_receta.setRows(5);
        jScrollPane2.setViewportView(txt_receta);

        jLabel1.setText("DNI:");

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 24)); // NOI18N
        jLabel2.setText("Historia Clinica");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido");

        jLabel5.setText("Diagnostico:");

        jLabel6.setText("Receta:");

        btn_registrar.setText("Registrar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar array");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_registrar)
                        .addGap(68, 68, 68)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_dni, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_diagnostico)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_registrar)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        try {
            registrar();
        } catch (ParseException ex) {
            Logger.getLogger(historiaClinicaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(historiaClinicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (historiaClinica clinica : arrayHistoriaClinica) {
            System.out.println(""+clinica.getnroHistoria());
            System.out.println(""+clinica.getDniDoctor());
            System.out.println(""+clinica.getDniCliente());
            System.out.println(""+clinica.getDiagnostico());
            System.out.println(""+clinica.getReceta());
            System.out.println(""+clinica.getFecha());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {      
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(historiaClinicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historiaClinicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historiaClinicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historiaClinicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new historiaClinicaForm(dniCliente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable_historiaClinica;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_diagnostico;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextArea txt_receta;
    // End of variables declaration//GEN-END:variables
}
