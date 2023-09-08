package 코드트리.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 아름다운_수 {
    private static int n;
    private static int ans = 0;
    private static List<Integer> li = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        choose(1);
        System.out.println(ans);
    }

    private static void choose(int x) {
        if (x == n + 1) {
            if (isBeautifulNum(li)) {
                ans++;
            }
            return;
        }
        x++;
        for (int k = 1; k <= 4; k++) {
            li.add(k);
            choose(x);
            li.remove(li.size() - 1);
        }
    }

    private static boolean isBeautifulNum(List<Integer> li) {
        for (int i = 0; i < li.size(); i++) {
            Integer elem = li.get(i);
            if (elem == 1) {
                continue;
            } else if (elem == 2) {
                if (inRange(i + 1)) {
                    Integer nextElem = li.get(i + 1);
                    if (elem.equals(nextElem)) {
                        i = i + 1;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (elem == 3) {
                if (inRange(i + 2)) {
                    Integer nextElem = li.get(i + 1);
                    Integer thirdElem = li.get(i + 2);
                    if (elem.equals(nextElem) && nextElem.equals(thirdElem)) {
                        i = i + 2;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (elem == 4) {
                if (inRange(i + 3)) {
                    Integer nextElem = li.get(i + 1);
                    Integer thirdElem = li.get(i + 2);
                    Integer fourthElem = li.get(i + 3);
                    if (elem.equals(nextElem) && nextElem.equals(thirdElem) && thirdElem.equals(fourthElem)) {
                        i = i + 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean inRange(int i) {
        return i >= 0 && i < n;
    }
}
