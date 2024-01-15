package ssafy.과제;

public class Main {
    static void update(StringBuffer buffer) {
        buffer.append(" world");
        buffer = new StringBuffer("Hello");
        buffer.append(" Java");
        System.out.println("inside : " + buffer);
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        update(buffer);
        System.out.println("outside : " + buffer);  // 출력값: "Hello world"
    }

}
