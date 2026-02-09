public class ShippingCalculator {
    public double calcularSubtotal(double peso, int distancia, int servicio, boolean zonaRemota) {

        double total = 0;
        if (servicio == 1) {
            total = total + 50;
        } else {
            total = total + 90;
        }
        total = total + (peso * 12);

        if (distancia <= 50) {
            total = total + 20;
        } else if (distancia <= 200) {
            total = total + 60;
        } else {
            total = total + 120;
        }
        if (zonaRemota == true) {
            total = total + (total + 0.10);
        }
        return total;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}
