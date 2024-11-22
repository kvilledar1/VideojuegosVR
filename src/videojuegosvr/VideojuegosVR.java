
package videojuegosvr;

import java.util.Scanner;

public class VideojuegosVR {
   
       public static void main(String[] args) {
        VideojuegoManager manager = new VideojuegoManager();
        Scanner scanner = new Scanner(System.in);

        
        manager.agregar(new Videojuego(1, "Ejemplo: Call of Duty: Modern Warfare II", 69.99, "Shooter", "Xbox Series X"));

        
        while (true) {
            System.out.println("\n=== Sistema de Gestion de Videojuegos ===");
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuAdministrador(manager, scanner);
                    break;
                case 2:
                    menuCliente(manager, scanner);
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema!");
                    return;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        }
    }

    private static void menuAdministrador(VideojuegoManager manager, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Consultar lista de videojuegos");
            System.out.println("3. Buscar videojuego por genero");
            System.out.println("4. Actualizar precio de un videojuego");
            System.out.println("5. Eliminar videojuego por ID");
            System.out.println("6. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarVideojuego(manager, scanner);
                    break;
                case 2:
                    System.out.println("\n=== Lista de Videojuegos ===");
                    manager.consultar().forEach(System.out::println);
                    break;
                case 3:
                    buscarPorGenero(manager, scanner);
                    break;
                case 4:
                    actualizarVideojuego(manager, scanner);
                    break;
                case 5:
                    eliminarVideojuego(manager, scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        }
    }

    private static void menuCliente(VideojuegoManager manager, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Consultar lista de videojuegos");
            System.out.println("2. Buscar videojuego por genero");
            System.out.println("3. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Lista de Videojuegos ===");
                    manager.consultar().forEach(System.out::println);
                    break;
                case 2:
                    buscarPorGenero(manager, scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        }
    }

    private static void agregarVideojuego(VideojuegoManager manager, Scanner scanner) {
        System.out.println("\nEjemplo para ingresar un videojuego:");
        System.out.println("Nombre: Super Mario Odyssey");
        System.out.println("Precio: 49.99");
        System.out.println("Genero: Plataformas");
        System.out.println("Plataforma: Nintendo Switch");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese el nombre del videojuego: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del videojuego: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese el genero del videojuego: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la plataforma del videojuego: ");
        String plataforma = scanner.nextLine();

        manager.agregar(new Videojuego(0, nombre, precio, genero, plataforma));
    }

    private static void buscarPorGenero(VideojuegoManager manager, Scanner scanner) {
        System.out.print("Ingrese el genero a buscar: ");
        String genero = scanner.nextLine();
        Videojuego encontrado = manager.buscar(genero);
        if (encontrado != null) {
            System.out.println("Videojuego encontrado: " + encontrado);
        } else {
            System.out.println("No se encontraron videojuegos del genero especificado.");
        }
    }

    private static void actualizarVideojuego(VideojuegoManager manager, Scanner scanner) {
        System.out.print("Ingrese el ID del videojuego a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el nuevo nombre del videojuego: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del videojuego: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese el nuevo genero del videojuego: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la nueva plataforma del videojuego: ");
        String plataforma = scanner.nextLine();

        manager.actualizar(id, new Videojuego(id, nombre, precio, genero, plataforma));
    }

    private static void eliminarVideojuego(VideojuegoManager manager, Scanner scanner) {
        System.out.print("Ingrese el ID del videojuego a eliminar: ");
        int id = scanner.nextInt();
        manager.eliminar(id);
    }
   
   
        
}
