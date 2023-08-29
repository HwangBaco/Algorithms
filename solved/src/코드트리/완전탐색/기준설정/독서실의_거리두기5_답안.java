package 코드트리.완전탐색.기준설정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 독서실의_거리두기5_답안 {
    public static int n;
    public static char[] seat;

    public static int getMinDist() {
        int minDist = n;
        // 둘 다 1인 곳에 대해
        // 모든 쌍을 조사하여, 그 중 가장 가까운 거리를 구합니다.
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                if(seat[i] == '1' && seat[j] == '1')
                    minDist = Math.min(minDist, j - i);

        return minDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n = Integer.parseInt(br.readLine());
        seat = br.readLine().toCharArray();

        int ans = 0;
        // 들어갈 위치를 일일이 정해보며
        // 그 상황에서 가장 가까운 사람간의 거리를 구해
        // 가능한 경우 중 최댓값을 계산합니다.
        for(int i = 0; i < n; i++) {
            if(seat[i] == '0') {
                // 비어있는 위치에 인원을 배치합니다.
                seat[i] = '1';
                // 가장 가까운 사람간의 거리를 구해 최댓값을 갱신해줍니다.
                ans = Math.max(ans, getMinDist());
                // 다시 채워졌던 값을 되돌려줍니다.
                seat[i] = '0';
            }
        }

        System.out.println(ans);
    }
}
