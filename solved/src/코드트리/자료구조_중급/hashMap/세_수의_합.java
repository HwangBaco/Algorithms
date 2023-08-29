package 코드트리.자료구조_중급.hashMap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 세_수의_합 {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 원소의 개수
        k = Integer.parseInt(st.nextToken()); // 세 수의 합

        int[] arr = new int[n]; // 숫자 저장할 배열
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        /*
        analysis:
        n이 1000 이므로 2차원 루프를 사용해도 1,000,000(1백만) 이므로 가능 -> 경우의 수 완전탐색
        원소의 값이 충분히 크므로 숫자 등장 횟수를 관리하는 arr는 사용 불가 -> hashmap으로 관리
        **/
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = k - arr[i] - arr[j];
                if (map.containsKey(diff)) {
                    ans += map.get(diff);
                }
                if (map.containsKey(arr[i]) && map.containsKey(arr[j])) {
                    map.replace(arr[i], map.get(arr[i]) + 1);
                    map.replace(arr[j], map.get(arr[j]) + 1);
                } else if (map.containsKey(arr[i])) {
                    map.replace(arr[i], map.get(arr[i]) + 1);
                    map.put(arr[j], 1);
                } else if (map.containsKey(arr[j])) {
                    map.replace(arr[j], map.get(arr[j]) + 1);
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], 1);
                    map.put(arr[j], 1);
                }
            }
        }
        System.out.println(ans);



    }
}
