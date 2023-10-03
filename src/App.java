import controller.Controlador;
import view.Vista;

public class App {
    public static void main(String[] args) throws Exception {
            Controlador controlador = new Controlador();
        Vista vista = new Vista();
        vista.clearScreen();
        while (true) {
            //Mostrar el menú
            vista.mostrarMenu();

            //Obtener la opción del usuario
            int opcion = vista.scanner.nextInt();
            
            //Procesar la opción
            switch (opcion) {
                case 1:
                    //Registrar nueva especie
                    vista.clearScreen();
                    vista.registrarEspecie(controlador);
                    break;
                case 2:
                    //Mostrar todas las especies
                    vista.clearScreen();
                    vista.mostrarEspecies(controlador);
                    break;
                case 3:
                    //Mostrar los tres dinosaurios más grandes
                    vista.clearScreen();
                    vista.mostrarDinosauriosGrandes(controlador);
                    break;
                case 4:
                    //Mostrar las especies por descubridor
                    vista.clearScreen();
                    vista.mostrarEspeciesDescubridor(controlador);
                    break;
                case 5:
                    //Salir
                    System.exit(0);
                    break;
                default:
                    //Opción no válida
                    vista.clearScreen();
                    System.out.println("Opción no válida");
            }
        }
    }
}