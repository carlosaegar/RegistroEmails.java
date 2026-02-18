import java.util.HashSet;
import java.util.Scanner;

public class RegistroEmails {

    public static void main(String[] args) {
        // HashSet garantiza que no haya emails repetidos
        HashSet<String> setEmails = new HashSet<>();
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE EMAILS ÚNICOS ---");
            System.out.println("1: Registrar email nuevo");
            System.out.println("2: Mostrar todos los emails");
            System.out.println("3: Comprobar si un email existe");
            System.out.println("0: Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nuevo email: ");
                    String nuevoEmail = leer.nextLine().toLowerCase().trim();

                    // .add() devuelve 'false' si el elemento ya existe en el Set
                    if (setEmails.add(nuevoEmail)) {
                        System.out.println("Email registrado con éxito.");
                    } else {
                        System.out.println("Error: Email ya registrado.");
                    }
                    break;

                case 2:
                    if (setEmails.isEmpty()) {
                        System.out.println("No hay emails registrados.");
                    } else {
                        System.out.println("\n--- LISTA DE EMAILS ---");
                        for (String email : setEmails) {
                            System.out.println("- " + email);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Email a buscar: ");
                    String buscarEmail = leer.nextLine().toLowerCase().trim();

                    if (setEmails.contains(buscarEmail)) {
                        System.out.println("El email '" + buscarEmail + "' SÍ está registrado.");
                    } else {
                        System.out.println("El email '" + buscarEmail + "' NO se encuentra en la base de datos.");
                    }
                    break;

                case 0:
                    System.out.println("Cerrando sistema de registro...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        leer.close();
    }
}
