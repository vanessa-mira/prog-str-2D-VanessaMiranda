import java.util.Scanner;
public class operador {

    public String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine();
        } while (texto.trim().isEmpty());
        return texto;
    }
    public double leerDouble(Scanner sc, String msg, double min, double max) {
        double num;
        do {
            System.out.print(msg);
            num = sc.nextDouble();
        } while (num < min || num > max);
        return num;
    }
    public int leerInt(Scanner sc, String msg, int min, int max) {
        int num;
        do {
            System.out.print(msg);
            num = sc.nextInt();
        } while (num < min || num > max);
        return num;
    }
    public boolean leerBoolean(Scanner sc, String msg) {
        boolean valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                break;
            } else {
                System.out.println("Solo escribe true o false.");
                sc.next();
            }
        }
        return valor;
    }
    public void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean proyecto,
                                double finalCal, String estado) {

        System.out.println("REPORTE FINAL");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entrego proyecto: " + proyecto);
        System.out.println("Calificacion final: " + finalCal);
        System.out.println("Estado: " + estado);
    }
}