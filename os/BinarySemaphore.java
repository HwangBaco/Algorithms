package 알고리즘연습.os;

public class BinarySemaphore {
    private static int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("초기 합계: " + sum);

        Thread producer = new Thread(BinarySemaphore::produce);
        Thread consumer = new Thread(BinarySemaphore::consume);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("producer, consumer 스레드 실행 이후 합계: " + sum);
    }

    private static void produce() {
        for (int i = 0; i < 100000; i++) {
            synchronized (lock) { // 시작: 임계 구역
                sum++;
            } // 끝: 임계 구역
        }
    }

    private static void consume() {
        for (int i = 0; i < 100000; i++) {
            synchronized (lock) { // 시작: 임계 구역
                sum--;
            } // 끝: 임계 구역
        }
    }
}
