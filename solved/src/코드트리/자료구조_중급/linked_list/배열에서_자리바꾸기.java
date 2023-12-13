package 코드트리.자료구조_중급.linked_list;

import java.io.IOException;

/*
* 알고리즘 문제 풀 때, 명심할 점
* 1. 절대 답지를 보고 배끼지 말 것. (아이디어만 이해하고, 스스로 풀 것)
* 2. 반드시 시간복잡도를 먼저 계산한 뒤, 유형을 타당하게 파악하고 로직을 구성할 것
* 3. 로직을 구성할 때에는 pseudo code를 반드시 짜볼 것
* */
public class 배열에서_자리바꾸기 {
    public static void main(String[] args) throws IOException {


    }

    void popRangeAndInsertPrev(Node s, Node e, Node v) {
        if (s.prev != null) {
            s.prev.next = e.next;
        }
        if (e.next != null) {
            e.next.prev = s.prev;
        }
        s.prev = e.next = null;

        if (v.prev != null) {
            s.next = v.prev;
        }
//        if ()
    }

    private class Node {
        private Node prev, next;
        private int data;
    }
}
