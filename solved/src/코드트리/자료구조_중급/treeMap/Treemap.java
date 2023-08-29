package 코드트리.자료구조_중급.treeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        // 정수 쌍을 관리할 treemap을 선언합니다.
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(5, 6);
        m.put(2, 2);
        m.put(10, 1);

        // Iterator를 이용한 map 컨테이너 내의 원소들 순회
        Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
        // key 기준 오름차순으로 순회하게 되므로
        // (2, 2), (5, 6), (10, 1) 순으로 출력됩니다.
        while(it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " +  entry.getValue());
        }
    }
}
