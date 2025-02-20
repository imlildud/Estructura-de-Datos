import java.util.Scanner;

public class p314 {
    public static final String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String mensaje = tec.nextLine().toLowerCase();
        tec.close();

        String[] palabras = mensaje.split(" ");

        for (int indice = 1; indice < 26; indice++) {
            StringBuilder mensajeTraducido = new StringBuilder();

            for (String palabra : palabras) {
                char[] letters = palabra.toCharArray();

                for (int i = 0; i < letters.length; i++) {
                    int originalIndex = alfabeto.indexOf(letters[i]);
                    if (originalIndex != -1) {
                        int newIndex = (originalIndex + indice) % 26;
                        letters[i] = alfabeto.charAt(newIndex);
                    }
                }
                mensajeTraducido.append(new String(letters)).append(" ");
            }

            if (!ConsonantesJuntas(mensajeTraducido.toString().trim())) {
                System.out.println(mensajeTraducido.toString().trim());
            }
        }
    }

    public static boolean ConsonantesJuntas(String palabra) {
        String vocales = "aeiou";

        for (int i = 0; i < palabra.length() - 1; i++) {
            char actual = palabra.charAt(i);
            char siguiente = palabra.charAt(i + 1);

            if (actual == ' ' || siguiente == ' ') {
                continue;
            }

            if (!vocales.contains("" + actual) && !vocales.contains("" + siguiente)) {
                return true;
            }
        }
        return false;
    }
}
