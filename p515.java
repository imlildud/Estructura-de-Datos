import java.util.Scanner;

public class p515 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String[] datos = tec.nextLine().split(" ");
        int n = Integer.parseInt(datos[0]);
        int m = Integer.parseInt(datos[1]);

        int total = calcularPesoTotal(120, n, m, 1);
        System.out.println(total + " kg");
    }

    public static int calcularPesoTotal(int peso, int reps, int m, int nivel) {
        if (peso < 60) {
            return 0;
        }
        int pesoLevantado = peso * 2 * reps;
        int nuevasReps = (nivel % 2 == 0) ? reps + m : reps;

        return pesoLevantado + calcularPesoTotal(peso - 5, nuevasReps, m, nivel + 1);
    }
}
