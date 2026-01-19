import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero = pedirNumero(sc);
        int resultado = sumar(numero);

        System.out.println("La suma de los numeros del 1 al " + numero + " es: " + resultado);

        sc.close();
    }

    public static int pedirNumero(Scanner sc) {
        System.out.print("Escribe un numero: ");
        int n = sc.nextInt();
        return n;
    }

    public static int sumar(int n) {
        int suma = 0;

        for (int i = 0; i < n; i = i + 1) {
            suma = suma + (i + 1);
        }

        return suma;
    }
}


