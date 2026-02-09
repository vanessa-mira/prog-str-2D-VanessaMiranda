import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        operador in = new operador();
        ShippingCalculator calc = new ShippingCalculator();

        double peso;
        int distancia;
        int servicio;
        boolean zonaRemota;

        peso = in.leerDouble(sc, "Ingrese el peso(kg):", 0.1 , 50.0);
        distancia = in.leerInt(sc, "Ingrese la distancia (Km):", 1 , 2000);
        servicio = in.leerInt(sc, "Servicio: 1) Estandar y 2)Express",1, 2);
        zonaRemota = in.leerBoolean(sc, "¿Es Zona Remota? (true / false):");

        double subtotal = calc.calcularSubtotal(peso, distancia, servicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal,iva);

        in.imprimirTicket(servicio,peso,distancia,zonaRemota,subtotal,iva,total);

        sc.close();
    }
}

