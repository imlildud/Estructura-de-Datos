import java.util.Scanner;

public class ReconocedorNumeros {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce la cantidad de numeros a reconocer");
        int cantNum = tec.nextInt();
        tec.nextLine();

        for (int i=0; i<cantNum; i++) {
            System.out.println("Escribe el numero");
            String numero = tec.nextLine().trim();

            if (VerificadorEntero(numero)) {
                System.out.println("ENT");
            } else if (VerificadorReal(numero)) {
                System.out.println("REA");
            } else {
                System.out.println("ERR");
            }
        }

        tec.close();
    }

    public static boolean VerificadorEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean VerificadorReal(String numero) {
        try {
            if (numero.contains(".") && numero.indexOf(".") == numero.lastIndexOf(".")) {
                Float.parseFloat(numero);
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
