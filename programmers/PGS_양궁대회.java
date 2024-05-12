import java.util.*;
class PGS_양궁대회 {
    int N;
    int max = 0;
    Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
       @Override
        public int compare(int[] a, int[] b) {
            for (int i = 10; i >= 0; i--) {
                if (a[i] != b[i]) {
                    return Integer.compare(b[i], a[i]);
                }
            }
            return 0;
        }
    });
    
    public int[] solution(int n, int[] info) {
        N = n;
        go(info, new int[11], 0, 0);
        return pq.size () > 0 ? pq.poll() : new int[] {-1};
    }
    public void go(int[] apeach, int[] lion, int depth, int cnt) {
        if (cnt == N) {
            int lionS = 0;
            int apeachS = 0;
            for (int i = 0; i < 10; i++) {
                if (apeach[i] == 0 && lion[i] == 0) {
                    continue;
                }
                if (apeach[i] < lion[i]) {
                    lionS += 10 - i;
                } else {
                    apeachS += 10 - i;
                }
            }
            if (max < lionS - apeachS) {
                max = (lionS - apeachS);
                pq.clear();
                pq.add(lion);
            } else if ((lionS - apeachS) == max && max != 0) {
                pq.add(lion);
            }
            return;
        }
        if (depth == 10) {
            lion[depth] = N - cnt;
            go(apeach, lion.clone(), depth, N);
            lion[depth] = 0;
            return;
        }
        if (cnt + apeach[depth] + 1 <= N) {
            lion[depth] = apeach[depth] + 1;
            go(apeach, lion.clone(), depth+1, cnt + lion[depth]);
            lion[depth] = 0;
        }
        go(apeach, lion.clone(), depth+1, cnt);
        
    }
}
