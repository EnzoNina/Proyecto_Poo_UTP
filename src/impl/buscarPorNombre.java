package impl;
import Clases.Buscar;
import Clases.Doctor;
import Clases.Persona;
import Interfaces.IbuscarPor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class buscarPorNombre implements IbuscarPor {
    @Override
    public DefaultTableModel buscarPor(Buscar objetoBuscar) {
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd");//objeto Data format                        
        for (Persona persona : objetoBuscar.getArray_persona()){
            if(persona instanceof Doctor){
                if (((Doctor) persona).getNombre().equalsIgnoreCase(objetoBuscar.getBuscarTexto())) {
                    String fecha_formateada = objSDF.format(((Doctor) persona).getFecha_naci());
                    objetoBuscar.getModelo().addRow(new Object[]{((Doctor) persona).getDNI(), ((Doctor) persona).getNombre(), ((Doctor) persona).getApellido(), ((Doctor) persona).getNumero(), fecha_formateada, ((Doctor) persona).getDistrito()});
                }
            }
        }
        return objetoBuscar.getModelo();
    }
}
