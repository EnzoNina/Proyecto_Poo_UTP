package Clases;

import java.util.*;
import javax.swing.JOptionPane;

public class Paciente extends Persona {

    public Paciente(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, int Numero, Date fecha_naci) {
        super(DNI, Usuario, Contraseña, Nombre, Apellido, Numero, fecha_naci);
    }

    public Paciente() {
    }

    public void Registar() {
        // TODO implement here
    }

    public void Ingresar() {
        // TODO implement here
    }

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
