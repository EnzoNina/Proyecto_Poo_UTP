
package impl;


import Clases.Cita;
import Clases.buscarCita;
import Interfaces.IbuscarCitaPor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class buscarCitaDoctorDNI implements IbuscarCitaPor{

    @Override
    public DefaultTableModel buscarCitaPor(buscarCita objetoBuscar) {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy HH:mm");//objeto Data format
        objetoBuscar.getArray_cita().stream().filter(array_cita -> (array_cita.getDoctor().getDNI().equalsIgnoreCase(objetoBuscar.getBuscarTexto()))).forEachOrdered(array_cita -> {
            //Convertimos los fecha a un tipo String facil de leer
            String fecha=objSDF.format(array_cita.getFecha_hora());
            //Agregamos al modelo las filas con los datos encontrados
            objetoBuscar.getModelo().addRow(new Object[]{array_cita.getNro(),array_cita.getDoctor().getDNI(),array_cita.getDoctor().getNombre(),
                array_cita.getDoctor().getApellido(),array_cita.getPaciente().getDNI(),array_cita.getPaciente().getNombre(),array_cita.getPaciente().getApellido(),
                fecha,array_cita.getEstado()});
        });
        return objetoBuscar.getModelo();
    }
    
}
