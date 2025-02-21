import java.util.*;

public class p406 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int numCasos = Integer.parseInt(tec.nextLine());
        List<String> resultados = new ArrayList<>();

        for(int i=0; i<numCasos; i++){
            Queue<int[]> Lista = new LinkedList<>();
            String[] datos = tec.nextLine().split(" ");

            for(int j=0; j< datos.length; j+=2){
                int prob = Integer.parseInt(datos[j]);
                int tiempo = Integer.parseInt(datos[j + 1]);
                Lista.add(new int[]{prob, tiempo});
            }

            int costo = 0;
            int totaltiempo = 0;

            while(!Lista.isEmpty()){
                int[] pieza = Lista.poll();
                int prob = pieza[0];
                int tiempo = pieza[1];

                costo += 50;
                totaltiempo += tiempo;

                if(prob < 85){
                    prob += 10;
                    Lista.add(new int[]{prob, tiempo});
                }
            }
            resultados.add(costo + " " + totaltiempo);
        }
        for(String resultado : resultados){
            System.out.println(resultado);
        }
    }
}
