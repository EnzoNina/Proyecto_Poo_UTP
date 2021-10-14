package Clases;
import java.util.*;

public class Doctor extends Persona{    
    private String distrito;
    //private Date Horario;
    public Doctor(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, Date fecha_naci, int Numero, String distrito) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
        this.distrito = distrito;
    }
    public Doctor() {
    }
    public void Registrar() {
        
    }
    public void Ingresar() {
        //ACA QUE VAYA AL MENU 
    }
    public void Busqueda_Atencion_Citas() {
        //buscar cita por fecha dentro del arrayList
    }

    public void Mantenimiento_historial_clinico() {
        
    }

}