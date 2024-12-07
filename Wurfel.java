import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ein digitaler Würfel, der die Initiative auswürfelt.
 * Werte liegen zwischen 1-20.
 * Bestandteil für KEBOS.
 * Aktuelle Gegner: 2
 * Version: 1.0
 * @author Paul Sobek
 * Email: s86004@beuth-hochschule.de
 */

// Klasse Wurfel mit einem Würfel und Gegner-Logik
public class Wurfel {

    // Würfelklasse, generiert Zufallszahlen zwischen min und max
    public static class Wurf {
        private int min;
        private int max;
        private Random random;

        public Wurf(int min, int max) {
            this.min = min;
            this.max = max;
            this.random = new Random();
        }

        // Würfelwurf durchführen
        public int roll() {
            return random.nextInt((max - min) + 1) + min;
        }
    }

    // Klasse Gegner, speichert Name und Punktestand
    public static class Gegner {
        private String name;
        private int gegnerscore;

        public Gegner(String name) {
            this.name = name;
            this.gegnerscore = 0;
        }

        // Würfelwurf für den Gegner durchführen und den Score erhöhen
        public int rollDice(Wurf dice) {
            int roll = dice.roll();
            this.gegnerscore += roll;
            return roll;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return gegnerscore;
        }
    }

    // Main-Methode: Initialisierung der Gegner und Würfelwürfe
    public static void main(String[] args) {
        Wurf dice = new Wurf(1, 20);
        List<Gegner> gegnerList = new ArrayList<>();
        gegnerList.add(new Gegner("Gegner1"));
        gegnerList.add(new Gegner("Gegner2"));

        for (Gegner gegner : gegnerList) {
            int roll = gegner.rollDice(dice);
            System.out.println(gegner.getName() + " hat " + roll + " gewürfelt. Initiative: " + gegner.getScore());
        }
    }
}

            