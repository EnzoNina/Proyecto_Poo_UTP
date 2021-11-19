package Clases;

import Interfaces.IbuscarCitaPor;
import Interfaces.IbuscarPor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class buscarCita {
    //Atributos
    private ArrayList<Cita>array_cita=new ArrayList<Cita>();
    private DefaultTableModel modelo;//objeto defaulttable Model
    private String buscarTexto;
    //Constructor
    public buscarCita(DefaultTableModel modelo, String buscarTexto,ArrayList<Cita> array) {
        this.modelo = modelo;
        this.buscarTexto = buscarTexto;
        this.array_cita=array;
    }
    //Getter and Setter
    public ArrayList<Cita> getArray_cita() {
        return array_cita;
    }

    public void setArray_cita(ArrayList<Cita> array_cita) {
        this.array_cita = array_cita;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public String getBuscarTexto() {
        return buscarTexto;
    }

    public void setBuscarTexto(String buscarTexto) {
        this.buscarTexto = buscarTexto;
    }
    //Metodo
    public DefaultTableModel buscarCitaPor(IbuscarCitaPor interfaceBuscar){
        return interfaceBuscar.buscarCitaPor(this);
    }
}
