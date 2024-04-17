import java.util.*;

class PGS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        HashSet<Integer> set = new HashSet<>();
        for (int i : reserve) {
            set.add(i);
        }
        
        Arrays.sort(lost);
        
        boolean[] visited = new boolean[n + 1];
        
        for (int i : lost) {
            if (set.contains(i)) {
                set.remove(i);
                answer++;
                visited[i] = true;
            }    
        }
        
        for (int i : lost) {
            if (visited[i]) {
                continue;
            }
            if (set.contains(i-1)) {
                set.remove(i-1);
                answer++;
            } else if (set.contains(i+1)) {
                set.remove(i+1);
                answer++;
            }
        }
        
        
        return answer;
    }
}
