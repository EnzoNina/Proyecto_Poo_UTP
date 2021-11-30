package Interfaces;

import java.sql.Connection;
import java.util.ArrayList;
public interface actividadesPersona<T> {
    public abstract String[] login(Connection conectar,String usuario, String contraseña);
    public abstract int registrar(Connection conectar,T objetoRegistrar,ArrayList<T>arrayPersona);
    public abstract int borrar(Connection conectar,String dni,T obOriginal,ArrayList<T>arrayPersona);    
    public abstract int modificar(Connection conectar, T objetoModificar,ArrayList<T> arrayPersona,T objetoOriginal);  
}
