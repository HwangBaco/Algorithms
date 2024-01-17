package ssafy.자바;

public class Main implements Ns1, Ns2{
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.name = "KIM";
        customer.age = 10;
        customer.address = "Seoul";
        Main main = new Main();
        main.print(1,2,3,4,5,6,7,8,9);
        int age1 = main.age;
        System.out.println(age);
    }

    @Override
    public void fun() {
        Ns1.super.fun();
    }

}
