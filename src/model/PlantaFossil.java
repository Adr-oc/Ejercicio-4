package model;
import java.util.Date;

public class PlantaFossil extends Especie {
    
        //atributos
        private String tipo;
        private String periodoExistencia;


        //constructor
        public PlantaFossil(String nombreDescubridor, Date fechaDecubrimiento, String tipoEspecie, String eraGeologica, String ubicacionHallazgo, String tipo, String periodoExistencia) {
            super(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo);
            this.tipo = tipo;
            this.periodoExistencia = periodoExistencia;
        }


        //getters
        public String gettipo() {
            return tipo;
        }
        public String getPeriodoExistencia() {
            return periodoExistencia;
        }



        //setters
        public void settipo(String tipo) {
            this.tipo = tipo;
        }
        public void setPeriodoExistencia(String periodoExistencia) {
            this.periodoExistencia = periodoExistencia;
        }


}
