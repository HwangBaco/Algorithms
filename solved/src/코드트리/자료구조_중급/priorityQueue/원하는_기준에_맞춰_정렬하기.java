package 코드트리.자료구조_중급.priorityQueue;

import java.io.IOException;

public class 원하는_기준에_맞춰_정렬하기{
    public static void main(String[] args) throws IOException {

    }

    public static class Pair implements Comparable<Pair>{
        private int x;
        private int y;

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.x == pair.x) {
                return this.y - pair.y;
            }
            return this.x - pair.y;
        }
    }


}
