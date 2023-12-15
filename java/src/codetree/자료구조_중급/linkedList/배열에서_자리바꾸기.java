package 코드트리.자료구조_중급.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 알고리즘 문제 풀 때, 명심할 점
* 1. 절대 답지를 보고 배끼지 말 것. (아이디어만 이해하고, 스스로 풀 것)
* 2. 반드시 시간복잡도를 먼저 계산한 뒤, 유형을 타당하게 파악하고 로직을 구성할 것
* 3. 로직을 구성할 때에는 pseudo code를 반드시 짜볼 것
* */
public class 배열에서_자리바꾸기 {
    public static void main(String[] args) throws IOException {

        /*
        * 배열의 길이 N : 순차 연결리스트 초기화
        *
        * 두 노드 범위를 스왑하는 함수 만들어서 하면 됨
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.toString());
        // 배열 초기화
        Node node = new Node(null, null, 1);
        for (int i = 1; i <= n; i++) {
        }

        int q = Integer.parseInt(st.toString());
        for (int i = 0; i < q; i++) {

        }
    }

    private static void swap(Node a, Node b, Node c, Node node) {

    }



    private static class Node {
        private Node prev, next;
        private int data;
        private Node(Node prev, Node next, int data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

}
