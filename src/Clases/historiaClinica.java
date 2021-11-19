package Clases;

import java.util.Date;

public class historiaClinica {
    //Atributos
    private int nroHistoria;
    private String dniCliente;
    private String dniDoctor;
    private String Diagnostico;
    private String Receta;
    private Date Fecha;
    //Constructores    
    public historiaClinica(int nroHistoria, String dniCliente, String dniDoctor, String Diagnostico, String Receta, Date Fecha) {
        this.nroHistoria = nroHistoria;
        this.dniCliente = dniCliente;
        this.dniDoctor = dniDoctor;
        this.Diagnostico = Diagnostico;
        this.Receta = Receta;
        this.Fecha = Fecha;
    }        
    //Getter and Setter
    public int getnroHistoria() {
        return nroHistoria;
    }

    public void setnroHistoria(int nroCita) {
        this.nroHistoria = nroCita;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getReceta() {
        return Receta;
    }

    public void setReceta(String Receta) {
        this.Receta = Receta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }        
    public String getDniDoctor() {
        return dniDoctor;
    }

    public void setDniDoctor(String dniDoctor) {
        this.dniDoctor = dniDoctor;
    }    
}
