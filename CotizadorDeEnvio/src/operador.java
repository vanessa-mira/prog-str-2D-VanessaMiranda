import java.util.Scanner;
public class operador {

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
    public void imprimirTicket(int servicio, double peso, int distancia, boolean zonaRemota,
                               double subtotal, double iva, double total) {
        String tipo;
        if (servicio == 1) {
            tipo = "Estandar";
        } else {
            tipo = "Express";
        }
                System.out.println("TICKET");
                System.out.println("Servicio:" + tipo);
                System.out.println("Peso:" + peso + "Kg");
                System.out.println("Distancia:" + distancia + "Km");
                System.out.println("Zona Remota:" + zonaRemota);
                System.out.println("Subtotal:" + subtotal + "peso");
                System.out.println("IVA:" + iva + "pesos");
                System.out.println("TOTAL:"+ total + "pesos");
            }

        }


