package 알고리즘연습.swea.알고리즘수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_규영이와인영이의카드게임 {
    private static final int PERSONAL_CARD_SIZE = 9;
    private static final int TOTAL_CARD_SIZE = 18;

    private static int win, lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {
            win = 0;
            lose = 0;
            st = new StringTokenizer(br.readLine());
            int visited = 0;
            int[] gyuCards = new int[PERSONAL_CARD_SIZE];
            int[] inCards = new int[PERSONAL_CARD_SIZE];

            for (int i = 0; i < PERSONAL_CARD_SIZE; i++) {
                int num = Integer.parseInt(st.nextToken());
                visited = visited | (1 << num);
                gyuCards[i] = num;
            }

            int idx = 0;
            for (int card = 1; card <= TOTAL_CARD_SIZE; card++) {
                if ((visited & (1 << card)) != 0) {
                    continue;
                }
                inCards[idx++] = card;
            }

            permutation(0, gyuCards, inCards);

            System.out.printf("#%d %d %d\n", tc, win, lose);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void permutation(int depth, int[] gyu, int[] in) {
        if (depth == PERSONAL_CARD_SIZE) {
            int score = 0;
            for (int i = 0; i < PERSONAL_CARD_SIZE; i++) {
                if (gyu[i] > in[i]) {
                    score += gyu[i] + in[i];
                } else if (gyu[i] < in[i]) {
                    score -= (gyu[i] + in[i]);
                }
            }
            if (score > 0) {
                win++;
            } else if (score < 0) {
                lose++;
            }
            return;
        }

        for (int i = depth; i < PERSONAL_CARD_SIZE; i++) {
            swap(depth, i, in);
            permutation(depth + 1, gyu, in);
            swap(depth, i, in);
        }
    }
}
