import java.util.Scanner;

public class MenuDeConversion{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        int cAF = 0; // Celsius a Fahrenheit
        int fAC = 0; // Fahrenheit a Celsius
        int kmAM = 0; // Km a Millas
        int mAK = 0; // Millas a Km

        int total = 0;

        do {


            System.out.println("MENU");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opcion: ");


            if (sc.hasNextInt()) {

                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= 5) {

                    if (opcion == 5) {
                        break;
                    }

                    double valor = pedirNumero(sc);

                    switch (opcion) {

                        case 1:
                            System.out.println("Celsius a Fahrenheit");
                            System.out.println("Resultado: " + (valor * 9 / 5 + 32));
                            cAF++;
                            total++;
                            break;

                        case 2:
                            System.out.println("Fahrenheit a Celsius");
                            System.out.println("Resultado: " + ((valor - 32) * 5 / 9));
                            fAC++;
                            total++;
                            break;

                        case 3:
                            System.out.println("Km a Millas");
                            System.out.println("Resultado: " + (valor * 0.621371));
                            kmAM++;
                            total++;
                            break;

                        case 4:
                            System.out.println("Millas a Km");
                            System.out.println("Resultado: " + (valor / 0.621371));
                            mAK++;
                            total++;
                            break;
                    }

                } else {
                    System.out.println("Opcion invalida (1-5)");
                }

            } else {
                System.out.println("Debes escribir un numero");
                sc.next(); // limpiar
            }

        } while (opcion != 5);


        System.out.println("RESUMEN");
        System.out.println("Total conversiones: " + total);
        System.out.println("C a F: " + cAF);
        System.out.println("F a C: " + fAC);
        System.out.println("Km a Millas: " + kmAM);
        System.out.println("Millas a Km: " + mAK);

        sc.close();
    }


    public static double pedirNumero(Scanner sc) {

        double num;

        while (true) {

            System.out.print("Ingresa el valor: ");

            if (sc.hasNextDouble()) {

                num = sc.nextDouble();
                return num;

            } else {

                System.out.println("No es numero");
                sc.next();
            }
        }
    }
}

