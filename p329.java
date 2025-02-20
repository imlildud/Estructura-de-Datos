import java.util.Scanner;

public class p329 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int renglones = tec.nextInt();
        tec.nextLine();

        float suma = 0;
        int contadorNumeros = 0;

        for (int i = 0; i < renglones; i++) {
            String numeros = tec.nextLine();
            String[] numArray = numeros.split(" ");

            for (String num : numArray) {
                suma += Integer.parseInt(num);
                contadorNumeros++;
            }
        }

        int promedio = Math.round(suma / contadorNumeros);
        System.out.println(promedio);
    }
}
