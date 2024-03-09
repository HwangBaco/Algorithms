package 알고리즘연습.os;

import java.util.concurrent.Semaphore;

public class CountingSemaphore {
    private static int sum = 0;
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        System.out.println("초기 합계: " + sum);

        Thread producer = new Thread(CountingSemaphore::produce);
        Thread consumer = new Thread(CountingSemaphore::consume);

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
            try {
                semaphore.acquire(); // 세마포어 획득
                sum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // 세마포어 반환
            }
        }
    }

    private static void consume() {
        for (int i = 0; i < 100000; i++) {
            try {
                semaphore.acquire(); // 세마포어 획득
                sum--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // 세마포어 반환
            }
        }
    }
}
