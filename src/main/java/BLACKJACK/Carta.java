
    package BLACKJACK;

    public class Carta {

        // Enumeración para los palos de las cartas
        enum Palo {
            TREBOL, DIAMANTES, CORAZONES, PICAS
        }


        private int numero; // Número de la carta (1-13)
        private Palo palo;   // Palo de la carta (Trebol, Diamantes, Corazones, Picas)

        // Constructor de la clase Carta
        public Carta(int numero, Palo palo) {
            // Validar que el número de la carta esté dentro del rango permitido (1-13)
            if (numero < 1 || numero > 13) {
                throw new IllegalArgumentException("El número de la carta debe estar entre 1 y 13.");
            }
            this.numero = numero;
            this.palo = palo;
        }

        // Métodos getter
        public int getNumero() {
            return numero;
        }


        public Palo getPalo() {
            return palo;
        }

        //  obtener el valor de la carta en el juego de Blackjack
        public int getValor() {
            if (numero == 1) {
                return 11; // Valor del As
            } else if (numero >= 10) {
                return 10; // Valor de las cartas con figura (J, Q, K)
            } else {
                return numero; // Valor de las cartas numéricas
            }
        }

        // mostrar el número de la carta
        public String mostrarNumero() {
            switch (numero) {
                case 1:
                    return "AS";
                case 11:
                    return "J";
                case 12:
                    return "Q";
                case 13:
                    return "K";
                default:
                    return String.valueOf(numero); // Mostrar número como string para los valores numéricos normales
            }
        }

        // Método toString para representar la carta como una cadena
        @Override

        public String toString() {
            return "[" + mostrarNumero() + " de " + palo + "]"; // Ahora incluye el palo de la carta
        }
    }






