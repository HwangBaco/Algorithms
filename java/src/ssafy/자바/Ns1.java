package ssafy.자바;

public interface Ns1 {
    int age = 10;
    public default void fun() {
        System.out.println("hello");
    };

    public default void print(int... params) {
        int[] arr = params;
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
