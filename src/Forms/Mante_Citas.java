package Forms;
import Clases.Cita;
import static Forms.Mante_clien.conexion;
import Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mante_Citas extends javax.swing.JFrame {
    static ArrayList<Cita> arrayCita=new ArrayList<Cita>();
    static Connection conexion;
    //Inicializo la tabla 
    String [] titulos={"nrocita","dnidoctor","dnicliente","Nombredoctor","Nombrepaciente","Apelpaciente","Apellidodoctor","fechacita"};
    DefaultTableModel tabla=new DefaultTableModel(null,titulos);
    //objetos
    Paciente objpaciente;
    Doctor objdoctor;
    
    public Mante_Citas(Connection conectar,ArrayList<Cita> arrayPasado) {
        Mante_Citas.arrayCita=arrayPasado;//Primero agarrar el array de citas pasado 
        initComponents();
        conexion=conectar; 
        mostrar();//muestra el Jtable 
    }
    
    public void estadoCita(){
        //Condicion para el estado de la cita
        
    }
    private void buscandonombredoctor(String tipobusqueda,String dato)
    {   tabla.setRowCount(0);  
    
        for(Cita cita :arrayCita)
        {
            if(tipobusqueda.equalsIgnoreCase("Nombres") && cita.getNombredoctor().equalsIgnoreCase(dato))
                 tabla.addRow(new Object[]{cita.getNro(),cita.getDni_doctor(),cita.getDni_paciente(),cita.getNombredoctor(),cita.getNombrepaciente(),
                     cita.getApellidodoctor(),cita.getApellidopaciente(),cita.getFecha_hora()
                 });
                jtabla_citas.setModel(tabla);
            else if (tipobusqueda.equalsIgnoreCase("Apellidos")&& cita.getApellidodoctor().equalsIgnoreCase(dato))
                tabla.addRow(new Object[]{cita.getNro(),cita.getDni_doctor(),cita.getDni_paciente(),cita.getNombredoctor(),cita.getNombrepaciente(),
                     cita.getApellidodoctor(),cita.getApellidopaciente(),cita.getFecha_hora()
                 });
            else if (tipobusqueda.equalsIgnoreCase("Dni") && objdoctor.buscandodni(conexion, dato).equalsIgnoreCase(dato))
                tabla.addRow(new Object[]{cita.getNro(),cita.getDni_doctor(),cita.getDni_paciente(),cita.getNombredoctor(),cita.getNombrepaciente(),
                     cita.getApellidodoctor(),cita.getApellidopaciente(),cita.getFecha_hora()
                 });
            
        }
        
    }
    
    public void mostrar()
    {
         
        tabla.setRowCount(0);//primera fila ?este que hacia ?
        ResultSet resultado=null;//este es el principal para que envie resultados 
        try {
            //Sentencia para obtener los datos de la base de datos
            PreparedStatement mostrar=conexion.prepareStatement("select nro_cita,dni_doctor,dni_cliente,fecha_hora from cita");            
            resultado=mostrar.executeQuery();//Ejecutamos la sentencia
            while(resultado.next()){//Mientras obtenda un resultado 
                //Agregamos los datos obtenidos de la base de datos a la tabla
                tabla.addRow(new Object[]{resultado.getString("nro_cita"),resultado.getString("dni_doctor"),resultado.getString("dni_cliente"),resultado.getString("NombDoctor"),resultado.getString("Nombpaciente"),resultado.getString("Apelldoctor"),resultado.getString("fecha_hora")});             
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jtabla_citas.setModel(tabla);//Establemos el modelo de la tabla
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla_citas = new javax.swing.JTable();
        Comboboxcliente = new javax.swing.JComboBox<>();
        comboboxdoctor = new javax.swing.JComboBox<>();
        txt_paciente = new javax.swing.JTextField();
        txt_doctor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_dni_doc = new javax.swing.JTextField();
        txt_dni_paciente = new javax.swing.JTextField();
        txt_fecha_hora = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JButton();
        txt_eliminar = new javax.swing.JButton();
        txt_editar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(jtabla_citas);

        Comboboxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres", "Apellidos", "Dni" }));

        comboboxdoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres", "Apellidos", "Dni" }));

        jLabel1.setText("Buscar cliente por:");

        jLabel2.setText("Buscar doctor por:");

        jLabel4.setText("Dni Doctor");

        jLabel5.setText("Dni Paciente");

        jLabel6.setText("Fecha Hora");

        jLabel7.setText("Estado");

        txt_buscar.setText("Buscar");
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        txt_eliminar.setText("Eliminar");

        txt_editar.setText("Editar");

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_paciente)
                                .addComponent(txt_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(comboboxdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Comboboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_buscar)
                                .addGap(46, 46, 46)
                                .addComponent(txt_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_eliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_dni_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_dni_paciente)
                                        .addComponent(txt_fecha_hora)
                                        .addComponent(txt_estado))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Comboboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboboxdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_dni_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_dni_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_fecha_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscar)
                            .addComponent(txt_eliminar)
                            .addComponent(txt_editar))
                        .addGap(36, 36, 36)
                        .addComponent(btn_regresar)))
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // Regresando al menú 
        Menu objmenu=new Menu(conexion,arrayCita);
        objmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // cuando aprete el boton buscar 
        String tipobusqueda=Comboboxcliente.getSelectedItem().toString();//tipo de busque yasea dni nombre y apellido 
        String dato=txt_paciente.getText();
       // Ahora lo busco                         //validacion de quiene sta vacio 
        String tipobusqueda1=comboboxdoctor.getSelectedItem().toString();//Doctor
        //
        if(tipobusqueda.isEmpty() && tipobusqueda1.length()>0)
        {
            if(tipobusqueda1.equalsIgnoreCase("Nombres"))//nombre del doctor 
                buscandonombredoctor(tipobusqueda,dato);
        //else
            
        }
        
    }//GEN-LAST:event_txt_buscarActionPerformed
    
    public static void main(String args[]) {

        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mante_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mante_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mante_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mante_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mante_Citas(conexion,arrayCita).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Comboboxcliente;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> comboboxdoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabla_citas;
    private javax.swing.JButton txt_buscar;
    private javax.swing.JTextField txt_dni_doc;
    private javax.swing.JTextField txt_dni_paciente;
    private javax.swing.JTextField txt_doctor;
    private javax.swing.JButton txt_editar;
    private javax.swing.JButton txt_eliminar;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_fecha_hora;
    private javax.swing.JTextField txt_paciente;
    // End of variables declaration//GEN-END:variables
}
