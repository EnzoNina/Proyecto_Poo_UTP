package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class Administrador extends Persona{
    //Atributos
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    private boolean EsAdmi=false;
    //constructor

    public Administrador() {
    }

    public Administrador(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, int Numero, Date fecha_naci) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
    }
    
    public boolean getAdmi()
    {   
        return EsAdmi=true;           //aca en el login miraremos la situacion si se convierto en verdadeo ara algo
    }
    //Metodos publicos
    public int modificarCita(Connection conectar,ArrayList<Cita>arrayCita,Cita objetoCita,int nroCita){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Connection conexion=conectar;
        int rlt=-1;          
        try {
            //Sentencia para modificar los datos de la base de datos
            sentencia_preparada=conexion.prepareStatement("update cita set dni_doctor=?,nombredoctor=?,Apellidodoctor=?,dni_cliente=?,nombrepaciente=?,Apellidopaciente=?,fecha_hora=?,estado=? WHERE nro_cita=?");
            sentencia_preparada.setString(1, objetoCita.getDoctor().getDNI());
            sentencia_preparada.setString(2, objetoCita.getDoctor().getNombre());
            sentencia_preparada.setString(3, objetoCita.getDoctor().getApellido());
            sentencia_preparada.setString(4, objetoCita.getPaciente().getDNI());
            sentencia_preparada.setString(5, objetoCita.getPaciente().getNombre());
            sentencia_preparada.setString(6, objetoCita.getPaciente().getApellido());
            String fecha=sdf.format(objetoCita.getFecha_hora());
            sentencia_preparada.setString(7, fecha);
            sentencia_preparada.setBoolean(8, objetoCita.getEstado());
            sentencia_preparada.setInt(9, objetoCita.getNro());
            rlt=sentencia_preparada.executeUpdate();            
        } catch (Exception e) {
            System.out.println(e);
        }
        arrayCita.set(nroCita, objetoCita);
        return rlt;
    }
    public void eliminar(Connection conectar,ArrayList<Cita>arrayCita,int nroCita){
        Connection conexion=conectar;
        try {
            sentencia_preparada=conexion.prepareStatement("delete from cita where nro_cita=?");            
            sentencia_preparada.setInt(1, nroCita);
            sentencia_preparada.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        arrayCita.remove(nroCita-2);
    }
    //Metodos implementados
    @Override
    public Administrador login(Connection conectar, String usuario, String contraseña) {
        Connection conexion=conectar;
        Administrador obAdmi = null;
        try {
            String sentencia_buscar = ("SELECT * FROM Administrador WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {                                
                String idAdministrador = resultado.getString("dni");
                String usuarioOb=resultado.getString("usuario");
                String passOb=resultado.getString("contraseña");
                String nombre=resultado.getString("nombre");
                String apellido=resultado.getString("apellido");
                Date fechaNac = resultado.getDate("fecha_nac");
                int telefono=resultado.getInt("telefono");
                String busqueda_usuario_doctor = ("Bienvenido Administrador " + idAdministrador);
                JOptionPane.showMessageDialog(null, busqueda_usuario_doctor);
                obAdmi = new Administrador(idAdministrador, usuario, contraseña, nombre, apellido, telefono, fechaNac);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return obAdmi;
    }    
    @Override
    public int modificar(Connection cnctn, Persona prsn, ArrayList<Persona> al, Persona prsn1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrar(Connection conectar, String dni, Persona obOriginal, ArrayList<Persona> arrayPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrar(Connection conectar, Persona objetoRegistrar,ArrayList<Persona>arrayPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }       
    
}