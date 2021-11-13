package Forms;

import Clases.Buscar;
import Clases.Doctor;
import Clases.Persona;
import impl.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mante_doc extends javax.swing.JFrame {
    static Connection conexion;
    Doctor obDoctor=new Doctor();
    //Tabla    
    String [] titulos={"Dni","Usuario","Contraseña","Nombre","Apellido","Fecha Nacimiento","Telefono","Distrito"};//Array titulos para la tabla
    DefaultTableModel tabla=new DefaultTableModel(null,titulos);//Establecemos la tabla sin filas y con los titulos
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Persona>array_persona=new ArrayList<Persona>();
    public Mante_doc(Connection conectar,ArrayList<Persona>arrayPasado) {     //objeto de coneccion ademas el static ayuda a que la coneccion este por toda la tabla   
        conexion=conectar;
        array_persona=arrayPasado;
        initComponents();        
        mostrar();
    }
    public void agregar(){
        int resultado=obDoctor.registrar(conexion, new Doctor(txt_mante_dni.getText(), txt_usuario.getText(), txt_contraseña.getText(), 
            txt_mante_nombre.getText(), txt_mante_apell.getText(), jdateFechaNacimiento.getDate(),Integer.parseInt(txt_telefono.getText()), txt_mante_distr.getText()));
        if(resultado>0){
            JOptionPane.showMessageDialog(null,"Doctor Registrado Correctamente");
        }else
            JOptionPane.showMessageDialog(null, "Ocurrio un error, revisa los datos");
        mostrar();
    }
    public void mostrar()
    {        
        tabla.setRowCount(0);
        ResultSet resultado=null;//este es el principal para que envie resultados 
        try {
            //Sentencia para obtener los datos de la base de datos
            PreparedStatement mostrar=conexion.prepareStatement("select dni,Usuario,Contraseña,nombre,apellido,fecha_nac,telefono,distrito from doctor");            
            resultado=mostrar.executeQuery();//Ejecutamos la sentencia
            while(resultado.next()){//Mientras obtenda un resultado 
                //Agregamos los datos obtenidos de la base de datos a la tabla
                tabla.addRow(new Object[]{resultado.getString("dni"),resultado.getString("Usuario"),resultado.getString("Contraseña"),resultado.getString("nombre"),resultado.getString("apellido"),
                    resultado.getString("fecha_nac"),resultado.getString("telefono"),resultado.getString("distrito")});             
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
        jtable_doctores.setModel(tabla);//Establemos el modelo de la tabla
    }
    public void editar()
    {//Ver si le agrego en modificacion mas atributos
        int editar=obDoctor.modificar(conexion, new Doctor(txt_mante_dni.getText(), txt_usuario.getText(), txt_contraseña.getText(), 
            txt_mante_nombre.getText(), txt_mante_apell.getText(), jdateFechaNacimiento.getDate(),Integer.parseInt(txt_telefono.getText()), txt_mante_distr.getText()));
        if(editar> 0){//Si el resultado es mayor a 0,nos indica que se modificaron exitosamente        
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
        int rst=obDoctor.borrar(conexion, txt_mante_dni.getText());
        if(rst>0){
            JOptionPane.showMessageDialog(null,"Doctor Eliminado Correctamente");
        }else
            JOptionPane.showMessageDialog(null, "Ocurrio un error, revisa los datos");
        mostrar();
    }
    public void buscarDoctor(){        
        tabla.setRowCount(0);       
        if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Nombre")){
            tabla.setRowCount(0);
            Buscar ob_buscarNombre=new Buscar(tabla, txt_buscarPor.getText(), array_persona);
            jtable_doctores.setModel(ob_buscarNombre.buscarPor(new buscarPorNombre()));
        }else if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Dni")){
            tabla.setRowCount(0);
            Buscar ob_buscarDNI=new Buscar(tabla, txt_buscarPor.getText(), array_persona);
            jtable_doctores.setModel(ob_buscarDNI.buscarPor(new buscarPorDni()));            
        }else if(jcb_buscarPor.getSelectedItem().toString().equalsIgnoreCase("Apellido")){
            tabla.setRowCount(0);
            Buscar ob_buscarApellido=new Buscar(tabla, txt_buscarPor.getText(), array_persona);
            jtable_doctores.setModel(ob_buscarApellido.buscarPor(new buscarPorApellido()));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_mante_dni = new javax.swing.JTextField();
        txt_mante_nombre = new javax.swing.JTextField();
        txt_mante_apell = new javax.swing.JTextField();
        txt_mante_distr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_doctores = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        btn_atras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jdateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jcb_buscarPor = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_buscarPor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Dni");

        jLabel2.setText("Nombre");

        jLabel4.setText("Distrito");

        jLabel5.setText("Apellido");

        jtable_doctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtable_doctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_doctoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable_doctores);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Usuario");

        jLabel6.setText("Contraseña");

        btn_atras.setText("Retroceder");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefono:");

        jLabel8.setText("Fecha Nacimiento");

        jLabel11.setText("Buscar Por:");

        jcb_buscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Dni" }));

        jLabel12.setText("Doctor buscar:");

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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar)
                        .addGap(753, 753, 753)
                        .addComponent(btn_atras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario)
                            .addComponent(txt_contraseña)
                            .addComponent(txt_mante_nombre)
                            .addComponent(txt_mante_apell)
                            .addComponent(jdateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefono)
                            .addComponent(txt_mante_distr, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mante_dni)
                            .addComponent(txt_buscarPor)
                            .addComponent(jcb_buscarPor, 0, 164, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_mante_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mante_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mante_apell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_mante_distr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btn_atras)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                                                                 //tengo que ver esto 
    private void jtable_doctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_doctoresMouseClicked
        try {
            int seleccion=jtable_doctores.rowAtPoint(evt.getPoint());//Sirve para obtener la posicion de la fila de la Jtable
            txt_mante_dni.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 0)));//Establece los text field con el texto obtenido de la Jtable
            txt_usuario.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 1)));
            txt_contraseña.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 2)));
            txt_mante_nombre.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 3)));
            txt_mante_apell.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 4)));
            String fechaSt=String.valueOf(jtable_doctores.getValueAt(seleccion,5));
            Date fecha=sdf.parse(fechaSt);
            jdateFechaNacimiento.setDate(fecha);
            txt_telefono.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 6)));
            txt_mante_distr.setText(String.valueOf(jtable_doctores.getValueAt(seleccion, 7)));
        } catch (ParseException ex) {
            Logger.getLogger(Mante_doc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtable_doctoresMouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        editar();
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        agregar();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        Menu ob_menu = new Menu(conexion);
        ob_menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarDoctor();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Mante_doc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mante_doc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mante_doc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mante_doc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Mante_doc(conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcb_buscarPor;
    private com.toedter.calendar.JDateChooser jdateFechaNacimiento;
    private javax.swing.JTable jtable_doctores;
    private javax.swing.JTextField txt_buscarPor;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_mante_apell;
    private javax.swing.JTextField txt_mante_distr;
    private javax.swing.JTextField txt_mante_dni;
    private javax.swing.JTextField txt_mante_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
