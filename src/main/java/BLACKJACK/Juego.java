package BLACKJACK;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Crear un mazo y barajarlo
            Mazo mazo = new Mazo();
            mazo.barajar();

            // Crear un mazo de cartas para el jugador
            Mano manoJugador = new Mano();

            // Pedir dos cartas al mazo y agregarlas a la mano del jugador
            manoJugador.pedirCarta(mazo);

            // Bucle principal del juego para pedir cartas
            while (true) {
                System.out.println("¿Quieres una carta? (si/no)");
                String respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    // Pedir una carta al mazo
                    manoJugador.pedirCarta(mazo);

                    // Mostrar la mano del jugador
                    System.out.println("Tu mano:");
                    System.out.println(manoJugador);

                    // Verificar si el jugador se ha pasado de 21
                    if (manoJugador.finDeJuego()) {
                        System.out.println("Te has pasado de 21. ¡Has perdido!");
                        break; // Salir del bucle si el jugador se pasa de 21
                    }
                } else if (respuesta.equalsIgnoreCase("no")) {
                    // El jugador decide no tomar más cartas
                    System.out.println("Te plantas con una puntuación de: " + manoJugador.valorMano());
                    break; // Salir del bucle si el jugador decide plantarse
                } else {
                    System.out.println("Respuesta no válida. Por favor, responde 'si' o 'no'.");
                }
            }

            // Mostrar la puntuación final del jugador
            int puntuacionFinal = manoJugador.valorMano();
            System.out.println("Tu puntuación final es: " + puntuacionFinal);

            // Determinar si el jugador gana
            if (puntuacionFinal <= 21) {
                System.out.println("¡Felicidades! Has ganado.");
            }

            // Crear una lista de cartas del jugador
            List<Carta> cartasJugador = new ArrayList<>(manoJugador.getCartas());

            // Crear una instancia de InformacionJuego con la información del juego
            InformacionJuego informacionJuego = new InformacionJuego(cartasJugador, puntuacionFinal, puntuacionFinal <= 21);

            // Crear un contexto JAXB para la clase InformacionJuego
            JAXBContext jaxbContext = JAXBContext.newInstance(InformacionJuego.class);

            // Crear un Marshaller para convertir el objeto Java a XML
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Constante que se debe formatear para mejorar legibilidad

            // Generar XML y guardarlo en un archivo
            File archivoXML = new File("informacion_juego.xml");
            marshaller.marshal(informacionJuego, archivoXML);
            System.out.println("Se ha generado el archivo XML 'informacion_juego.xml' con la información del juego.");
        } catch (JAXBException e) {
            System.out.println("Error al crear el archivo XML: " + e.getMessage());
        } finally {
            if (scanner != null) {   //Cerrar el escaner de forma que verifica que no es igual a null(no hay nada escrito)
                scanner.close();
            }
        }
    }
}
