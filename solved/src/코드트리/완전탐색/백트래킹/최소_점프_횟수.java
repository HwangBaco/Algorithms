package 코드트리.완전탐색.백트래킹;
import java.io.*;
import java.util.*;

public class 최소_점프_횟수 {
    /*
     * n이 주어지고
     * n개의 숫자가 주어진다.
     *
     * 1. 숫자를 입력받는다.
     * 2. 숫자를 맨 앞에서 하나를 확인한다.
         * 3-1. 우선, 현재 인덱스 + 해당 숫자 >= n이라면 return;
         * 3. 현재 인덱스로부터 해당 숫자만큼의 깊이로 재귀를 돌려서 가장 큰 숫자를 찾는다.
         * 4. 가장 큰 숫자로 점프하고 ans++를 수행한다.
         * 5. 현재 인덱스로부터 해당 숫자만큰의 깊이로 재귀를 돌려서 가장 큰 숫자를 찾는다...
         * 6. 가장 큰 숫자로 점프하고 ans++를 수행한다.
     * 7. print(ans);
     * */
    private static int n = 0;
    private static int[] arr;

    private static int currentIdx = 0;
    private static List<Integer> li = new ArrayList<>();
    private static int ans;
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (currentIdx != n) {
            go(currentIdx);
        }
        System.out.println(ans);
    }

    private static void go(int currentIdx) {
        int number = arr[currentIdx];
        if ((currentIdx + number) >= n) {
            ans++;
            return;
        }

        if (li.size() == number) {
            // 재귀는 경우의 수만 제공할 뿐.
            // pq에서 최대값 뽑아내놓고
            // li의 하나하나와 비교하여 최대값이면 그 인덱스로 currentIdx, number업데이트
            int maxVal = pq.peek();
            for (int i = 0; i < number; i++) {
                Integer temp = li.get(i);
                if (temp == maxVal) {
                    currentIdx = (i+1);
                }
            }
            ans++;
            return;
        }
        for (int i = 1; i <= number; i++) {
            li.add(arr[currentIdx + i]);
            pq.add(-arr[currentIdx + i]);
            go(currentIdx);
            li.remove(li.size() - 1);
            pq.remove(-arr[currentIdx + i]);
        }
    }

    private static boolean inRange(int idx) {
        return idx >= 0 && idx < n;
    }
}
