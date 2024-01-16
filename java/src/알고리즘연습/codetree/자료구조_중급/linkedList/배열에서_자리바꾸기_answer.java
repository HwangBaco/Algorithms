package 알고리즘연습.codetree.자료구조_중급.linkedList;

import java.util.Scanner;

public class 배열에서_자리바꾸기_answer {

    public static final int MAX_N = 250005;

    // 한 노드를 나타내는 클래스입니다.
    static class Node {
        int id;
        Node prev, next;

        Node(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node[] nodes = new Node[MAX_N];

    // 두 노드를 연결해줍니다.
    public static void connect(Node s, Node e) {
        if (s != null)
            s.next = e;
        if (e != null)
            e.prev = s;
    }

    // 부분 배열의 위치를 바꿔줍니다.
    public static void swapSubarray(Node a, Node b, Node c, Node d) {
        // a, c의 이전 노드를 기록을 해둡니다.
        Node prevA = a.prev;
        Node prevC = c.prev;

        // a의 이전 노드는 c와 연결해줍니다.
        connect(prevA, c);

        // c의 이전 노드는 a와 연결해줍니다.
        connect(prevC, a);

        // b, d의 다음 노드를 기록해둡니다.
        Node nextB = b.next;
        Node nextD = d.next;

        // b의 다음 노드는 d와 연결해줍니다.
        connect(b, nextD);

        // d의 다음 노드는 b와 연결해줍니다.
        connect(d, nextB);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // N개의 노드를 생성합니다.
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node(i);

        // 1부터 N번 까지의 노드를 차례로 연결해줍니다.
        for (int i = 1; i < n; i++)
            connect(nodes[i], nodes[i + 1]);

        int q = sc.nextInt();

        // 연산을 진행합니다.
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            swapSubarray(nodes[a], nodes[b], nodes[c], nodes[d]);
        }

        // 연산이 끝나고 제일 앞에 있는 노드를 찾습니다.
        Node cur = nodes[1];
        while (cur.prev != null)
            cur = cur.prev;

        // 해당 노드부터 끝까지 출력을 합니다.
        while (cur != null) {
            System.out.print(cur.id + " ");
            cur = cur.next;
        }
    }
}
