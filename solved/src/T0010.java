import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T0010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][n];
        StringTokenizer st;
        int x = n-1;
        int y = n-1;
        int e = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    mat[x--][y] = e++;
                    if (x == -1) {
                        x = 0;
                    }
                } else {
                    mat[x++][y] = e++;
                    if (x == n) {
                        x = n-1;
                    }
                }
            }
            y--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
