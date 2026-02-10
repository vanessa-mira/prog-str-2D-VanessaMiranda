import java.util.Scanner;

public class Main {

    static Persona[] personas = new Persona[20];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    bajaLogica();
                    break;
                case 4:
                    listarActivas();
                    break;
                case 5:
                    actualizarNombre();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

    }

    static void mostrarMenu() {
        System.out.println("MENÚ");
        System.out.println("1) Alta");
        System.out.println("2) Buscar por ID");
        System.out.println("3) Baja lógica");
        System.out.println("4) Listar activas");
        System.out.println("5) Actualizar nombre");
        System.out.println("0) Salir");
        System.out.print("Elige una opción: ");
    }

    static void alta() {
        int id;
        String nombre;

        System.out.print("ID: ");
        id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("El ID debe ser mayor a 0");
            return;
        }

        if (existeId(id)) {
            System.out.println("Ese ID ya existe");
            return;
        }

        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío");
            return;
        }

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Persona registrada correctamente");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    static boolean existeId(int id) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    static void buscarPorId() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null &&
                    personas[i].getId() == id &&
                    personas[i].isActiva()) {

                System.out.println("Encontrada: " + personas[i]);
                return;
            }
        }

        System.out.println("No encontrada o inactiva");
    }

    static void bajaLogica() {
        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt();

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null &&
                    personas[i].getId() == id &&
                    personas[i].isActiva()) {

                personas[i].setActiva(false);
                System.out.println("Persona dada de baja");
                return;
            }
        }

        System.out.println("No encontrada o ya estaba inactiva");
    }

    static void listarActivas() {
        System.out.println("PERSONAS ACTIVAS");
        boolean hay = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].isActiva()) {
                System.out.println(personas[i]);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    static void actualizarNombre() {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null &&
                    personas[i].getId() == id &&
                    personas[i].isActiva()) {

                System.out.print("Nuevo nombre: ");
                String nuevo = sc.nextLine();

                personas[i].setNombre(nuevo);
                System.out.println("Nombre actualizado correctamente");
                return;
            }
        }

        System.out.println("No encontrada o inactiva");
    }
}