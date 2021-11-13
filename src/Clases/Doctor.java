package Clases;
import Interfaces.actividadesPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Doctor extends Persona implements actividadesPersona<Doctor>{   
    private String distrito;    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    //private Date Horario;
    public Doctor(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, Date fecha_naci, int Numero, String distrito) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
        this.distrito = distrito;
    }
    public Doctor() {
    }
    //Getter and Setter de distrito
    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    //Metodos implementados
    @Override
    public String login(Connection conectar,String usuario, String contraseña) {        
        Connection conexion=conectar;
        String dniDoctor=null;
        try {
            String sentencia_buscar = ("SELECT dni,nombre,apellido FROM doctor WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String busqueda_usuario_doctor = ("Bienvenido Doctor " + nombre + " " + apellido);//CREO UN OBJETO DOCTOR ESTE DESPUE LLAMO AL METODO CARAGARDATOSDELDOCTOR Y PORFIN LO COMPLETO Y ASI ESTE PUEDE FUNCIONAR 
                dniDoctor = resultado.getString("dni");
                JOptionPane.showMessageDialog(null, busqueda_usuario_doctor);                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dniDoctor;
    }

    @Override
    public int registrar(Connection conectar,Doctor objetoRegistrar) {
        Connection conexion=conectar;        
        int result=-1;
        try {
            PreparedStatement agregar= conexion.prepareStatement("insert into doctor values (?,?,?,?,?,?,?,?)");//Sentencia para insertar nuevos doctores
            agregar.setString(1, objetoRegistrar.getDNI());
            agregar.setString(2, objetoRegistrar.getUsuario());
            agregar.setString(3, objetoRegistrar.getContraseña());
            agregar.setString(4, objetoRegistrar.getNombre());
            agregar.setString(5, objetoRegistrar.getApellido());
            String fechaSt=sdf.format(objetoRegistrar.getFecha_naci());
            agregar.setString(6,fechaSt);
            agregar.setString(7,String.valueOf(objetoRegistrar.getNumero()));
            agregar.setString(8,objetoRegistrar.getDistrito());
            result=agregar.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int borrar(Connection conectar,String dni) {
        Connection conexion=conectar;
        int resul=-1;
        try {
            PreparedStatement eliminar=conexion.prepareStatement("delete from doctor where dni=?");
            eliminar.setString(1,dni);
            resul=eliminar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resul;
    }

    @Override
    public int modificar(Connection conectar,Doctor objetoModificar) {
        Connection conexion=conectar;
        int rst=-1;
        try {
            PreparedStatement editar=conexion.prepareStatement("update doctor set usuario=?,contraseña=?,nombre=?,apellido=?,fecha_nac=?,telefono=?,distrito=? WHERE dni=?");
            editar.setString(1, objetoModificar.getUsuario());
            editar.setString(2, objetoModificar.getContraseña());
            editar.setString(3, objetoModificar.getNombre());
            editar.setString(4, objetoModificar.getApellido());
            String fecha=sdf.format(objetoModificar.getFecha_naci());
            editar.setString(5, fecha);//fecha
            editar.setString(6, String.valueOf(objetoModificar.getNumero()));
            editar.setString(7, objetoModificar.getDistrito());                        
            editar.setString(8, objetoModificar.getDNI());
            rst=editar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rst;
    }
      
    //Metodos publicos
    public DefaultTableModel Busqueda_Atencion_Citas(ArrayList<Cita>array_cita,Date fecha,DefaultTableModel tablaModelo, String dniDoctor) throws ParseException {
        //buscar cita por fecha dentro del arrayList
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdtFH=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Cita cita : array_cita) {
            String parseada=sdt.format(cita.getFecha_hora());
            Date fechaFor =sdt.parse(parseada);
            if(fechaFor.equals(fecha) && dniDoctor.equals(cita.getDni_doctor())){
                String fechaHM=sdtFH.format(cita.getFecha_hora());
                tablaModelo.addRow(new Object[]{cita.getNro(),cita.getDni_paciente(),fechaHM});
            }
        }
        return tablaModelo;
    }
    public void llenarhistoriaClinica(ArrayList<historiaClinica> arrayHistoria,historiaClinica obHistoriaClinica){       
        arrayHistoria.add(obHistoriaClinica);
    }

}