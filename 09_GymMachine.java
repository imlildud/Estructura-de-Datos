import java.util.Scanner;

public class GymMachine {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de repeticiones a ingresar y cada cuantas cambiar peso");
        String[] datos = tec.nextLine().split(" ");
        int n = Integer.parseInt(datos[0]);
        int m = Integer.parseInt(datos[1]);

        int total = calcularPesoTotal(120, n, m, 1);
        System.out.println("El peso total cargado fue de: " + total + " kg");
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
