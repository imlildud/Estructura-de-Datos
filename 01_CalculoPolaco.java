import java.util.Scanner;
import java.util.Stack;

public class CalculoPolaco {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce el numero de operaciones a realizar: ");
        int entradas = Integer.parseInt(tec.nextLine().trim());

        for (int i = 0; i < entradas; i++) {
            System.out.println("Introduce la operacion en notacion polaca (x cantidad de numeros y x-1 cantidad de operadores");
            String linea = tec.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(evaluatePostfix(linea));
            }
        }
        tec.close();
    }

    public static String evaluatePostfix(String linea) {
        Stack<Integer> pila = new Stack<>();
        String[] datos = linea.split("\\s+");

        for (String dato : datos) {
            if (dato.matches("\\d+")) {
                pila.push(Integer.parseInt(dato));
            } else if ("+-*/>".contains(dato)) {
                if (pila.size() < 2) {
                    return "error";
                }
                double segundo = pila.pop();
                double primero = pila.pop();

                switch (dato) {
                    case "+":
                        pila.push((int) (segundo + primero));
                        System.out.println("Operacion: " + segundo + " + " + primero + " = " + (segundo + primero));
                        break;
                    case "-":
                        pila.push((int) (segundo - primero));
                        System.out.println("Operacion: " + segundo + " - " + primero + " = " + (segundo - primero));
                        break;
                    case "*":
                        pila.push((int) (segundo * primero));
                        System.out.println("Operacion: " + segundo + " * " + primero + " = " + (segundo * primero));
                        break;
                    case "/":
                        if (primero == 0) {
                            return "error";
                        }
                        pila.push((int) (segundo / primero));
                        System.out.println("Operacion: " + segundo + " / " + primero + " = " + (segundo / primero));
                        break;
                    case ">":
                        pila.push((int) Math.pow(segundo, primero));
                        System.out.println("Operacion: " + segundo + " ^ " + primero + " = " + Math.pow(segundo, primero));
                        break;
                    default:
                        return "error";
                }
            } else {
                return "error";
            }
        }
        return pila.size() == 1 ? String.valueOf(pila.pop()) : "error";
    }
}
