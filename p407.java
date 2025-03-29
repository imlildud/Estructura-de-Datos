import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p407 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Cancion> canciones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String linea = scanner.nextLine().trim();
            String[] partes = linea.split(" ");
            String letra = partes[0];
            String[] tiempoPartes = partes[1].split(":");
            int minutos = Integer.parseInt(tiempoPartes[0]);
            int segundos = Integer.parseInt(tiempoPartes[1]);
            int duracionTotal = minutos * 60 + segundos;
            canciones.add(new Cancion(letra, duracionTotal));
        }

        List<String> parejas = new ArrayList<>();
        boolean[] emparejado = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (emparejado[i]) continue;
            int mejorIndice = -1;
            int mejorDiferencia = Integer.MAX_VALUE;
            int duracionCancion1 = canciones.get(i).duracion;

            for (int j = 0; j < n; j++) {
                if (i != j && !emparejado[j]) {
                    int duracionCancion2 = canciones.get(j).duracion;
                    int suma = duracionCancion1 + duracionCancion2;
                    int diferencia = Math.abs(180 - suma);

                    if (diferencia < mejorDiferencia) {
                        mejorDiferencia = diferencia;
                        mejorIndice = j;
                    }
                }
            }

            if (mejorIndice != -1) {
                parejas.add(canciones.get(i).letra + canciones.get(mejorIndice).letra);
                emparejado[i] = true;
                emparejado[mejorIndice] = true;
            }
        }

        System.out.println(String.join(",", parejas));
    }

    static class Cancion {
        String letra;
        int duracion;

        Cancion(String letra, int duracion) {
            this.letra = letra;
            this.duracion = duracion;
        }
    }
}
