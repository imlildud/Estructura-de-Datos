import java.util.*;

public class p312 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int n = Integer.parseInt(tec.nextLine());

        for (int i = 0; i < n; i++) {
            String expresion = tec.nextLine();
            System.out.println(evaluarParentesis(expresion) ? "correcto" : "incorrecto");
        }
    }

    private static boolean evaluarParentesis(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }
        return pila.isEmpty();
    }
}
