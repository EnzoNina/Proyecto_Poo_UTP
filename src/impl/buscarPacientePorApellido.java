package impl;

import Clases.Buscar;
import Clases.Paciente;
import Clases.Persona;
import Interfaces.IbuscarPor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class buscarPacientePorApellido implements IbuscarPor{
    @Override
    public DefaultTableModel buscarPor(Buscar objetoBuscar) {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");//objeto Data format
        objetoBuscar.getArray_persona().stream().filter(persona -> (persona instanceof Paciente)).filter(persona -> (((Paciente) persona).getApellido().equalsIgnoreCase(objetoBuscar.getBuscarTexto()))).forEachOrdered(persona -> {
            String fecha_formateada = objSDF.format(((Paciente) persona).getFecha_naci());
            objetoBuscar.getModelo().addRow(new Object[]{((Paciente) persona).getDNI(), ((Paciente) persona).getNombre(), ((Paciente) persona).getApellido(),fecha_formateada, ((Paciente) persona).getNumero(), ((Paciente) persona).getUsuario(), ((Paciente) persona).getContraseña()});
        });
        return objetoBuscar.getModelo();
    }
    
}
