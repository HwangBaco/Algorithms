package data_structure;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 요소를 큐에 추가
        priorityQueue.offer(4);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(3);

        System.out.println("Initial PriorityQueue: " + priorityQueue); // Initial PriorityQueue: [1, 3, 2, 4]

        // 가장 우선순위가 높은 요소 제거
        Integer removedElement = priorityQueue.poll();
        System.out.println("Removed Element: " + removedElement); // Removed Element: 1

        System.out.println("PriorityQueue after removal: " + priorityQueue); // PriorityQueue after removal: [2, 3, 4]
    }
}

