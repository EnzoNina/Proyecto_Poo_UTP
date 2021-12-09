package Clases;
import java.util.Date;

public class Cita {
    //Atributos
    private int nro;
    private String dni_doctor,dni_paciente;
    private boolean estado;
    private Date fecha_hora;
    private String nombredoctor,nombrepaciente;
    private String Apellidodoctor,Apellidopaciente;    
    //Constructor
    public Cita(){}    
    public Cita(int nro, String dni_doctor, String dni_paciente,String nombredoctor,String Apelldoctor,String nombrepaciente,String Apellpaciente, Date fecha_hora, boolean estado){
        this.nro = nro;
        this.dni_doctor = dni_doctor;
        this.dni_paciente = dni_paciente;
        this.nombredoctor=nombredoctor;
        this.nombrepaciente=nombrepaciente;
        this.Apellidodoctor=Apelldoctor;
        this.Apellidopaciente=Apellpaciente;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }        
    //Getter and Setter
        public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getDni_doctor() {
        return dni_doctor;
    }

    public void setDni_doctor(String dni_doctor) {
        this.dni_doctor = dni_doctor;
    }

    public String getDni_paciente() {
        return dni_paciente;
    }

    public void setDni_paciente(String dni_paciente) {
        this.dni_paciente = dni_paciente;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }         

    public String getNombredoctor() {
        return nombredoctor;
    }

    public void setNombredoctor(String nombredoctor) {
        this.nombredoctor = nombredoctor;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getApellidodoctor() {
        return Apellidodoctor;
    }

    public void setApellidodoctor(String Apellidodoctor) {
        this.Apellidodoctor = Apellidodoctor;
    }

    public String getApellidopaciente() {
        return Apellidopaciente;
    }

    public void setApellidopaciente(String Apellidopaciente) {
        this.Apellidopaciente = Apellidopaciente;
    }        
}
