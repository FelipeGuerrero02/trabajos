public class TIENDAROPA {
    public static void main(String[] args) {
        double precioCamiseta = 25.0;
        double precioPantalon = 30.0;
        double descuentoCamiseta = precioCamiseta * 0.15;
        double precioCamisetaConDescuento = precioCamiseta - descuentoCamiseta;
        double descuentoPantalon = precioPantalon * 0.15;
        double precioPantalonConDescuento = precioPantalon - descuentoPantalon;
        double descuentoAdicionalCamiseta = precioCamisetaConDescuento * 0.05;
        double precioSegundaCamiseta = precioCamisetaConDescuento - descuentoAdicionalCamiseta;
        double precioTotal = precioCamisetaConDescuento + precioPantalonConDescuento + precioSegundaCamiseta;
        System.out.println("Precio de la primera camiseta con descuento: $" + precioCamisetaConDescuento);
        System.out.println("Precio del pantalón con descuento: $" + precioPantalonConDescuento);
        System.out.println("Precio de la segunda camiseta con descuento adicional: $" + precioSegundaCamiseta);
        System.out.println("Precio total de ambas prendas: $" + precioTotal);
    }
}
