import java.util.*;

class Solution {
    boolean[] visited = new boolean[1_000_000 + 1];
    List<Integer>[] edgeList = new ArrayList[1_000_000+1];
    int bar = 0;
    int donut = 0;
    int eight = 0;
    public int[] solution(int[][] edges) {
        int createdNode = getCreatedNode(edges);
        
        for (int i = 0; i <= 1_000_000; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            edgeList[a].add(b);
        }
        
        for (int next : edgeList[createdNode]) {
            go(next);
        }
        
        return new int[] {createdNode, donut, bar, eight};
    }
    public int getCreatedNode(int[][] edges) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> black = new HashSet<>();
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            black.add(b);
            if (hm.containsKey(b)) {
                hm.remove(b);
            }
            if (!black.contains(a)) {
                hm.put(a, hm.getOrDefault(a, 0) + 1);            
            }
            
        }
        int createdNode = -1;
        for (int k : hm.keySet()) {
            if (hm.get(k) >= 2) {
                createdNode = k;
                break;
            }
        }
        return createdNode;
    }
    public void go(int crt) {
       if (edgeList[crt].size() == 0) {
            bar++;
            return;
        }
        if (edgeList[crt].size() >= 2) {
            eight++;
            return;
        }
        for (int i : edgeList[crt]) {
            if (visited[i]) {
                donut++;
                return;
            }
            visited[i] = true;
            go(i);
        }
    }
    
}