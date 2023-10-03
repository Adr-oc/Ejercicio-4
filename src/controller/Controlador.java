package controller;
import model.Especie;
import model.Dinosaurio;
import model.Mamifero;
import model.PlantaFossil;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Controlador {

    private List<Especie> especies = new ArrayList<Especie>();


    //Registrar nueva especie
    public void registrarEspecie(Especie especie) {
        especies.add(especie);
    }

    public void registrarDinosaurio(String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, int tipoDinosaurioInt, double tamañoEstimado, double pesoEstimado) {
        String tipoDinosaurio = "";
        if (tipoDinosaurioInt == 1) {
            tipoDinosaurio = "Carnívoro";
        } else if (tipoDinosaurioInt == 2) {
            tipoDinosaurio = "Herbívoro";
        } else if (tipoDinosaurioInt == 3) {
            tipoDinosaurio = "Omnívoro";
        }
        Dinosaurio dinosaurio = new Dinosaurio(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoDinosaurio, tamañoEstimado, pesoEstimado);
        registrarEspecie(dinosaurio);
    }

    public void registrarPlanta(String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String tipo, String periodoExistencia) {
        PlantaFossil plantaFossil = new PlantaFossil(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipo, periodoExistencia);
        registrarEspecie(plantaFossil);
    }
    public void registrarMamifero(String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String dieta, String habitat) {
        Mamifero mamifero = new Mamifero(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, dieta, habitat);
        registrarEspecie(mamifero);
    }


    //Mostrar todas las especies
    public List<Especie> mostrarEspecies() {
        return especies;
    }

    

    //Mostrar los tres dinosaurios más grandes
    public List<Especie> mostrarDinosauriosGrandes() {
        List<Especie> dinosauriosGrandes = new ArrayList<Especie>();
        for (Especie especie : especies) {
            if (especie instanceof Dinosaurio) {
                dinosauriosGrandes.add(especie);
            }
        }
        return dinosauriosGrandes.subList(0, 3);
    }

    
    //Mostrar especies segun descubridor
    public List<Especie> mostrarEspeciesDescubridor(String nombreDescubridor) {
        List<Especie> especiesDescubridor = new ArrayList<Especie>();
        for (Especie especie : especies) {
            if (especie.getNombreDescubridor().equals(nombreDescubridor)) {
                especiesDescubridor.add(especie);
            }
        }
        return especiesDescubridor;
    }

}