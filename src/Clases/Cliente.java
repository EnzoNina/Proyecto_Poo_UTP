package Clases;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class Cliente extends Persona {

    public Cliente(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, int Numero, Date fecha_naci) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
    }
    
    public Cliente() {
    }

    public void Registar() {
        // TODO implement here
    }

    public void Ingresar() {
        // TODO implement here
    }
    public DefaultTableModel buscar_doctor(DefaultTableModel tabla,ArrayList<Persona> array,String tipo,String textoString){        
        //Se puede hacer con extensibilidad
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd");//objeto Data format                
        if(tipo.equalsIgnoreCase("Nombre")){
            for (Persona persona : array) {
                if(persona.getNombre().equalsIgnoreCase(textoString)){
                    String fecha_formateada = objSDF.format(((Doctor)persona).getFecha_naci());
                    tabla.addRow(new Object[]{((Doctor)persona).getDNI(),((Doctor)persona).getNombre(),((Doctor)persona).getApellido(),((Doctor)persona).getNumero(),fecha_formateada,((Doctor)persona).getDistrito()});
                }
            }
            return tabla;
        }        
        /*}else if(tipo.equalsIgnoreCase("Apellido")){
            
        }else if(tipo.equalsIgnoreCase("DNI")){            
        }*/
        return null;
    }   
        
}