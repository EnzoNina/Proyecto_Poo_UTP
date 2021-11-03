package Clases;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Doctor extends Persona{
   
    private String distrito;
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
    public void Registrar() {
        
    }
    public void Ingresar() {
        //ACA QUE VAYA AL MENU 
    }
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