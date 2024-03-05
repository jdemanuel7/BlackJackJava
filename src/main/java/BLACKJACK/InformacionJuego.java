package BLACKJACK; // Paquete del proyecto

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement  //Elemento Raiz del documento
public class InformacionJuego {
    private List<Carta> cartasJugador; // Lista de cartas del jugador
    private int puntuacionFinal; // Puntuación final del jugador
    private boolean jugadorGana; // Indica si el jugador ganó o no

    public InformacionJuego() {
        // Constructor vacío requerido para JAXB (Java Architecture for XML Binding)
    }

    // Constructor con parámetros
    public InformacionJuego(List<Carta> cartasJugador, int puntuacionFinal, boolean jugadorGana) {
        this.cartasJugador = cartasJugador;
        this.puntuacionFinal = puntuacionFinal;
        this.jugadorGana = jugadorGana;
    }

    @XmlElement   //Elemento indicador  del documento XMl
    // Método para obtener la lista de cartas del jugador
    public List<Carta> getCartasJugador() {
        return cartasJugador;
    }

    // Método para establecer la lista de cartas del jugador
    public void setCartasJugador(List<Carta> cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

    @XmlElement
    // Método para obtener la puntuación final del jugador
    public int getPuntuacionFinal() {
        return puntuacionFinal;
    }

    // Método para establecer la puntuación final del jugador
    public void setPuntuacionFinal(int puntuacionFinal) {
        this.puntuacionFinal = puntuacionFinal;
    }

    @XmlElement
    // Método para verificar si el jugador ganó
    public boolean isJugadorGana() {
        return jugadorGana;
    }

    // Método para establecer si el jugador ganó o no
    public void setJugadorGana(boolean jugadorGana) {
        this.jugadorGana = jugadorGana;
    }
}
