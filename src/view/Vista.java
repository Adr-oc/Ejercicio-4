package view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import controller.Controlador;
import model.Especie;
import model.Dinosaurio;
import model.Mamifero;
import model.PlantaFossil;

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
        scanner.nextLine();
        System.out.println("Registrar nueva especie");
        System.out.println("-----------------------------------");
        System.out.print("Ingrese el nombre del descubridor: ");
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
        System.out.print("Ingrese el nombre de la especie: ");
        String nombreEspecie = scanner.nextLine();
        System.out.print("Ingrese la era geológica: ");
        String eraGeologica = scanner.nextLine();

        System.out.print("Ingrese la ubicación del hallazgo: ");
        String ubicacionHallazgo = scanner.nextLine();
        
        switch (tipoEspecieint) {

            case 1: //Dinosaurio
                tipoEspecie = "dinosaurio";
                System.out.println("Ingrese el tipo de dinosaurio:");
                System.out.print("[1. carnívoro]  [2. herbívoro]  [3. omnívoro]: ");
                int tipoDinosaurioInt = scanner.nextInt();
                System.out.print("Ingrese el tamaño estimado [m] : ");
                double tamañoEstimado = scanner.nextDouble();
                System.out.print("Ingrese el peso estimado [kg] : ");
                double pesoEstimado = scanner.nextDouble();
                controlador.registrarDinosaurio(nombreEspecie,nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoDinosaurioInt, tamañoEstimado, pesoEstimado);
                break;


            case 2: //Mamíferos
                tipoEspecie = "mamífero primitivo";
                System.out.print("Ingrese la dieta: ");
                String dieta = scanner.nextLine();
                System.out.print("Ingrese el hábitat: ");
                String habitat = scanner.nextLine();

                controlador.registrarMamifero(nombreEspecie, nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, dieta, habitat);
                break;


            case 3: //Planta
                tipoEspecie = "planta fosil";
                System.out.print("Ingrese el tipo de planta: ");
                String tipoPlanta = scanner.nextLine();
                System.out.print("Ingrese el periodo de existencia: ");
                String periodoExistencia = scanner.nextLine();

                controlador.registrarPlanta(nombreEspecie,nombreDescubridor, fechaDecubrimiento, tipoEspecie, eraGeologica, ubicacionHallazgo, tipoPlanta, periodoExistencia);
                break;
            default:
                System.out.println("Tipo de especie no válido");
                break;
        }
    }

    public void mostrarEspecies(Controlador controlador) {
        clearScreen();
        System.out.println("-----------------------------------");
        System.out.println("Mostrar todas las especies");
        System.out.println("-----------------------------------");
        List<Especie> especies = controlador.mostrarEspecies();
        for (Especie especie : especies) {

            //Mostrar atributos de Especie
            System.out.println("Nombre de la especie: "+especie.getNombreEspecie());
            System.out.println("Tipo de especie: "+especie.getTipoEspecie());
            System.out.println("Nombre del descurbidor: "+especie.getNombreDescubridor());
            System.out.println("Fecha de descubrimiento: "+especie.getFechaDecubrimiento());
            System.out.println("Era geologica: "+especie.getEraGeologica());
            System.out.println("Ubicacion del hallazgo: "+especie.getUbicacionHallazgo());

            //Mostrar atributos de cada especie
            if (especie instanceof Dinosaurio) {
                Dinosaurio dinosaurio = (Dinosaurio) especie;
                System.out.println("Tipo de dinosaurio: "+dinosaurio.getTipo());
                System.out.println("Tamaño estimado: "+dinosaurio.getTamañoEstimado()+ " m");
                System.out.println("Peso estimado: "+dinosaurio.getPesoEstimado()+ " kg");
            } else if (especie instanceof Mamifero) {
                Mamifero mamifero = (Mamifero) especie;
                System.out.println("Dieta: "+mamifero.getDieta());
                System.out.println("Habitat: "+mamifero.getHabitat());
            } else if (especie instanceof PlantaFossil) {
                PlantaFossil plantaFossil = (PlantaFossil) especie;
                System.out.println("Tipo de planta: "+plantaFossil.getTipo());
                System.out.println("Periodo de existencia: "+plantaFossil.getPeriodoExistencia());
            }
            System.out.println("-----------------------------------");
            System.out.println();
        }
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public void mostrarDinosauriosGrandes(Controlador controlador) {
        List<Especie> especies = controlador.mostrarDinosauriosGrandes();
        for (int i = 0; i < especies.size() || i > 3; i++) {
            System.out.println((i + 1) + ". " + especies.get(i).getNombreEspecie());
        }
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }


    public void mostrarEspeciesDescubridor(Controlador controlador) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del descubridor: ");
        String nombreDescubridor = scanner.nextLine();

        System.out.println("Especies descubiertas por " + nombreDescubridor);
        List<Especie> especies = controlador.mostrarEspeciesDescubridor(nombreDescubridor);
        for (Especie especie : especies) {
            if (especie.getNombreDescubridor().equals(nombreDescubridor)) {
                System.out.println(especie.getTipoEspecie() + " | " + especie.getNombreEspecie());
            }
        }
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

}

 
