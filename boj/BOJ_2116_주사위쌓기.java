package 알고리즘연습.boj;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 맨 아래의 어떤 숫자를 고르고 그 숫자에 따라 연쇄적으로 나머지 주사위들의 숫자를 지운 뒤 최대값의 합을 출력
        // 시간제한이 최대 2초이므로 완탐을 노리고 있는 것으로 보인다.

        // 주사위들을 배열로 저장해둔다.
        // 첫 번째 주사위의 선택 숫자를 6으로 순회한다. (이는 윗 면을 어떤 걸로 할지를 선택하는 거라서 6까지 순회해야 함
        // 맨 아래 선택된 주사위에 따라 나머지 주사위의 숫자는 모두 정해짐, 남은 순자중 최대값을 탐색

        int N = Integer.parseInt(br.readLine());
        int[][] dices = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            int res = 0;
            int upperPlane = dices[0][i];
            int oppositePlane = dices[0][getOppositePlane(i)];
            res += Arrays.stream(dices[0])
                    .filter(o -> o != upperPlane && o != oppositePlane)
                    .max()
                    .getAsInt();
            int stdPlane = upperPlane;
            for (int j = 1; j < N; j++) {
                int idx = 0;
                for (int k = 0; k < 6; k++) {
                    if (dices[j][k] == stdPlane) {
                        idx = k;
                        break;
                    }
                }
                int uPlane = dices[j][idx];
                int oPlane = dices[j][getOppositePlane(idx)];
                res += Arrays.stream(dices[j])
                        .filter(o -> o != uPlane && o != oPlane)
                        .max()
                        .getAsInt();
                stdPlane = oPlane;
            }
            ans = Math.max(ans, res);
        }

        br.close();
        bw.write(sb.append(ans).toString());
        bw.flush();
        bw.close();
    }

    private static int getOppositePlane(int i) {
        if (i == 0 || i == 5) {
            return i == 0 ? 5 : 0;
        } else if (i == 1 || i == 3) {
            return i == 1 ? 3 : 1;
        } else if (i == 2 || i == 4) {
            return i == 2 ? 4 : 2;
        }
        return -1;
    }
}
