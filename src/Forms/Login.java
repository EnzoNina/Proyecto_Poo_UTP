package Forms;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public final class Login extends javax.swing.JFrame {
    //DECLARANDO OBJETOS 
    public static  PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    boolean Esdoctor;
    //
    String barra = File.separator;    //Separador de ubicacion
    //Direccion de la base de datos
    String url=System.getProperty("user.dir")+barra+"Datos"+barra+"consulta.db";//Get property sirve para obtener la ubicacion el proyecto
    Connection Conectar; //Objeto de conexion para conectarnos con la base de datos
    //CONSTRCUTOR 
    public Login() {
        initComponents();
        setLocationRelativeTo(null);//Posicion de la ventana en le medio de la ventana
        conexion();//Inicializamos el metodo de conexcion
        
    }
    //METODO PARA CONECTARME
    public void conexion()
    {       
        try {
            Class.forName("org.sqlite.JDBC");//Clase para corregir el error de la base de datos //este da a entender más la unión a la base de datos para que el prigrma nose paltee
            Conectar = DriverManager.getConnection("jdbc:sqlite:"+url,"root","");//Hacemos conexion con la base de datos, el root es para entrar como administrador
            if (Conectar!=null) {
                System.out.println("Conectado");//Si la conexcion es exitosa nos muestra el mensaje
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }
    //buscando usuario en la base de datos VERIFICANDO 
    public String verificandotipousuario(String usuario,String contraseña)
    {
        String busqueda_usuario=null;
        
        try
        {//para buscar doctor tambien puede servir 
            String  Buscando_usuario=("SELECT nombre FROM paciente WHERE contrase�a = '"+contrase�a+"'");
            sentencia_preparada=Conectar.prepareStatement(Buscando_usuario);
            resultado=sentencia_preparada.executeQuery();
            //condicion 
            if(resultado.next())
            {
                
                String Nombre=resultado.getString("nombre");
                busqueda_usuario=("Bienvenido "+Nombre);
                Esdoctor=false;
            }
            else 
                busqueda_usuario=BuscandobsdDoctores(usuario,contraseña);
        }catch(Exception e){
            System.out.println(e);
        }
        return busqueda_usuario;   
    }
    
    //Buscando en la base de datos si el usuario es un doctor 
    public String BuscandobsdDoctores(String usuario,String contraseña)
    {
        String busqueda_usuario_doctor=null;
        
        try
        {                                     //para buscar doctor tambien puede servir 
            String sentencia_buscar=("SELECT nombre FROM doctor WHERE contraseña = '"+contraseña+"'");
            sentencia_preparada=Conectar.prepareStatement(sentencia_buscar);
            resultado=sentencia_preparada.executeQuery();
            //condicion 
            if(resultado.next())
            {
                
                String Nombre=resultado.getString("nombre");
                busqueda_usuario_doctor=("Bienvenido Doctor "+Nombre);
                Esdoctor=true;
            }
            else
                busqueda_usuario_doctor="Usted no se encuentra registrado en el sistema";
            
        }catch(Exception e){
            System.out.println(e);
        }
        return busqueda_usuario_doctor;   
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
        Registrar ob_regis = new Registrar(Conectar);//Paamos el objeto conexion para no tener que repetir el codigo
        ob_regis.setVisible(true); //Hacemos visible la ventand de Registrar
        this.dispose();//Cerramos esta ventana ademas ahorramos ram
    }//GEN-LAST:event_btn_crear_cuentaActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        //Aqui pongo la verificacion de usuarios 
        //introduciendo datos 
        String usuario=txt_user.getText();
        String contraseña=Jpf_pass.getText();
        //llamando metodos 
        JOptionPane.showMessageDialog(null, verificandotipousuario(usuario, contraseña));
        //condicionparaver si es doctor 
        if(Esdoctor)
        {
            Menu objmenu=new Menu(Conectar);
            objmenu.setVisible(true);
            this.dispose();
        }
        else if(Esdoctor==false)
        {
            Registro_Citas objregistrar=new Registro_Citas(Conectar);
            objregistrar.setVisible(true);
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "No se encuentra registrado en el sistema ");
        
        
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
                new Login().setVisible(true);
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
