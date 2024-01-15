package data_structure;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class Study_Stack {
    class Node {
        int data;
        Node next; // single linked list

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    class Stack {
        Node top;

        public Stack() {
            this.top = null;
        }

        public void push(int data) {
            // 입력된 데이터로 신규 노드를 생성하고, 기존의 마지막 노드는 다음 노드가 된다.
            this.top = new Node(data, this.top);
        }

        public int pop() {
            // top 노드의 값을 추출한다.
            int data = this.top.data;
            // top 노드를 갱신한다. (기존 top 제거)
            this.top = this.top.next;
            return data;
        }
    }


    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

    }
}
