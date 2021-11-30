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
    
    public boolean getAdmi()
    {   
        return EsAdmi=true;           //aca en el login miraremos la situacion si se convierto en verdadeo ara algo
    }
    //Metodos publicos
    public int modificarCita(Connection conectar,ArrayList<Cita>arrayCita,Cita objetoCita,int nroCita,String dni_doctor,String dniPaciente,Date fechaHora,boolean estado){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Connection conexion=conectar;
        int rlt=-1;          
        try {
            //Sentencia para modificar los datos de la base de datos
            sentencia_preparada=conexion.prepareStatement("update cita set dni_doctor=?,dni_cliente=?,fecha_hora=?,estado=? WHERE nro_cita=?");
            sentencia_preparada.setString(1, dni_doctor);
            sentencia_preparada.setString(2, dniPaciente);
            String fecha=sdf.format(fechaHora);
            sentencia_preparada.setString(3, fecha);
            sentencia_preparada.setBoolean(4, estado);
            sentencia_preparada.setInt(5, objetoCita.getNro());
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
    public String[] login(Connection conectar, String usuario, String contraseña) {
        Connection conexion=conectar;
        String idAdministrador=null;
        String [] datos=new String[1];
        try {
            String sentencia_buscar = ("SELECT id,usuario,contraseña FROM Administrador WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {                                
                idAdministrador = resultado.getString("id");
                datos[0]=idAdministrador;
                String busqueda_usuario_doctor = ("Bienvenido Administrador " + idAdministrador);                
                JOptionPane.showMessageDialog(null, busqueda_usuario_doctor);                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }
    //Validacion      

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
    
    //metodo a implementar

    
    @Override
    public String buscandodni(Connection conectar, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}