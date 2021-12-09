package Clases;

import java.util.ArrayList;
import java.util.Date;

public class Cita {
    //Atributos
    private int nro;
    private boolean estado;
    private Date fecha_hora;
    private Doctor doctor;
    private Paciente paciente;

    //Constructor
    public Cita() {
    }

    public Cita(int nro, Doctor doctor, Paciente paciente, boolean estado, Date fecha_hora) {
        this.nro = nro;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    //Getter and Setter
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    //Metodo publico
    public Doctor obtenerDoctor(ArrayList<Persona> personas_array, String dniDoc) {
        Doctor obDocCita = null;
        for (Persona persona : personas_array) {
            if (persona instanceof Doctor && persona.getDNI().equalsIgnoreCase(dniDoc)) {
                obDocCita = new Doctor(((Doctor) persona).getDNI(), ((Doctor) persona).getUsuario(), ((Doctor) persona).getContraseña(), ((Doctor) persona).getNombre(),
                        ((Doctor) persona).getApellido(), ((Doctor) persona).getFecha_naci(), ((Doctor) persona).getNumero(), ((Doctor) persona).getDistrito());
            }
        }
        return obDocCita;
    }

    public Paciente obtenerPaciente(ArrayList<Persona> personas_array, String dniPaciente) {
        Paciente obPacCita = null;
        for (Persona persona : personas_array) {
            if (persona instanceof Paciente && persona.getDNI().equalsIgnoreCase(dniPaciente)) {
                obPacCita = new Paciente(((Paciente) persona).getDNI(), ((Paciente) persona).getUsuario(), ((Paciente) persona).getContraseña(), ((Paciente) persona).getNombre(),
                        ((Paciente) persona).getApellido(), ((Paciente) persona).getNumero(), ((Paciente) persona).getFecha_naci());
            }
        }
        return obPacCita;
    }
}
