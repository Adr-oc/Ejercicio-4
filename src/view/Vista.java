package view;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import controller.Controlador;
import model.Especie;

public class Vista {


    
    public Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    //clear screen
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mostrarMenu() {
        clearScreen();
        System.out.println("-----------------------------------");
        System.out.println("Menú de opciones");
        System.out.println("1. Registrar nueva especie");
        System.out.println("2. Mostrar todas las especies");
        System.out.println("3. Mostrar los tres dinosaurios más grandes");
        System.out.println("4. Mostrar las especies por descubridor");
        System.out.println("5. Salir");
        System.out.println("-----------------------------------");

    }



    public void registrarEspecie(Controlador controlador) {
        System.out.println("Registrar nueva especie");
        System.out.println("-----------------------------------");
        System.out.print("Ingrese el nombre del descubridor: ");
        scanner.nextLine();
        String nombreDescubridor = scanner.nextLine();

        //Fecha de descubrimiento
        System.out.print("Ingrese la fecha del descubrimiento (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDecubrimiento = new Date();
        //Parsear la fecha
        try {
            fechaDecubrimiento = formato.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Error en el formato de la fecha. Presione enter para continuar...");
            scanner.nextLine();
            return;
        }


        System.out.println("Ingrese el tipo de especie:");
        System.out.print("[1. dinosaurio]  [2. mamífero]  [3. plantaFossil]: ");
        int tipoEspecieint = scanner.nextInt();
        if (tipoEspecieint < 1 || tipoEspecieint > 3) {
            System.out.println("Tipo de especie no válido. Presione enter para continuar...");
            scanner.nextLine();
            return;
        }
        String tipoEspecie;
        scanner.nextLine();
        System.out.print("Ingrese la era geológica: ");
        String eraGeologica = scanner.nextLine();

        System.out.print("Ingrese la ubicación del hallazgo:");
        String ubicacionHallazgo = scanner.nextLine();
        
        switch (tipoEspecieint) {

            case 1: //Dinosaurio
                tipoEspecie = "dinosaurio";
                System.out.println("Ingrese el tipo de dinosaurio:");
                System.out.print("[1. carnívoro]  [2. herbívoro]  [3. omnívoro]]");
                int tipoDinosaurioInt = scanner.nextInt();
                System.out.print("Ingrese el tamaño estimado:");
                double tamañoEstimado = scanner.nextDouble();
                System.out.print("Ingrese el peso estimado:");
                double pesoEstimado = scanner.nextDouble();
                controlador.registrarDinosaurio(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoDinosaurioInt, tamañoEstimado, pesoEstimado);
                break;


            case 2: //Mamíferos
                tipoEspecie = "mamífero primitivo";
                System.out.print("Ingrese la dieta:");
                String dieta = scanner.nextLine();
                System.out.print("Ingrese el hábitat:");
                String habitat = scanner.nextLine();

                controlador.registrarMamifero(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, dieta, habitat);
                break;


            case 3: //Planta
                tipoEspecie = "planta fosil";
                System.out.print("Ingrese el tipo de planta:");
                String tipoPlanta = scanner.nextLine();
                System.out.print("Ingrese el periodo de existencia:");
                String periodoExistencia = scanner.nextLine();

                controlador.registrarPlanta(nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoPlanta, periodoExistencia);
                break;
            default:
                System.out.println("Tipo de especie no válido");
                break;
        }
    }

    public void mostrarEspecies(Controlador controlador) {
        clearScreen();
        System.out.println("Mostrar todas las especies:");
        List<Especie> especies = controlador.mostrarEspecies();
        for (Especie especie : especies) {
            System.out.println(especie);
        }
        System.out.println("Presione enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDinosauriosGrandes(Controlador controlador) {
        List<Especie> dinosaurios = controlador.mostrarDinosauriosGrandes();

        for (Especie dinosaurio : dinosaurios) {
            System.out.println(dinosaurio);
        }
    }

    public void mostrarEspeciesDescubridor(Controlador controlador) {
        System.out.println("Ingrese el nombre del descubridor:");
        String nombreDescubridor = scanner.nextLine();

        List<Especie> especies = controlador.mostrarEspeciesDescubridor(nombreDescubridor);

        for (Especie especie : especies) {
            System.out.println(especie);
        }
    }

}

 
