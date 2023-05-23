// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Containerschiff schiff = new Containerschiff("Berta", (short) 2500, 1500);

        schiff.beladen(10, true); // Belade 10 Container mit 20 TEU
        schiff.beladen(5, false); // Belade 5 Container mit 40 TEU

        System.out.println();
        System.out.println();
        }
    }
}