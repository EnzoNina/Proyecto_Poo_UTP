package Clases;

import Interfaces.IbuscarPor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Buscar {
    //Atributos
   private ArrayList<Persona> array_persona = new ArrayList<Persona>();//arreglo persona
   private ArrayList<Cita>array_cita=new ArrayList<Cita>();
   private DefaultTableModel modelo;//objeto defaulttable Model
   private String buscarTexto;   
   //Constructor
    public Buscar(DefaultTableModel modelo, String buscarTexto,ArrayList<Persona> array) {
        this.array_persona=array;//le envio el arreglo 
        this.modelo = modelo;    //el modelo 
        this.buscarTexto = buscarTexto;     //y el texto a buscar    
    }

    public Buscar() {
    }
    //Getter and Setter
    public ArrayList<Cita> getArray_cita() {
        return array_cita;
    }

    public void setArray_cita(ArrayList<Cita> array_cita) {
        this.array_cita = array_cita;
    }
    
    public ArrayList<Persona> getArray_persona() { //devuelve la lista
        return array_persona;
    }

    public void setArray_persona(ArrayList<Persona> array_persona) {
        this.array_persona = array_persona; //envio la lista
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
