package impl;

import Clases.*;
import Interfaces.IbuscarPor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class buscarPorDni  implements IbuscarPor{
    @Override
    public DefaultTableModel buscarPor(Buscar objetoBuscar) {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");//objeto Data format               
        objetoBuscar.getArray_persona().stream().filter(persona -> (persona instanceof Doctor)).filter(persona -> (((Doctor) persona).getDNI().equalsIgnoreCase(objetoBuscar.getBuscarTexto()))).forEachOrdered(persona -> {
            String fecha_formateada = objSDF.format(((Doctor) persona).getFecha_naci());
            objetoBuscar.getModelo().addRow(new Object[]{((Doctor) persona).getDNI(),((Doctor) persona).getNombre(), ((Doctor) persona).getApellido(),fecha_formateada, ((Doctor) persona).getNumero(),  ((Doctor) persona).getDistrito(),((Doctor) persona).getUsuario(),((Doctor) persona).getContraseña()});
        });
        return objetoBuscar.getModelo();
    }            
}
