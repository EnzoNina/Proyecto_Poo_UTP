package Clases;

import java.util.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Persona {
    private String DNI;
    private String Usuario;
    private String Contraseña;
    private String Nombre;
    private String Apellido;    
    private int Numero;
    private Date fecha_naci;
//las personas de este sistema pueden ser el siguiente 
    private  boolean Esdoctor ; //primero son falsos 
    private boolean Espaciente=false;
    private boolean EsAdmi;
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
    
    
    //aca cambia de valor booleano cuando llame a este metodo 
    
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
    
    //Metodos
    public void Registrar(String DNI, String Usuario, String Contraseña, String Nombre, String Apellido, String Numero, String fecha_naci) {
        ResultSet resultado=null;
        try {                        
            /*PreparedStatement instruccion = conexion.prepareStatement("INSERT INTO paciente VALUES (?,?,?,?,?,?,?)");
            instruccion.setString(1, DNI);
            instruccion.setString(2, Usuario);
            instruccion.setString(3, Contraseña);
            instruccion.setString(4, Nombre);
            instruccion.setString(5, Apellido);
            instruccion.setString(6, fecha_naci);
            instruccion.setString(7, Numero);
            instruccion.executeUpdate();*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Ingresar() {
        // TODO implement here
    }
   
    

}
