package Forms;
//Adjuntar el scrip de la base de datos en un bloc de notas
import Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public  class Login extends javax.swing.JFrame {        
//DECLARANDO OBJETOS y datos para conectarme con la bsd 
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    static Connection conexion;    
    ArrayList<Persona> personas_array = new ArrayList<Persona>();
    ArrayList<Cita> array_cita = new ArrayList<Cita>();
    ArrayList<historiaClinica> array_historiaClinica = new ArrayList<historiaClinica>();
    //CONSTRCUTOR 
    public void cargar(){
        //Cargamos datos del array de la cita
        try {
            PreparedStatement cita = conexion.prepareStatement("Select nro_cita,dni_doctor,dni_cliente,fecha_hora,estado from cita");
            ResultSet resultado_cita = cita.executeQuery();
            while(resultado_cita.next()){
                int nro_cita=resultado_cita.getInt("nro_cita");
                String dni_coctor=resultado_cita.getString("dni_doctor");
                String dni_cliente=resultado_cita.getString("dni_cliente");
                String fecha_hora = resultado_cita.getString("fecha_hora");
                SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date fecha_formateada = formateo.parse(fecha_hora);                
                boolean estado = resultado_cita.getBoolean("estado");
                Cita  obcita = new Cita(nro_cita, dni_coctor, dni_cliente, estado, fecha_formateada);
                array_cita.add(obcita);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
        //Cargamos los datos de los pacientes
        try {
            PreparedStatement pacientes = conexion.prepareStatement("Select dni,usuario,contraseña,nombre,apellido,fecha_nac,telefono from paciente");
            ResultSet resultado=pacientes.executeQuery();
            while(resultado.next())
            {
                String dni=resultado.getString("dni");
                String usuario_lista=resultado.getString("usuario");
                String contraseña_lista=resultado.getString("contraseña");
                String nombre=resultado.getString("nombre");
                String apellido=resultado.getString("apellido");
                String fecha_nac=resultado.getString("fecha_nac");
                SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha_date=objSDF.parse(fecha_nac);
                String telefono=resultado.getString("telefono");
                Paciente personas =new Paciente(dni, usuario_lista, contraseña_lista, nombre, apellido,Integer.parseInt(telefono), fecha_date);
                personas_array.add(personas);                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
        //Cargamos informacion de los doctores
        try {
            PreparedStatement doctor = conexion.prepareStatement("Select dni,usuario,contraseña,nombre,apellido,fecha_nac,telefono,distrito from doctor");
            ResultSet resultado=doctor.executeQuery();
            while(resultado.next())
            {
                String dni=resultado.getString("dni");
                String usuario_lista=resultado.getString("usuario");
                String contraseña_lista=resultado.getString("contraseña");
                String nombre=resultado.getString("nombre");
                String apellido=resultado.getString("apellido");
                String fecha_nac=resultado.getString("fecha_nac");
                SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha_date=objSDF.parse(fecha_nac);
                String telefono=resultado.getString("telefono");
                String distrito=resultado.getString("distrito");
                Doctor doctores =new Doctor(dni, usuario_lista, contraseña_lista, nombre, apellido,fecha_date,Integer.parseInt(telefono),distrito);
                personas_array.add(doctores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
        //Cargamos informacion de la historia Clinica
        try {
            PreparedStatement historiaClinica = conexion.prepareStatement("Select nro_historia,dni_doctor,dni_cliente,diagnostico,receta,Fecha from historia_clinica");
            ResultSet resultado=historiaClinica.executeQuery();
            while(resultado.next())
            {
                int nroHistoria=resultado.getInt("nro_historia");
                String dni_doctor=resultado.getString("dni_doctor");
                String dni_cliente=resultado.getString("dni_cliente");
                String diagnostico=resultado.getString("diagnostico");
                String receta=resultado.getString("receta");
                String Fecha=resultado.getString("Fecha");
                SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date fecha_date=objSDF.parse(Fecha);
                array_historiaClinica.add(new historiaClinica(nroHistoria, dni_cliente, dni_doctor, diagnostico, receta, fecha_date));                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }
    public Login(Connection conectar) {
        initComponents();
        setLocationRelativeTo(null);//Posicion de la ventana en le medio de la ventana
        conexion=conectar;
        cargar();
    }    
    //buscando usuario en la base de datos VERIFICANDO 
    public void verificando_paciente(String usuario, String contraseña) {//verifico si es un paciente 
        String busqueda_usuario = null;
        //Verificar
        try {//para buscar doctor tambien puede servir 
            String Buscando_paciente = ("SELECT dni,nombre,apellido FROM paciente WHERE contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(Buscando_paciente);//preparandpsentencia buscando
            resultado = sentencia_preparada.executeQuery();//botamos el resultado
            //condicion 
            if (resultado.next()) {

                String Nombre_usuario = resultado.getString("nombre");
                String apellidoUsuario=resultado.getString("apellido");
                String dni = resultado.getString("dni");
                busqueda_usuario = ("Bienvenido " + Nombre_usuario + " " +apellidoUsuario);
                JOptionPane.showMessageDialog(null, busqueda_usuario);
                //INGRESA AL JFRAME 
                Registro_Citas objregistro = new Registro_Citas(conexion,personas_array,array_cita,dni);
                objregistro.setVisible(true);
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(null,"Usted no se encuentra registrado");
        } catch (Exception e) {
            System.out.println(e);
        }                
    }
    
    //Buscando en la base de datos si el usuario es un doctor 
    public void verificando_Doctor(String usuario, String contraseña) {
        String busqueda_usuario_doctor = null;
        try {//para buscar doctor tambien puede servir 
            String sentencia_buscar = ("SELECT dni,nombre,apellido,Usuario FROM doctor WHERE Usuario = '" + usuario + "' AND Contraseña = '"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido=resultado.getString("apellido");
                busqueda_usuario_doctor = ("Bienvenido Doctor " + nombre +" "+apellido);//CREO UN OBJETO DOCTOR ESTE DESPUE LLAMO AL METODO CARAGARDATOSDELDOCTOR Y PORFIN LO COMPLETO Y ASI ESTE PUEDE FUNCIONAR 
                String dniDoctor=resultado.getString("dni");
                JOptionPane.showMessageDialog(null,busqueda_usuario_doctor);
                //ingresando al jframe
                Atencion_Pacientes objPacientes = new Atencion_Pacientes(dniDoctor,conexion,array_cita,array_historiaClinica);//si no es doctor ,es un paciente
                objPacientes.setVisible(true);
                this.dispose();                
            } 
            else
                JOptionPane.showMessageDialog(null,"Usted no se encuentra registrado");
        } catch (Exception e) {
            System.out.println(e);
        }                
    }
    //MIRANDO SI ES UN Administrador 
    public void VerificandoAdministrador(String usuario, String contraseña) {
        String busqueda_usuario_Administrador = null;
        try {                                     //para buscar Administrador puede servir 
            String sentencia_buscar_Admin = ("SELECT usuario FROM Administrador WHERE usuario = '" + usuario + "' AND contraseña = '"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_Admin);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {

                String Nombreadmi = resultado.getString("usuario");
                busqueda_usuario_Administrador = ("Bienvenido Admi " + Nombreadmi);//CREO UN OBJETO DOCTOR ESTE DESPUE LLAMO AL METODO CARAGARDATOSDELDOCTOR Y PORFIN LO COMPLETO Y ASI ESTE PUEDE FUNCIONAR 
                //mostrando mensaje
                JOptionPane.showMessageDialog(null, busqueda_usuario_Administrador);                                                    //CLARO AQUI CREAR UN OBJETO QUE ES DE DOCTOR 
                // ingresando  //yase haga el metodo publico static  para oftewner el objeto que a entrado y poder usarlo identificado que usuarioe es
                Menu objmenu = new Menu(conexion,array_cita);
                objmenu.setVisible(true);
                this.dispose(); 
            }                                                             //o lo creo defrente porque,ya lo identifque ya 
            else
            {
                JOptionPane.showMessageDialog(null, "Usted no se encuentra registrado en el sistemas ");
            }
 
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_img_encabezado = new javax.swing.JLabel();
        jbl_usuario = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        Jpf_pass = new javax.swing.JPasswordField();
        btn_ingresar = new javax.swing.JButton();
        btn_crear_cuenta = new javax.swing.JButton();
        lbl_aviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jl_img_encabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iniciar-sesion (1).png"))); // NOI18N

        jbl_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/usuario(1).png"))); // NOI18N

        lbl_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/contraseña_1(1).png"))); // NOI18N

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        btn_crear_cuenta.setText("Crear Cuenta");
        btn_crear_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_cuentaActionPerformed(evt);
            }
        });

        lbl_aviso.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lbl_aviso.setText("¿No tienes una cuenta?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jl_img_encabezado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jbl_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbl_pass)
                        .addGap(18, 18, 18)
                        .addComponent(Jpf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_aviso)
                            .addComponent(btn_crear_cuenta)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btn_ingresar)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jl_img_encabezado)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbl_usuario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pass)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Jpf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_ingresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_aviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_crear_cuenta)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crear_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_cuentaActionPerformed
        Registrar ob_regis = new Registrar(conexion);//Paamos el objeto conexion para no tener que repetir el codigo
        ob_regis.setVisible(true); //Hacemos visible la ventand de Registrar
        this.dispose();//Cerramos esta ventana ademas ahorramos ram
    }//GEN-LAST:event_btn_crear_cuentaActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        //Aqui pongo la verificacion de usuarios 
        //introduciendo datos 
        String usuario = txt_user.getText();
        String contraseña = Jpf_pass.getText();
        //objpersona 
        Persona objpersona1=new Persona();
        
        //llamando metodos         
        //condicionparaver si es doctor 
        
        switch(PreguntandoUsuario.cadena)
        {
            case "Admi":this.VerificandoAdministrador(usuario, contraseña);break;
            case "Doctor":this.verificando_Doctor(usuario, contraseña);break;
            case "Paciente":this.verificando_paciente(usuario, contraseña);break;
            default:System.out.println("NO SE ENCONTRO EL USUARIO!!");
        }        
    }//GEN-LAST:event_btn_ingresarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login(conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Jpf_pass;
    private javax.swing.JButton btn_crear_cuenta;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbl_usuario;
    private javax.swing.JLabel jl_img_encabezado;
    private javax.swing.JLabel lbl_aviso;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

}
