import java.util.Scanner;
public class Main {

    static Alumno[] alumnos= new Alumno[25];
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("----MENU----");
            System.out.println("1)Alta alumno");
            System.out.println("2)Buscar por ID");
            System.out.println("3)Actualizar promedio por ID (Solo activos)");
            System.out.println("4)Baja logica por ID");
            System.out.println("5)Listar activos");
            System.out.println("6)Reportes");
            System.out.println("0)Salir");
            System.out.println("Elige la opcion a realizar:");

            opcion = sc.nextInt();
            if (opcion == 1) {
                alta();
            }
            if (opcion == 2) {
                buscar();
            }
            if (opcion == 3) {
                actualizar();
            }
            if (opcion == 4) {
                baja();
            }
            if (opcion == 5) {
                listar();
            }
            if (opcion == 6) {
                reportes();
            }
        } while (opcion == 0);
    }


    static void alta() {
        System.out.print("ID:");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("El ID es invalido");
            return;
        }

        for (int ==0;
        i < alumnos.length;
        i++){
            Alumno a = alumnos[i];

            if (a != null && a.id == id) {
                System.out.println("ID repetido");
                return;
            }
        }

        System.out.print("Nombre:");
        String nombre = sc.nextLine();

        if (nombre.equals("")) {
            System.out.println("Nombre vacio");
            return;
        }
        System.out.print("Promedio:");
        double promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            return;
        }

        for (int i = 0, i<alumnos.length; i++){
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno guardado");
                return;
            }
        }
    }
    static void buscar() {
        System.out.print("ID:");
        int id = sc.nextInt();

        for (int i = 0; i < alumnos.length; i++) {
            Alumno a = alumnos[i];

            if (a != null && a.id == id && a.activo == true) {
                System.out.println("Nombre:" + a.nombre);
                System.out.println("Promedio:" + a.promedio);
                return;
            }
        }
        System.out.println("No encontrado");
    }

    static void actualizar() {
        System.out.print("ID:");
        int id = sc.nextInt();
        for (int i = 0; i < alumnos.length; i++) {
            Alumno a = alumnos[i];

            if (a != null && a.id == id && a.activo == true) {
                System.out.println("Nuevo promedio actualizado");
                double nuevo = sc.nextDouble();

                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio invalido");
                    return;
                }
                a.promedio = nuevo;
                System.out.println("promedio cambiado");
                return;
            }
        }
        System.out.println("No encontrado");
    }
    static void baja() {


        System.out.print("ID:");
        int id = sc.nextInt();

        for (int i = 0; i < alumnos.length; i++) {
            Alumno a = alumnos[i];

            if (a != null && a.id == id && a.activo == true) {

                a.activo = false;
                System.out.println("Baja realizada");
                return;
            }
        }
        System.out.println("No encontrado");
    }

    static void listar(){
        for (int i = 0; i < alumnos.length; i++) {
            Alumno a =alumnos[i];
            if (a != null && a.activo == true) {

                System.out.println(a.id + "")
            }

        }

        }





