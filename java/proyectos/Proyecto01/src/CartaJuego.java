import java.util.ArrayList;
import java.util.List;

public class CartaJuego extends Carta {
    public CartaJuego(String valor, CartaFamilia familia) {
        super(valor, familia);
    }

    public static List<CartaJuego> crearBaraja() {
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        CartaFamilia[] familias = {CartaFamilia.CORAZONES, CartaFamilia.DIAMANTES, CartaFamilia.TREBOLES, CartaFamilia.PICAS};
        List<CartaJuego> baraja = new ArrayList<>();

        for (String valor : valores) {
            for (CartaFamilia familia : familias) {
                baraja.add(new CartaJuego(valor, familia));
            }
        }
        return baraja;
    }
}
