package BLACKJACK;

import java.util.ArrayList;

public class Mano extends Mazo {
    private ArrayList<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int valorMano() {
        int valor = 0;
        int ases = 0; // Contador de ases

        for (Carta carta : cartas) {
            valor += carta.getValor();
            if (carta.getValor() == 11) { // Si es un as
                ases++;
            }
        }

        // Si la suma de las cartas es mayor a 21 y hay ases, restar 10 por cada as hasta que no se pase de 21
        while (valor > 21 && ases > 0) {
            valor -= 10;
            ases--;
        }

        return valor;
    }

    public boolean finDeJuego() {
        return valorMano() > 21;
    }

    public void pedirCarta(Mazo mazo) {
        Carta carta = mazo.solicitarCarta();
        cartas.add(carta);
    }

    @Override
    public String toString() {
        StringBuilder representacionCadena = new StringBuilder();
        for (Carta carta : cartas) {
            representacionCadena.append(carta).append("\n");
        }
        return representacionCadena.toString();
    }
}
