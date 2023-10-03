package model;
import java.util.Date;

public class Especie {

    //atributos
    private String nombreDescubridor;
    private Date fechaDecubrimiento;
    private String tipoEspecie;
    private String eraGeologica;
    private String ubicacionHallazgo;


    //constructor
    public Especie(String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo) {
        this.nombreDescubridor = nombreDescubridor;
        this.fechaDecubrimiento = fechaDecubrimiento;
        this.tipoEspecie = tipoEspecie;
        this.eraGeologica = eraGeologica;
        this.ubicacionHallazgo = ubicacionHallazgo;
    }


    //getters
    public String getNombreDescubridor() {
        return nombreDescubridor;
    }
    public Date getFechaDescuento() {
        return fechaDecubrimiento;
    }
    public String getTipoEspecie() {
        return tipoEspecie;
    }
    public String getEraGeologica() {
        return eraGeologica;
    }
    public String getUbicacionHallazgo() {
        return ubicacionHallazgo;
    }
    
    
    //setters
    public void setNombreDescubridor(String nombreDescubridor) {
        this.nombreDescubridor = nombreDescubridor;
    }
    public void setFechaDescuento(Date fechaDecubrimiento) {
        this.fechaDecubrimiento = fechaDecubrimiento;
    }
    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }
    public void setEraGeologica(String eraGeologica) {
        this.eraGeologica = eraGeologica;
    }
    public void setUbicacionHallazgo(String ubicacionHallazgo) {
        this.ubicacionHallazgo = ubicacionHallazgo;
    }
    
}
