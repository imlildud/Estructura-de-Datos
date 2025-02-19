import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaminoEnumerado {
    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce la cantidad de matrices");
        int numMat = tec.nextInt();
        tec.nextLine();

        for(int i = 0; i < numMat; i++){
            System.out.println("Introduce la medida: Fila Columna");
            String[] medida = tec.nextLine().split(" ");
            int fila = Integer.parseInt(medida[0]);
            int columna = Integer.parseInt(medida[1]);

            int matriz[][] = new int[fila][columna];

            for (int j = 0; j < fila; j++){
                System.out.println("Llena la matriz de numeros: 1, 2, 3, 4...");
                String[] datos = tec.nextLine().split(" ");
                for (int k = 0; k < columna; k++){
                    matriz[j][k] = Integer.parseInt(datos[k]);
                }
            }

            List<int[]> camino = buscarCamino(matriz);

            for (int[] coordenada : camino) {
                System.out.print(coordenada[0] + " " + coordenada[1] + " ");
            }
            System.out.println();
        }
        tec.close();
    }

    public static List<int[]> buscarCamino(int[][] matriz){
        int[] movFila = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] movColumna = {-1, 0, 1, 1, 1, 0, -1, -1};

        List<int[]> camino = new ArrayList<>();
        int fila = 0, columna = 0; // Iniciar desde (0,0)
        camino.add(new int[]{fila, columna});

        while(true){
            boolean encontrado = false;

            for(int i = 0; i < 8; i++){
                int nFila = fila + movFila[i];
                int nColumna = columna + movColumna[i];

                if(nFila >= 0 && nFila < matriz.length && nColumna >= 0 && nColumna < matriz[0].length){
                    if(matriz[nFila][nColumna] == matriz[fila][columna] + 1){
                        fila = nFila;
                        columna = nColumna;
                        camino.add(new int[]{fila, columna});
                        encontrado = true;
                        break;
                    }
                }
            }

            if(!encontrado){
                break;
            }
        }
        return camino;
    }
}
