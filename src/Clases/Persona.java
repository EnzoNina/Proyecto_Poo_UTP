package Clases;

import Interfaces.actividadesPersona;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public abstract class Persona implements actividadesPersona<Persona>{
    private String DNI;
    private String Usuario;
    private String Contraseña;
    private String Nombre;
    private String Apellido;    
    private int Numero;
    private Date fecha_naci;
    //las personas de este sistema pueden ser el siguiente 
    private boolean Esdoctor=false ; //primero son falsos 
    private boolean Espaciente=false;
    private boolean EsAdmi=false;
    //Constructores
    public Persona() {
    }
    public Persona(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, int Numero, Date fecha_naci) {
        this.DNI = DNI;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Numero = Numero;
        this.fecha_naci = fecha_naci;
    }      
    //Getter and Setter
    //miramos las situaciones 
    public boolean getdoctor()
    {   
        return Esdoctor=true;
    }
    
    public boolean getAdmi()
    {   
        return EsAdmi=true;           //aca en el login miraremos la situacion si se convierto en verdadeo ara algo
    }
    public boolean getPaciente()
    {   
        return Espaciente=true;
    }        
    //aca cambia de valor booleano cuando llame a este metodi    
    public boolean isEsdoctor() {
         Esdoctor=true;
         return Esdoctor;
    }

    public void setEsdoctor(boolean Esdoctor) {
        this.Esdoctor = Esdoctor;
    }

    public boolean isEspaciente() {
        Espaciente=true;
        return Espaciente;
    }

    public void setEspaciente(boolean Espaciente) {
        this.Espaciente = Espaciente;
    }

    public boolean isEsAdmi() {
        EsAdmi=true;
        return EsAdmi;
    }

    public void setEsAdmi(boolean EsAdmi) {
        this.EsAdmi = EsAdmi;
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public Date getFecha_naci() {
        return fecha_naci;
    }

    public void setFecha_naci(Date fecha_naci) {
        this.fecha_naci = fecha_naci;
    }           
    //Metodos implementados
    @Override
    public Persona login(Connection conectar, String usuario, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrar(Connection conectar, Persona objetoRegistrar, ArrayList<Persona> arrayPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrar(Connection conectar, String dni, Persona obOriginal, ArrayList<Persona> arrayPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Connection conectar, Persona objetoModificar, ArrayList<Persona> arrayPersona, Persona objetoOriginal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
}
