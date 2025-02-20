import java.util.Scanner;

public class PromedioRenglones {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce la cantidad de renglones:");
        int renglones = tec.nextInt();
        tec.nextLine();

        float suma = 0;
        int contadorNumeros = 0;

        for (int i = 0; i < renglones; i++) {
            System.out.println("Introduce una cadena de numeros enteros");
            String numeros = tec.nextLine();
            String[] numArray = numeros.split(" ");

            for (String num : numArray) {
                suma += Integer.parseInt(num);
                contadorNumeros++;
            }
        }

        int promedio = Math.round(suma / contadorNumeros);
        System.out.println("El promedio de la cadena es " + promedio);
    }
}
