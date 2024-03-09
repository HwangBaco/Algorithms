package 알고리즘연습.os;

public class Monitor {
    private static int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("초기 합계: " + sum);

        Thread producer = new Thread(Monitor::produce);
        Thread consumer = new Thread(Monitor::consume);

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
            synchronized (lock) {
                sum++;
                lock.notify(); // 이 코드를 수행하는 스레드가 다른 스레드에게 락이 해제되었음을 알림 (wait set에서 대기중인 스레드를 깨워서 다시 entry set에 넣어서 lock 획득을 기다리게 함)
                // notifyAll을 호출하면 wait set에 있는 모든 스레드를 깨워서 entry set에 넣어서 lock 획득을 기다리게 한다.
            }
        }
    }
    private static void consume() {
        for (int i = 0; i < 100000; i++) {
            synchronized (lock) {
                while(sum == 0) { // sum이 0인 경우 대기
                    try {
                        lock.wait(); // 이 코드를 수행하는 스레드는 monitor lock을 얻기 위해 대기 상태로 전환 (wait set으로 진입)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sum--;
            }
        }
    }
}
