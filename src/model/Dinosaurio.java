package model;
import java.util.Date;


public class Dinosaurio extends Especie {

    //atributos
    private String tipo;
    private double tamañoEstimado;
    private double pesoEstimado;

    //constructor
    public Dinosaurio(String nombreDescubridor, Date fechaDescuento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String tipo, double tamañoEstimado, double pesoEstimado) {
            super(nombreDescubridor, fechaDescuento, tipoEspecie, eraGeologica, ubicacionHallazgo);
            this.tipo = tipo;
            this.tamañoEstimado = tamañoEstimado;
            this.pesoEstimado = pesoEstimado;
        }


    //getters
    public String getTipo() {
        return tipo;
    }
    public double getTamañoEstimado() {
        return tamañoEstimado;
    }
    public double getPesoEstimado() {
        return pesoEstimado;
    }


    //setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setTamañoEstimado(double tamañoEstimado) {
        this.tamañoEstimado = tamañoEstimado;
    }
    public void setPesoEstimado(double pesoEstimado) {
        this.pesoEstimado = pesoEstimado;
    }
}
