package 코드트리.자료구조_중급.linked_list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 연결리스트1 {
    public static void main(String[] args) throws IOException {
        /*
        * 탐색은 오래걸리지만 : O(N)
        * 삭제, 삽입이 O(1)의 시간만 걸림
        * */
        List<Node> ll = new ArrayList();
        
    }


    private static class Node {
        private int data;
        private Node prev, next;

        private Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

}
