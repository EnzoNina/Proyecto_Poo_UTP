package Clases;

import Interfaces.IbuscarPor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Buscar {
    //Atributos
   private ArrayList<Persona> array_persona = new ArrayList<Persona>();
   private DefaultTableModel modelo;
   private String buscarTexto;   
   //Constructor
    public Buscar(DefaultTableModel modelo, String buscarTexto,ArrayList<Persona> array) {
        this.array_persona=array;
        this.modelo = modelo;
        this.buscarTexto = buscarTexto;        
    }
    public Buscar() {
    }
    //Getter and Setter
    public ArrayList<Persona> getArray_persona() {
        return array_persona;
    }

    public void setArray_persona(ArrayList<Persona> array_persona) {
        this.array_persona = array_persona;
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
    //Buscar
    public DefaultTableModel buscarPor(IbuscarPor interfaceBuscar){
        return interfaceBuscar.buscarPor(this);
    }
}
