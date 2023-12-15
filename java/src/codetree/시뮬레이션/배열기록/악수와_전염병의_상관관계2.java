package 코드트리.시뮬레이션.배열기록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 악수와_전염병의_상관관계2 {
    public static void main(String[] args) throws IOException {
        /*
        N명의 개발자
        T번에 걸쳐
        t초에 x개발자가 y개발자와 악수
        'K번의 악수' 동안만 전염병 옮김
        그 이후부터는 옮기지 않음
        처음 전염병에 걸려있는 개발자 번호 P

        입력
        N, K, P, T
        for range 0,T
        t, x, y에 대한 정보 입력

        출력
        개발자 순서대로 공백없이 감염여부 0, 1로 출력
        **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개발자 수
        int K = Integer.parseInt(st.nextToken()); // 전염악수 횟수
        int P = Integer.parseInt(st.nextToken()); // 최초 감염개발자 번호
        int T = Integer.parseInt(st.nextToken()); // 루프 크기

        // init chances
        int[] infectChances = new int[N];
        for (int i = 0; i < N; i++) {
            infectChances[i] = 2;
        }
        int[] infectedDevs = new int[N];

        int t, x, y;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

        }

    }
}
