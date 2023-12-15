package 코드트리.시뮬레이션.공간칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class T005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        /*
        1. n개의 숫자가 줄바꿈을 하면서 나열됨
        2. 한 숫자가 들어오면 부호 판별
        3. 불린 값으로 이전 값의 음양 판별
        4. 만약 꺽이면 지금까지 쌓인 cnt를 저장
        5. 최종 값으로 저장된 cnt list의 최대값 출력
        **/
        boolean isPrevPos = false;
        boolean isCurPos;
        int cnt = 0;
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if (i == 0) {
                isPrevPos = t > 0;
            } else {
                isCurPos = t > 0;
                if (isPrevPos == isCurPos) {
                    cnt++;
                } else {
                    li.add(++cnt);
                    cnt = 0;
                }
                isPrevPos = isCurPos;
            }
        }
        li.add(++cnt);
        Integer ans = li.stream().mapToInt(i -> i).max().orElseThrow(() -> new NoSuchElementException("no"));
        System.out.println(ans);
    }
}
