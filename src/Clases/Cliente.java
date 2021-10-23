package Clases;

import java.util.*;
import javax.swing.JOptionPane;

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

    public boolean registrarCita(ArrayList<Cita> array_cita, Cita nuevaCita) {
        boolean seEncontro = false;
        for (Cita cita : array_cita) {
            if (cita.getFecha_hora().equals(nuevaCita.getFecha_hora())) {
                JOptionPane.showMessageDialog(null, "No se pudo agendar la cita, debido a que la fecha y hora ingresada ya seta en uso");
                seEncontro = true;
            }            
        }
        if (seEncontro!=true) {
            System.out.println("No se encontro una cita con la misma fecha asi que se va a registrar");
            array_cita.add(nuevaCita);
        }
        return seEncontro;
    }
}
