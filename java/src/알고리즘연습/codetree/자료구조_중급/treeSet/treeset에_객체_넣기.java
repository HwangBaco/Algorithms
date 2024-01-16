//package 코드트리.자료구조_중금.treeSet;
//
//public class treeset에_객체_넣기 {
//    public static void main(String[] args) {
//        TreeSet<Pair> s = new TreeSet<>();
//
//        s.add(new Pair(170, 60));
//        s.add(new Pair(160, 55));
//        s.add(new Pair(180, 82));
//        s.add(new Pair(185, 77));
//        s.add(new Pair(170, 30));
//    }
//    static class Pair implements Comparable<Pair> {
//        int height, weight;
//
//        public Pair(int height, int weight) {
//            this.height = height;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Pair p) {          // (키, 몸무게) 순 오름차순 정렬
//            if(this.height != p.height)         // 키가 다르다면
//                return this.height - p.height;  // 키를 기준으로 오름차순 정렬을 진행합니다.
//            else                                // 키가 같다면
//                return this.weight - p.weight;  // 몸무게 기준으로 오름차순 정렬을 진행합니다.
//        }
//    };
//}
