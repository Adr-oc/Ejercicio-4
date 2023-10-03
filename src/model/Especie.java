package model;
import java.util.Date;

public class Especie {

    //atributos
    private String nombreDescubridor;
    private Date fechaDecubrimiento;
    private String tipoEspecie;
    private String eraGeologica;
    private String ubicacionHallazgo;
    private String NombreEspecie;




    //constructor
    public Especie(String NombreEspecie,String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo) {
        this.NombreEspecie = NombreEspecie;
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
    public Date getFechaDecubrimiento() {
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
        public String getNombreEspecie() {
        return NombreEspecie;
    }


   
    
    //setters
    public void setNombreDescubridor(String nombreDescubridor) {
        this.nombreDescubridor = nombreDescubridor;
    }
    public void setFechaDecubrimiento(Date fechaDecubrimiento) {
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
     public void setNombreEspecie(String nombreEspecie) {
        NombreEspecie = nombreEspecie;
    }

}
