package model;
import java.util.Date;

public class Mamifero extends Especie {
    
    //atributos
    private String dieta;
    private String habitat;
    
    //constructor
    public Mamifero(String nombreEspecie,String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String dieta, String habitat) {
        super(nombreEspecie,nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo);
        this.dieta = dieta;
        this.habitat = habitat;
    }


    //getters
    public String getDieta() {
        return dieta;
    }
    public String getHabitat() {
        return habitat;
    }


    //setters
    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

}
