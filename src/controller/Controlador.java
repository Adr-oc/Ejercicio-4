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

    public void registrarDinosaurio(String nombreEspecie, String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, int tipoDinosaurioInt, double tamañoEstimado, double pesoEstimado) {
        String tipoDinosaurio = "";
        if (tipoDinosaurioInt == 1) {
            tipoDinosaurio = "Carnívoro";
        } else if (tipoDinosaurioInt == 2) {
            tipoDinosaurio = "Herbívoro";
        } else if (tipoDinosaurioInt == 3) {
            tipoDinosaurio = "Omnívoro";
        }
        Dinosaurio dinosaurio = new Dinosaurio(nombreEspecie,nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoDinosaurio, tamañoEstimado, pesoEstimado);
        registrarEspecie(dinosaurio);
    }

    public void registrarPlanta(String nombreEspecie,String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String tipo, String periodoExistencia) {
        PlantaFossil plantaFossil = new PlantaFossil(nombreEspecie, nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipo, periodoExistencia);
        registrarEspecie(plantaFossil);
    }
    public void registrarMamifero(String nombreEspecie,String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String dieta, String habitat) {
        Mamifero mamifero = new Mamifero(nombreEspecie, nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, dieta, habitat);
        registrarEspecie(mamifero);
    }


    //Mostrar todas las especies
    public List<Especie> mostrarEspecies() {
        return especies;
        
    }


    public List<Especie> mostrarDinosauriosGrandes() {
        List<Especie> dinosauriosGrandes = new ArrayList<Especie>();
        for (Especie especie : especies) {
            if (especie instanceof Dinosaurio) {
                dinosauriosGrandes.add(especie);
            }
        }
    
        // Encuentra el valor más grande
        Dinosaurio especieMasGrande = (Dinosaurio) dinosauriosGrandes.get(0);
        for (int i = 1; i < dinosauriosGrandes.size(); i++) {
            Dinosaurio dinosaurio = (Dinosaurio) dinosauriosGrandes.get(i);
            if (dinosaurio.getTamañoEstimado() > especieMasGrande.getTamañoEstimado()) {
                especieMasGrande = dinosaurio;
            }
        }
    
        // Coloca el valor más grande en el primer lugar
        dinosauriosGrandes.remove(especieMasGrande);
        dinosauriosGrandes.add(0, especieMasGrande);
    
        // Devuelve los tres primeros elementos de la lista
        return dinosauriosGrandes.subList(0, dinosauriosGrandes.size());
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