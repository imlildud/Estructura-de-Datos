import java.util.Scanner;

class p337 {
    public static int ordenarConPilas(int[] numeros) {
        Pila principal = new Pila();
        Pila auxiliar = new Pila();
        int totalPushes = 0;

        for (int num : numeros) {
            while (!principal.isEmpty() && num > principal.peek()) {
                auxiliar.push(principal.pop());
                totalPushes++;
            }

            principal.push(num);
            totalPushes++;

            while (!auxiliar.isEmpty()) {
                principal.push(auxiliar.pop());
                totalPushes++;
            }
        }

        return totalPushes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilas = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < pilas; i++) {
            String[] valores = scanner.nextLine().split(" ");
            int[] numeros = new int[valores.length];

            for (int j = 0; j < valores.length; j++) {
                numeros[j] = Integer.parseInt(valores[j]);
            }

            int resultado = ordenarConPilas(numeros);
            System.out.println(resultado);
        }
    }
}

class Nodo {
    int valor;
    Nodo conector;

    public Nodo(int valor) {
        this.valor = valor;
        this.conector = null;
    }
}

class Pila {
    private Nodo tope;
    private int size;

    public Pila() {
        this.tope = null;
        this.size = 0;
    }

    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.conector = tope;
        tope = nuevoNodo;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        int valor = tope.valor;
        tope = tope.conector;
        size--;
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return tope.valor;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        Nodo actual = tope;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.conector;
        }
        System.out.println();
    }
}
