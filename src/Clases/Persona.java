package Clases;
import java.util.*;

public class Persona {    
    private String Usuario;
    private String Contraseña;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private int Numero;
    private Date fecha_naci;
    //Constructores
    public Persona() {
    }  
    public Persona(String Usuario, String Contraseña, String Nombre, String Apellido, String Direccion, int Numero, Date fecha_naci) {
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Numero = Numero;
        this.fecha_naci = fecha_naci;
    }  
    //Getter and Setter

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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
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
    public void Registrar() {
        // TODO implement here
    }

    public void Ingresar() {
        // TODO implement here
    }

}