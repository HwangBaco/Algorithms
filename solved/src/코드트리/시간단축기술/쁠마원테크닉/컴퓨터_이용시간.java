package 코드트리.시간단축기술.쁠마원테크닉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 컴퓨터_이용시간 {
    public static final int ARR_SIZE = 1000001;
    public static int n;
    public static void main(String[] args) throws IOException {
        /*
        * p와 q가 1,000,000이므로 배열을 선언한 뒤,
        * 각 구간별로 왼쪽, 오른쪽에 TreeMap에 +1/-1을 넣어두고
        * arr의 배열을 순회하며, idx == key일 때에 arr[idx] = arr[idx-1] + map.get(key)
        * else arr[idx] = arr[idx-1]
        * 그 이후 각 구간을 저장해둔 ArrayList를 순회하면서 arr[idx] 출력
        **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Integer> li = new ArrayList<>();
        int[] arr = new int[ARR_SIZE];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li.add(a);
            map.put(a, 1);
            map.put(b, -1);
        }
        for (Integer key : map.keySet()) {
            if (key - 1 >= 0) {
                arr[key] += map.get(key);
            }
        }
        for (int i = 1; i < ARR_SIZE; i++) {
            arr[i] += arr[i - 1];
//            if (arr[i] > 0) {
//                System.out.print(arr[i] + " ");
//            }
        }

        System.out.println(arr[59]);
        System.out.println(arr[60]);
        System.out.println(arr[61]);
//        for (Integer idx : li) {
//            System.out.print(arr[idx] + " ");
//
//        }
    }
}
