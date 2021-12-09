package Forms;

import Clases.Cita;
import Clases.*;
import impl.buscarCitaDoctorApellido;
import impl.buscarCitaDoctorDNI;
import impl.buscarCitaDoctorNombre;
import impl.buscarCitaPacienteApellido;
import impl.buscarCitaPacienteDni;
import impl.buscarCitaPacienteNombre;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Mante_Citas extends javax.swing.JFrame {

    ArrayList<Cita> arrayCita = new ArrayList<Cita>();//aqui creo un array list 
    ArrayList<Persona> arrayPersona= new ArrayList<Persona>();
    static Connection conexion;//statico la conexion
    Cita objcita = new Cita();
    Administrador ob_administrador = new Administrador();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    //Inicializo la tabla 
    String[] titulos = {"nrocita", "dnidoctor", "Nombre doctor", "Apellido doctor", "dnicliente", "Nombre paciente", "Apellido paciente", "fecha cita", "estado"};
    DefaultTableModel tabla = new DefaultTableModel(null, titulos);
    //objetos
    Paciente objpaciente;
    Doctor objdoctor;

    public Mante_Citas(Connection conectar, ArrayList<Cita> arrayPasado,ArrayList<Persona> per) {
        this.arrayCita = arrayPasado;//Primero agarrar el array de citas pasado 
        this.arrayPersona=per;
        initComponents();
        conexion = conectar;
        mostrar();//muestra el Jtable
        cargarCombos();
    }
    public void cargarCombos(){
        for (Persona persona : arrayPersona) {
            if(persona instanceof Doctor){
                comboDoctor.addItem(((Doctor)persona).getDNI());
            }
            if(persona instanceof Paciente){
                comboPaciente.addItem(((Paciente)persona).getDNI());
            }            
        }        
    }
    public void llenarDoctor(){
        for (Persona persona : arrayPersona){
            if(persona instanceof Doctor && persona.getDNI().equals(comboDoctor.getSelectedItem().toString())){                
                txtApellidoDoctor.setText(((Doctor)persona).getApellido());
                txtNombreDoctor.setText(((Doctor)persona).getNombre());
            }
        }
    }
    public void llenarPaciente(){
        for (Persona persona : arrayPersona) {
            if(persona instanceof Paciente && persona.getDNI().equals(comboPaciente.getSelectedItem().toString())){                
                txtApellidoPaciente.setText(((Paciente)persona).getApellido());
                txtNombrePaciente.setText(((Paciente)persona).getNombre());
            }
        }
    }
    public void mostrar() {
        tabla.setRowCount(0);//primera fila
        for (Cita cita : arrayCita) {
            String fecha = sdf.format(cita.getFecha_hora());
            tabla.addRow(new Object[]{cita.getNro(), cita.getDoctor().getDNI(), cita.getDoctor().getNombre(), cita.getDoctor().getApellido(), cita.getPaciente().getDNI(),
                cita.getPaciente().getNombre(),cita.getPaciente().getApellido(), fecha, cita.getEstado()});
        }
        jtabla_citas.setModel(tabla);//Establemos el modelo de la tabla

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla_citas = new javax.swing.JTable();
        BuscarComboboxcliente = new javax.swing.JComboBox<>();
        Buscarcomboboxdoctor = new javax.swing.JComboBox<>();
        txt_paciente = new javax.swing.JTextField();
        txt_doctor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        btnbuscarCliente = new javax.swing.JButton();
        txt_eliminar = new javax.swing.JButton();
        txt_editar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        btnbuscarDoctor = new javax.swing.JButton();
        jdate_fechaHora = new com.toedter.calendar.JDateChooser();
        comboDoctor = new javax.swing.JComboBox<>();
        comboPaciente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        txtApellidoDoctor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        txtApellidoPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtabla_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabla_citasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabla_citas);

        BuscarComboboxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres", "Apellidos", "Dni" }));

        Buscarcomboboxdoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres", "Apellidos", "Dni" }));

        jLabel1.setText("Buscar cliente por:");

        jLabel2.setText("Buscar doctor por:");

        jLabel4.setText("Dni Doctor");

        jLabel5.setText("Dni Paciente");

        jLabel6.setText("Fecha Hora");

        jLabel7.setText("Estado");

        btnbuscarCliente.setText("Buscar cliente");
        btnbuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarClienteActionPerformed(evt);
            }
        });

        txt_eliminar.setText("Eliminar");
        txt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_eliminarActionPerformed(evt);
            }
        });

        txt_editar.setText("Editar");
        txt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_editarActionPerformed(evt);
            }
        });

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        btnbuscarDoctor.setText("Buscar doctor");
        btnbuscarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarDoctorActionPerformed(evt);
            }
        });

        jdate_fechaHora.setDateFormatString("dd/MM/yyyy HH:mm");

        comboDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboDoctorMouseClicked(evt);
            }
        });

        comboPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPacienteMouseClicked(evt);
            }
        });

        jLabel3.setText("Nombre Doctor:");

        jLabel8.setText("Apellido Doctor:");

        txtNombreDoctor.setEditable(false);

        txtApellidoDoctor.setEditable(false);

        jLabel9.setText("Nombre Paciente:");

        jLabel10.setText("Apellido Paciente:");

        txtNombrePaciente.setEditable(false);

        txtApellidoPaciente.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(Buscarcomboboxdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnbuscarDoctor))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txt_editar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_eliminar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel5))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtApellidoDoctor)
                                                .addGap(6, 6, 6))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(49, 49, 49)
                                            .addComponent(comboDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnbuscarCliente))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BuscarComboboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jdate_fechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BuscarComboboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarCliente))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscarcomboboxdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarDoctor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtApellidoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdate_fechaHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_editar)
                    .addComponent(btn_regresar)
                    .addComponent(txt_eliminar))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // Regresando al menú 
        Menu objmenu = new Menu(conexion, arrayCita);
        objmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btnbuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarClienteActionPerformed
        buscarCita obCita = new buscarCita(tabla, txt_paciente.getText(), arrayCita);
        if (BuscarComboboxcliente.getSelectedItem().toString().equalsIgnoreCase("Nombres")) {//si es igual a nombres 
            tabla.setRowCount(0);//borro el inicio 
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaPacienteNombre()));//establesco el modelo 
        } else if (BuscarComboboxcliente.getSelectedItem().toString().equalsIgnoreCase("Apellidos")) {
            tabla.setRowCount(0);
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaPacienteApellido()));
        } else {
            tabla.setRowCount(0);
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaPacienteDni()));
        }
    }//GEN-LAST:event_btnbuscarClienteActionPerformed

    private void txt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_editarActionPerformed
        int seleccion = jtabla_citas.getSelectedRow();//Atributo para escoger la fila de la tabla
        String fecha = sdf.format(jdate_fechaHora.getDate());
        boolean estado = Boolean.parseBoolean(txt_estado.getText());
        int nroCita = Integer.parseInt(String.valueOf(jtabla_citas.getValueAt(seleccion, 0)));
        String dniDoc=comboDoctor.getSelectedItem().toString();
        String dniPac=comboPaciente.getSelectedItem().toString();
        Doctor obDoctorNuevo=objcita.obtenerDoctor(arrayPersona,dniDoc);
        Paciente obPacienteNuevo=objcita.obtenerPaciente(arrayPersona,dniPac);
        Cita objetoNuevo = new Cita(nroCita,obDoctorNuevo,obPacienteNuevo,estado,jdate_fechaHora.getDate());
        ob_administrador.modificarCita(conexion,arrayCita,objetoNuevo,seleccion);
        mostrar();
    }//GEN-LAST:event_txt_editarActionPerformed

    private void btnbuscarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarDoctorActionPerformed
        buscarCita obCita = new buscarCita(tabla, txt_doctor.getText(), arrayCita);
        if (Buscarcomboboxdoctor.getSelectedItem().toString().equalsIgnoreCase("Nombres")) {
            tabla.setRowCount(0);
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaDoctorNombre()));
        } else if (Buscarcomboboxdoctor.getSelectedItem().toString().equalsIgnoreCase("Apellidos")) {
            tabla.setRowCount(0);
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaDoctorApellido()));
        } else {
            tabla.setRowCount(0);
            jtabla_citas.setModel(obCita.buscarCitaPor(new buscarCitaDoctorDNI()));
        }
    }//GEN-LAST:event_btnbuscarDoctorActionPerformed

    private void jtabla_citasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabla_citasMouseClicked
        try {
            int seleccion = jtabla_citas.rowAtPoint(evt.getPoint());//Sirve para obtener la posicion de la fila de la Jtable            
            comboDoctor.setSelectedItem(String.valueOf(jtabla_citas.getValueAt(seleccion, 1)));
            txtNombreDoctor.setText(String.valueOf(jtabla_citas.getValueAt(seleccion, 2)));
            txtApellidoDoctor.setText(String.valueOf(jtabla_citas.getValueAt(seleccion, 3)));        
            comboPaciente.setSelectedItem(String.valueOf(jtabla_citas.getValueAt(seleccion, 4)));
            txtNombrePaciente.setText(String.valueOf(jtabla_citas.getValueAt(seleccion, 5)));
            txtApellidoPaciente.setText(String.valueOf(jtabla_citas.getValueAt(seleccion, 6)));            
            String fechaSt = String.valueOf(jtabla_citas.getValueAt(seleccion, 7));
            Date fecha = sdf.parse(fechaSt);
            jdate_fechaHora.setDate(fecha);
            txt_estado.setText(String.valueOf(jtabla_citas.getValueAt(seleccion, 8)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jtabla_citasMouseClicked

    private void txt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_eliminarActionPerformed
        int seleccion = jtabla_citas.getSelectedRow();//Atributo para escoger la fila de la tabla        
        int nroCita = Integer.parseInt(String.valueOf(jtabla_citas.getValueAt(seleccion, 0)));
        ob_administrador.eliminar(conexion, arrayCita, nroCita);
        mostrar();
    }//GEN-LAST:event_txt_eliminarActionPerformed

    private void comboDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboDoctorMouseClicked
        llenarDoctor();
    }//GEN-LAST:event_comboDoctorMouseClicked

    private void comboPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPacienteMouseClicked
        llenarPaciente();
    }//GEN-LAST:event_comboPacienteMouseClicked

    public static void main(String args[]) {

        try {
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
                //new Mante_Citas(conexion,arrayCita).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BuscarComboboxcliente;
    private javax.swing.JComboBox<String> Buscarcomboboxdoctor;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btnbuscarCliente;
    private javax.swing.JButton btnbuscarDoctor;
    private javax.swing.JComboBox<String> comboDoctor;
    private javax.swing.JComboBox<String> comboPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private com.toedter.calendar.JDateChooser jdate_fechaHora;
    private javax.swing.JTable jtabla_citas;
    private javax.swing.JTextField txtApellidoDoctor;
    private javax.swing.JTextField txtApellidoPaciente;
    private javax.swing.JTextField txtNombreDoctor;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txt_doctor;
    private javax.swing.JButton txt_editar;
    private javax.swing.JButton txt_eliminar;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_paciente;
    // End of variables declaration//GEN-END:variables
}
