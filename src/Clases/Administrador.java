package Clases;
import Interfaces.actividadesPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public class Administrador extends Persona implements actividadesPersona<Administrador> {
    //Atributos
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    private boolean EsAdmi=false;
    @Override
    public String login(Connection conectar, String usuario, String contraseña) {
        Connection conexion=conectar;
        String idAdministrador=null;
        try {
            String sentencia_buscar = ("SELECT id,usuario,contraseña FROM Administrador WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //condicion 
            if (resultado.next()) {                                
                idAdministrador = resultado.getString("id");
                String busqueda_usuario_doctor = ("Bienvenido Administrador " + idAdministrador);                
                JOptionPane.showMessageDialog(null, busqueda_usuario_doctor);                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return idAdministrador;
    }
    //Validacion 
     public boolean getAdmi()
    {   
        return EsAdmi=true;           //aca en el login miraremos la situacion si se convierto en verdadeo ara algo
    }
    @Override
    public int registrar(Connection conectar, Administrador objetoRegistrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrar(Connection conectar, String Dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Connection conectar, Administrador objetoModificar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo a implementar

    @Override
    public String buscandodni(Connection conectar, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}