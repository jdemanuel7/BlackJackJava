package BLACKJACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    // Lista que contiene las cartas en el mazo
    private ArrayList<Carta> cartas;

    // Constructor de la clase Mazo
    public Mazo() {
        cartas = new ArrayList<>();
        // Inicializar el mazo con todas las combinaciones de cartas
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas.add(new Carta(numero, palo));
            }
        }
    }

    // Método para barajar las cartas en el mazo
    public void barajar() {
        Collections.shuffle(cartas);
    }


    // Método para solicitar una carta del mazo
    public Carta solicitarCarta() {
        // Verificar si hay cartas en el mazo
        if (cartas.isEmpty()) {
            throw new IllegalStateException("No hay cartas en el mazo.");
        }
        // Retirar y devolver la primera carta del mazo
        return cartas.remove(0);
    }

    public String toString(){
        StringBuilder resultado = new StringBuilder();
        for (Carta carta :cartas){
            resultado.append(carta.toString()).append("\n");
        }
        return resultado.toString();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}












