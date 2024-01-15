package data_structure;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // 요소를 앞쪽에 추가
        deque.addFirst("element1");
        deque.addFirst("element2");

        // 요소를 뒷쪽에 추가
        deque.addLast("element3");
        deque.addLast("element4");

        System.out.println("Initial Deque: " + deque); // Initial Deque: [element2, element1, element3, element4]

        // 앞쪽 요소 제거
        String removedFirst = deque.removeFirst();
        System.out.println("Removed from front: " + removedFirst); // Removed from front: element2

        // 뒷쪽 요소 제거
        String removedLast = deque.removeLast();
        System.out.println("Removed from back: " + removedLast); // Removed from back: element4

        System.out.println("Final Deque: " + deque); // [element1, element3]
        Queue<Integer> pq = new PriorityQueue<>();

    }
}
