package 알고리즘연습.codetree.자료구조_중급.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테디의_여행_플래너 {
    public static int n;
    public static int q;
    public static void main(String[] args) throws IOException {
        /*
        * 도시들의 수 n, 행동의 수 q
        *
        * n개의 도시 나열, 첫 번째 도시가 핀셋 도시
        *
        * q개의 행동 제시
        * 1 : 핀셋 도시를 오른쪽 인접 도시로 바꿈, 도시가 없으면 무시
        * 2 : 핀셋 도시를 왼쪽 인접 도시로 바꿈, 도시가 없으면 무시
        * 3 : 핀셋의 오른쪽 도시 스티커 제거(pop), 도시 없으면 무시
        * 4 : 핀셋 도시 오른쪽에 새로운 도시 추가
        *
        * 자료구조 : 수정에 유리한 구조 ~ 연결리스트
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        LinkedList cities = new LinkedList();
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            City city = new City(name);
            if (i == 0) {
                cities.head = city;
                cities.head.add(city);
                cities.tail = city;
                cities.size++;
                continue;
            }
            cities.tail.add(city);
            cities.tail = city;
            cities.size++;
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                cities.moveRight();
                cities.print();

            }
            if (command == 2) {
                cities.moveLeft();
                cities.print();

            }
            if (command == 3) {
                cities.popRight();
                cities.print();

            }
            if (command == 4) {
                String name = st.nextToken();
                cities.addAfterHead(new City(name));
                cities.print();
            }
        }
    }



    private static class City {
        private String name;
        private City prev, next;

        private City(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }

        private void add(City newCity) {
            // 이걸 사용할 때에는 linkedlist.tail.add(new City(name)) 을 활용하여 뒤에 이어붙이는 방식으로 활용
            if (this.next == null) { // tail 노드에 이어붙이는 경우
                this.next = newCity;
                newCity.prev = this;
                return;
            }
            // linkedlist.head.add()와 같이 중간에 insert 하는 경우
            City nextCity = this.next;
            nextCity.prev = newCity;
            newCity.next = nextCity;
            this.next = newCity;
            newCity.prev = this;
        }

        private void pop() {
            if (this.prev == null) { // head 노드를 pop 하는 경우
                City nextCity = this.next;
                nextCity.prev = null;
                this.next = null;
                return;
            }
            if (this.next == null) { // tail 노드를 pop 하는 경우
                City prevCity = this.prev;
                prevCity.next = null;
                this.prev = null;
                return;
            }
            City nextCity = this.next;
            City prevCity = this.prev;
            prevCity.next = nextCity;
            nextCity.prev = prevCity;
            this.next = this.prev = null;
        }
    }

    private static class LinkedList {
        private int size;
        private City head, tail;

        private LinkedList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        private void print() {
        if (size <= 1 || this.tail.name.equals(this.head.next.name)) {
            System.out.println(-1);
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(this.tail.name).append(" ").append(this.head.next.name);
            System.out.println(sb);
        }
        }

        private void addAfterHead(City city) { // cmd : 4
            if (size <= 1) {
                head.add(city);
                tail = city;
                size++;
                return;
            }
            head.add(city);
            size++;
        }

        private void moveRight() {
            if (size <= 1) {
                return;
            }
            City headCity = head;
            head = headCity.next;
            tail = headCity;
        }
        private void moveLeft() {
            if (size <= 1) {
                return;
            }
            City tailCity = tail;
            head = tailCity;
            tail = tailCity.prev;
        }
        private void popRight() {
            if (size == 0) {
                return;
            }
            if (size == 1) {
                head.pop();
                size--;
                return;
            }
            head.next.pop();
            size--;
        }
    }
}
