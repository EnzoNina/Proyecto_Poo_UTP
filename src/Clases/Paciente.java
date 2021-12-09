package Clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Paciente extends Persona {        
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    private boolean Espaciente;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //Constructores
    public Paciente(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, int Numero, Date fecha_naci) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
    }
    public Paciente() {
    }
    //Validacion
    public boolean getPaciente()
    {   
        return Espaciente=true;
    }    
    //Metodos implementados
    
    public String [] login(Connection conectar,String usuario, String contraseña){
        String DNI=null;//dni null
        String datosEnviar[] = new String[3];
        Connection conexion=conectar;//objeto conectar 
        try {
            String Buscando_paciente = ("SELECT dni,nombre,apellido FROM paciente WHERE contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(Buscando_paciente);//preparandpsentencia buscando
            resultado = sentencia_preparada.executeQuery();//botamos el resultado   
            if(resultado.next()){//si encuentra
                String Nombre_usuario = resultado.getString("nombre");
                String apellidoUsuario=resultado.getString("apellido");                
                DNI =resultado.getString("dni");
                datosEnviar[0]=DNI;
                datosEnviar[1]=Nombre_usuario;
                datosEnviar[2]=apellidoUsuario;
                String busqueda_usuario = ("Bienvenido " + Nombre_usuario + " " +apellidoUsuario);
                JOptionPane.showMessageDialog(null, busqueda_usuario);                                
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        return datosEnviar;
    }    
        
    @Override
    public int registrar(Connection conectar, Persona objetoRegistrar,ArrayList<Persona>arrayPersona) {
        Connection conexion=conectar;
        Paciente obPaciente=(Paciente) objetoRegistrar;
        int resul=-1;        
        try {
            sentencia_preparada = conexion.prepareStatement("INSERT INTO paciente VALUES (?,?,?,?,?,?,?)");//Intruccion para insertar valores
            sentencia_preparada.setString(1, objetoRegistrar.getDNI());
            sentencia_preparada.setString(2, objetoRegistrar.getUsuario());
            sentencia_preparada.setString(3, objetoRegistrar.getContraseña());
            sentencia_preparada.setString(4, objetoRegistrar.getNombre());
            sentencia_preparada.setString(5, objetoRegistrar.getApellido());
            String fecha=sdf.format(objetoRegistrar.getFecha_naci());
            sentencia_preparada.setString(6, fecha);
            sentencia_preparada.setString(7, String.valueOf(objetoRegistrar.getNumero()));
            resul=sentencia_preparada.executeUpdate();//Ejecutamos la sentencia escrita en el sql                                                
        } catch (Exception e) {
        }
        arrayPersona.add(obPaciente);
        return resul;//executeQuery devuelve una result set una tabla resultados,encambio  tabla del executeUpdate devuelve la cantidad de filas afectadas por nuestra instruccion         
    }

    
    @Override
    public int borrar(Connection conectar, String dni, Persona obOriginal, ArrayList<Persona> arrayPersona) {        
        Connection conexion=conectar;
        Paciente obBorrar=(Paciente) obOriginal;
        int reslt=-1;        
        try {
            sentencia_preparada=conexion.prepareStatement("delete from paciente where dni=?");
            sentencia_preparada.setString(1,dni);
            reslt=sentencia_preparada.executeUpdate();//devuelve el numero de lineas modificadas
        } catch (Exception e) {
            System.out.println(e);
        }
        int posicion=0;
        //Metodo para buscar la persona en el arrayList
        for (Persona persona : arrayPersona){
            posicion++;
            if(persona.getDNI().equals(obBorrar.getDNI())){
               break;
            }            
        } 
        arrayPersona.remove(posicion-1);
        return reslt;
    }

    
    @Override
    public int modificar(Connection conectar, Persona objetoModificar,ArrayList<Persona> arrayPersona,Persona objetoOriginal) {
        Connection conexion=conectar;
        Paciente obModificar=(Paciente) objetoModificar;
        Paciente obriginal=(Paciente) objetoOriginal;
        int rlt=-1;          
        try {
            //Sentencia para modificar los datos de la base de datos
            sentencia_preparada=conexion.prepareStatement("update paciente set nombre=?,apellido=?, fecha_nac=?,telefono=?,usuario=?,contraseña=? WHERE dni=?");
            sentencia_preparada.setString(1, objetoModificar.getNombre());
            sentencia_preparada.setString(2, objetoModificar.getApellido());
            String date =sdf.format(objetoModificar.getFecha_naci());//lo convierto a 02/05/2021 y lo actualizo
            sentencia_preparada.setString(3, date);
            sentencia_preparada.setString(4, String.valueOf(objetoModificar.getNumero())); 
            sentencia_preparada.setString(5, objetoModificar.getUsuario());
            sentencia_preparada.setString(6, objetoModificar.getContraseña());
            sentencia_preparada.setString(7, objetoModificar.getDNI());
            rlt=sentencia_preparada.executeUpdate();            
        } catch (Exception e) {
            System.out.println(e);
        }
        int posicion=0;        
        for (Persona persona : arrayPersona) {
            posicion++;
            if(persona.getDNI().equals(obriginal.getDNI())){
               break;
            }            
        }                        
        arrayPersona.set(posicion-1, obModificar);
        return rlt;
    }
    //Metodo para llenar la tabla de doctores
    public DefaultTableModel llenar(ArrayList<Persona>arrayList,DefaultTableModel tabla){
        //{"DNI","NOMBRE","APELLIDO","TELEFONO","FECHA NACIMIENTO","DISTRITO"};
        for (Persona persona : arrayList) {
            if(persona instanceof Doctor){
                String fecha_formateada = sdf.format(((Doctor) persona).getFecha_naci());                
                tabla.addRow(new Object[]{((Doctor) persona).getDNI(),((Doctor) persona).getNombre(),((Doctor) persona).getApellido(),((Doctor) persona).getNumero(),
                fecha_formateada,((Doctor) persona).getDistrito()});
                
            }
        }
        return tabla;
    }
//Metodos QUE REGISTRA CITA
    public boolean registrarCita(ArrayList<Cita> array_cita, Cita nuevaCita) {        
        boolean seEncontro = false;        
        for (Cita cita : array_cita) {  
            if (cita.getFecha_hora().equals(nuevaCita.getFecha_hora())) {                
                seEncontro = true;
            }            
        }
        if (seEncontro!=true) {            
            array_cita.add(nuevaCita);
        }
        return seEncontro;
    }      
}
    
    
    

