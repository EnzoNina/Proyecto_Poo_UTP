package Clases;

import java.util.ArrayList;
import java.util.Date;

public class Cita {
    //Atributos
    private int nro;
    private String dni_doctor,dni_paciente;
    private boolean estado;
    private Date fecha_hora;
    //Constructor
    public Cita() {
    }
    
    public Cita(int nro, String dni_doctor, String dni_paciente, boolean estado, Date fecha_hora) {
        this.nro = nro;
        this.dni_doctor = dni_doctor;
        this.dni_paciente = dni_paciente;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
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

    public boolean isEstado() {
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
}
