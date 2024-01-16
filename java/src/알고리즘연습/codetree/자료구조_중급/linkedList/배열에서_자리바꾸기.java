package 알고리즘연습.codetree.자료구조_중급.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
* 알고리즘 문제 풀 때, 명심할 점
* 1. 절대 답지를 보고 배끼지 말 것. (아이디어만 이해하고, 스스로 풀 것)
* 2. 반드시 시간복잡도를 먼저 계산한 뒤, 유형을 타당하게 파악하고 로직을 구성할 것
* 3. 로직을 구성할 때에는 pseudo code를 반드시 짜볼 것
* */
public class 배열에서_자리바꾸기 {
        /*
        * 배열의 길이 N : 순차 연결리스트 초기화
        *
        * 두 노드 범위를 스왑하는 함수 만들어서 하면 됨
        *
        * */

        /*
        * ### 배열로 생성한 뒤, 해당되는 구간을 찾아서 swap하려고 한다면
        *
        * 1. 해당 구간을 순차탐색으로 발견
        * 2. 그 안에서 필요 길이만큼 다시 순차탐색
        * 3. 해당 배열의 숫자를 삭제한 뒤에, 뒤에 있는 모든 index를 다시 배열
        *
        * 여기까지만 봐도, 위치를 찾고, 그 상태에서 구간 길이만큼 다시 반복해야 하므로, n^2
        * -> n이 250,000 이므로 n^2 연산시 1000ms를 넘어감
        *
        * ### 숫자 저장 자료구조를 배열이 아닌 다른 구조를 채택해야 할듯
        * - 처음에는 정렬되어 있지만, 한 번만 swap 연산을 하더라도 비정렬 구조를 가져야 하므로,
        * tree 구조는 적합하지 않음
        * - 하지만 set은 중복을 허용해야 해서 안된다.
        * - 따라서 연결리스트라는 결론이 나왔다.
        *
        * 연결리스트로 할 경우, 해당 노드를 찾는 건 O(N)이지만, 그 이후에 swap연산은 O(1)
        * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Node> hm = new HashMap<>();
        Node prev = null;

        for (int i = 0; i <= n; i++) {
            Node node = new Node(null, null, i); // 맨 앞 노드
            hm.put(i, node);
            node.prev = prev;
            if (prev != null) {
                prev.next = node;
            }
            prev = node;
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Node aNode = hm.get(a);
            Node bNode = hm.get(b);
            Node cNode = hm.get(c);
            Node dNode = hm.get(d);

            swap(aNode, bNode, cNode, dNode);
        }
        Node tnode = hm.get(0);
        tnode = tnode.next;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    private static void swap(Node a, Node b, Node c, Node d) {
        if (a.prev != null) {
            a.prev.next = c;
        }
        if (c.prev != null) {
            c.prev.next = a;
        }
        if (b.next != null) {
            b.next.prev = d;
        }
        if (d.next != null) {
            d.next.prev = b;
        }

        
    }



    private static class Node implements Cloneable{
        private Node prev, next;
        private int data;
        private Node(Node prev, Node next, int data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

}
