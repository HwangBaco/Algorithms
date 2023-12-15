package 코드트리.자료구조_중급.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class treeset_개념 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        Integer e = 3;
        set.add(e); // 데이터 e 추가
        set.remove(e); // 데이터 e 제거
        set.contains(e); // 데이터 e 존재유무 확인

        /* treeset의 묘미 : 시간복잡도 O(logN) */
        set.ceiling(e); // 오름차순 정렬되었을 때, e보다 "같거나 큰" 최초의 숫자 '위치' 반환 : 없다면 null 반환
        set.floor(e); // 오름차순 정렬되었을 때, e보다 "같거나 작은" 최초의 숫자 '위치' 반환 : 없다면 null 반환

        set.higher(e); // 오름차순 정렬되었을 때, e보다 "큰" 최초의 숫자 '위치' 반환 : 없다면 null 반환
        set.lower(e); // 오름차순 정렬되었을 때, e보다 "작은" 최초의 숫자 '위치' 반환 : 없다면 null 반환

        set.first(); // 오름차순 정렬되었을 때, 가장 작은 숫자 반환
        set.last(); // 오름차순 정렬되었을 때, 가장 큰 숫자 반환
    }
}
