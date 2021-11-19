package Interfaces;

import Clases.Buscar;

import javax.swing.table.DefaultTableModel;

public interface IbuscarPor{
    public DefaultTableModel buscarPor(Buscar objetoBuscar);     //devuelve un JtableModel       
}                                                                 