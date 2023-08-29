package 코드트리.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀_나누기 {
    // 6명의 개발자를 3명씩 두 팀으로 짤 때,
    // 팀원간 능력 총합의 차이를 최소화 하는 것이 문제
    // 이 때, 팀이 두 개 이므로, 숫자를 3개 뽑아서 6명의 총합과의 차이를 구하면 두 팀의 역량이 나온다.
    private static int minValue = Integer.MAX_VALUE;
    private static int[] arr = new int[6];
    private static int sum = 0, a = 0, b = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                for (int k = j+1; k < 6; k++) {
                    checkMinValue(i, j, k);
                }
            }
        }
        System.out.println(minValue);
    }

    private static void checkMinValue(int i, int j, int k) {
        a = arr[i] + arr[j] + arr[k];
        b = sum - a;
        minValue = Math.min(팀_나누기.minValue, Math.abs(b - a));
    }
}
