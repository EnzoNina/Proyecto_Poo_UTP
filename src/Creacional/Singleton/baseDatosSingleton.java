package Creacional.Singleton;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class baseDatosSingleton{
    private String barra = File.separator;//Separador de ubicacion Direccion de la base de datos                                      
    private String url = System.getProperty("user.dir") + barra + "Datos" + barra + "consulta.db";//Get property sirve para obtener la ubicacion el proyecto    
    private static baseDatosSingleton conexion;
    private static Connection Conectar;
    //constructor    
    public baseDatosSingleton(){
        try {
            Class.forName("org.sqlite.JDBC");//Clase para corregir el error de la base de datos //este da a entender más la unión a la base de datos para que el prigrma nose paltee
            Conectar = DriverManager.getConnection("jdbc:sqlite:" + url, "root", "");//Hacemos conexion con la base de datos, el root es para entrar como administrador
            if (Conectar != null) {
                System.out.println("Conectado");//Si la conexcion es exitosa nos muestra el mensaje
            }
        } catch (Exception e) {
            Logger.getLogger(baseDatosSingleton.class.getName()).log(Level.SEVERE, null, e);
        }        
    }
    //Metodo
    public static baseDatosSingleton getConfigurador() {
        //si la instancia a sido creada
        if(conexion == null){
            conexion = new baseDatosSingleton();
        }
        return conexion;
    }
    //Getter and Setter
    public static Connection getConectar() {
        return Conectar;
    }
    public static void setConectar(Connection Conectar) {
        baseDatosSingleton.Conectar = Conectar;
    }
            
}
