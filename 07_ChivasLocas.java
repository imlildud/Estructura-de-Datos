import java.util.*;

public class ChivasLocas{
    static int M, N, X;
    static int[][] corral;
    static int[] direccionx = {1, -1, 0, 0};
    static int[] direcciony = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce las medidas del corral:");
        M = tec.nextInt();
        N = tec.nextInt();
        System.out.println("Introduce la cantidad de chivas en el corral:");
        X = tec.nextInt();

        corral = new int[M][N];
        System.out.println("Introduce la posicion de las chivas:");
        for (int i = 0; i < X; i++) {
            int r = tec.nextInt();
            int c = tec.nextInt();

            corral[r][c] = 1;
        }

        int casos = tec.nextInt();
        for (int i=0; i<casos; i++) {
            int[][] tempCorral = new int[M][N];

            for (int j=0; j<M; j++) {
                System.arraycopy(corral[j], 0, tempCorral[j], 0, N);
            }

            int numRejas = tec.nextInt();
            System.out.println("Introduce la posicion de las rejas:");
            for (int j=0; j<numRejas; j++) {
                int r1 = tec.nextInt();
                int c1 = tec.nextInt();
                int r2 = tec.nextInt();
                int c2 = tec.nextInt();

                placeReja(tempCorral, r1, c1, r2, c2);
            }

            if (checkIsolation(tempCorral)){
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }
        }
    }
    private static void placeReja(int[][] corral, int r1, int c1, int r2, int c2){
        if (r1 == r2 && c1 == c2) return;
        int stepR = (r2 - r1) == 0 ? 0 : (r2 - r1) / Math.abs(r2 - r1);
        int stepC = (c2 - c1) == 0 ? 0 : (c2 - c1) / Math.abs(c2 - c1);

        int r = r1, c = c1;

        while (r != r2 || c != c2){
            corral[r][c] = -1;
            r += stepR;
            c += stepC;
        }
        corral[r2][c2] = -1;
    }
    private static boolean checkIsolation(int[][] corral){
        boolean[][] visited = new boolean[M][N];
        int chivaCount = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (corral[i][j] == 1 && !visited[i][j]){
                    chivaCount++;
                    if (chivaCount > X) return false;
                    bfs(corral, visited, i, j);
                }
            }
        }

        return chivaCount == X;
    }
    private static void bfs(int[][] corral, boolean[][] visited, int x, int y){
        Queue<int[]> fila = new LinkedList<>();
        fila.add(new int[] {x, y});
        visited[x][y] = true;

        while (!fila.isEmpty()) {
            int[] current = fila.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + direccionx[i];
                int ny = cy + direcciony[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && corral[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    fila.add(new int[] {nx, ny});
                }
            }
        }
    }
}
