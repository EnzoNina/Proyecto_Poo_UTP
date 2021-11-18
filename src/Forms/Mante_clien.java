package Forms;
import Clases.Buscar;
import Clases.Paciente;
import Clases.Persona;
import impl.buscarPacientePorApellido;
import impl.buscarPacientePorDni;
import impl.buscarPacientePorNombre;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Mante_clien extends javax.swing.JFrame {  
    static Connection conexion;//Objeto conexion
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");//date format 
    Paciente obPaciente = new Paciente();//objeto paciente
    //Tabla    
    String [] titulos={"Dni","Nombre","Apellido","f.nacimiento","Télefono","Usuario","contraseña"};
    DefaultTableModel tabla=new DefaultTableModel(null,titulos);//objeto Arrayslist  con sus subtitulos
    ArrayList<Persona>array_persona=new ArrayList<Persona>();
    public Mante_clien(Connection conectar,ArrayList<Persona>arrayPasado) {
        array_persona=arrayPasado;//le envio eñ array list de persona 
        conexion=conectar;//presigue la conexion a la base de datos 
        initComponents();
        mostrar();
    }
    //metodo mostrar 
     public void mostrar()//Imprime todo lo que esta en la bsd de cliente
    {        
        tabla.setRowCount(0);//primera fila
        ResultSet resultado=null;//este es el principal para que envie resultados 
        try {
            //Sentencia para obtener los datos de la base de datos
            PreparedStatement mostrar=conexion.prepareStatement("select dni,usuario,contraseña,nombre,apellido,fecha_nac,telefono from paciente");            
            resultado=mostrar.executeQuery();//Ejecutamos la sentencia
            while(resultado.next()){//Mientras obtenda un resultado 
                //Agregamos los datos obtenidos de la base de datos a la tabla
                tabla.addRow(new Object[]{resultado.getString("dni"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("fecha_nac"),resultado.getString("telefono"),resultado.getString("usuario"),resultado.getString("contraseña") });             
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTable_Pacientes.setModel(tabla);//Establemos el modelo de la tabla
    }
     
    public void editar()
    {        
        int editar=obPaciente.modificar(conexion,new Paciente(txt_clien_dni.getText(), txt_usuario.getText(), txt_contraseña.getText(), 
                txt_clien_nom.getText(), txt_clien_apell.getText(), Integer.parseInt(txt_clien_telf.getText()), jdate_fecha.getDate()));
        if(editar>0){//Si el resultado es mayor a 0,nos indica que se modificaron exitosamente        
            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                          JOptionPane.INFORMATION_MESSAGE);            
        }else{        
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.", "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);        
        }
        mostrar();
    }
    
     public void eliminar(){                 
        int resultado=obPaciente.borrar(conexion,txt_clien_dni.getText());
        if(resultado>0){
            JOptionPane.showMessageDialog(null,"Paciente elimnado correctamente");
        }
        mostrar();
    }
     public void buscarPor(){
         tabla.setRowCount(0);//borrar la tabla     
        if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Nombre")){//si es nombre
            tabla.setRowCount(0);
            Buscar ob_buscarNombre=new Buscar(tabla, txt_buscarPor.getText(), array_persona);//le envio el texto
            jTable_Pacientes.setModel(ob_buscarNombre.buscarPor(new buscarPacientePorNombre()));
        }else if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Dni")){
            tabla.setRowCount(0);
            Buscar ob_buscarDNI=new Buscar(tabla, txt_buscarPor.getText(), array_persona);
            jTable_Pacientes.setModel(ob_buscarDNI.buscarPor(new buscarPacientePorDni()));            
        }else if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Apellido")){
            tabla.setRowCount(0);
            Buscar ob_buscarApellido=new Buscar(tabla, txt_buscarPor.getText(), array_persona);
            jTable_Pacientes.setModel(ob_buscarApellido.buscarPor(new buscarPacientePorApellido()));
        }
     }     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_contraseña = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_clien_dni = new javax.swing.JTextField();
        txt_clien_nom = new javax.swing.JTextField();
        txt_clien_apell = new javax.swing.JTextField();
        txt_clien_telf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Pacientes = new javax.swing.JTable();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_regresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jdate_fecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jcb_buscarPor = new javax.swing.JComboBox<>();
        txt_buscarPor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setText("Telefono");

        jTable_Pacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Pacientes);

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Contraseña");

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel7.setText("Usuario");

        jLabel8.setText("Buscar Por:");

        jcb_buscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Dni" }));

        jLabel9.setText("Cliente buscar:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(btn_modificar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_eliminar)
                        .addGap(34, 34, 34)
                        .addComponent(btn_regresar))
                    .addComponent(txt_clien_apell, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jcb_buscarPor, javax.swing.GroupLayout.Alignment.LEADING, 0, 175, Short.MAX_VALUE)
                        .addComponent(txt_clien_dni, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_clien_nom, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_clien_telf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_contraseña, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdate_fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_clien_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_clien_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_clien_apell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdate_fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_clien_telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_regresar))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        editar();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jTable_PacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PacientesMouseClicked
        // aqui
        //poniendo los datos del jtable en las cjas de texto 
        int seleccion1=jTable_Pacientes.rowAtPoint(evt.getPoint());//Sirve para obtener la posicion de la fila de la Jtable
        txt_clien_dni.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 0)));//Establece los text field con el texto obtenido de la Jtable        
        txt_clien_nom.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 1)));
        txt_clien_apell.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 2)));//Aca si apreto un doctor en la jtable transfiere los datos         
        try {
            jdate_fecha.setDate(sdf.parse(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 3))));
        } catch (ParseException ex) {
            Logger.getLogger(Mante_clien.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_clien_telf.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 4)));
        txt_usuario.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 5)));
        txt_contraseña.setText(String.valueOf(jTable_Pacientes.getValueAt(seleccion1, 6)));
    }//GEN-LAST:event_jTable_PacientesMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // eliminando
        eliminar();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // regresamos 
        Menu objmenu=new Menu(conexion);
        objmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPor();
    }//GEN-LAST:event_btnBuscarActionPerformed
   
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
            java.util.logging.Logger.getLogger(Mante_clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mante_clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mante_clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mante_clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Mante_clien(conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Pacientes;
    private javax.swing.JComboBox<String> jcb_buscarPor;
    private com.toedter.calendar.JDateChooser jdate_fecha;
    private javax.swing.JTextField txt_buscarPor;
    private javax.swing.JTextField txt_clien_apell;
    private javax.swing.JTextField txt_clien_dni;
    private javax.swing.JTextField txt_clien_nom;
    private javax.swing.JTextField txt_clien_telf;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
