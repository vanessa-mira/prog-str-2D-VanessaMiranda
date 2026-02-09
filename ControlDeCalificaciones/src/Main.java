import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        operador in = new operador();
        GradeService gs = new GradeService();

        String nombre;
        double p1, p2, p3;
        int asistencia;
        boolean entregoProyecto;

        nombre = in.leerTextoNoVacio(sc, "Nombre del alumno: ");
        p1 = in.leerDouble(sc, "Parcial 1: ", 0, 100);
        p2 = in.leerDouble(sc, "Parcial 2: ", 0, 100);
        p3 = in.leerDouble(sc, "Parcial 3: ", 0, 100);
        asistencia = in.leerInt(sc, "Asistencia (%): ", 0, 100);
        entregoProyecto = in.leerBoolean(sc, "Entrego proyecto (true/false): ");

        double promedio = gs.calcularPromedio(p1, p2, p3);
        double calificacionFinal = gs.calcularFinal(promedio, asistencia);
        String estado = gs.determinarEstado(calificacionFinal, asistencia, entregoProyecto);

        in.imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto,
                calificacionFinal, estado);

        sc.close();
    }
}