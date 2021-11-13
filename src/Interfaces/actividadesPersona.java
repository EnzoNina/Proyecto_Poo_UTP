package Interfaces;

import java.sql.Connection;
public interface actividadesPersona<T> {
    public abstract String login(Connection conectar,String usuario, String contraseña);
    public abstract int registrar(Connection conectar,T objetoRegistrar);
    public abstract int borrar(Connection conectar,String Dni);
    public abstract int modificar(Connection conectar,T objetoModificar);  
}
