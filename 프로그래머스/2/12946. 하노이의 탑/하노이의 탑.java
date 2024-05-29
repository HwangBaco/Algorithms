import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};
        
        if (n == 1) {
            return new int[][]{{1,3}};
        } else if (n == 2) {
            return new int[][]{{1,2},{1,3},{2,3}};
        } else {
            answer = go(n);
        }
        
        
        return answer;
    }
    
    public int[][] go(int i) {
        int[][] tmp = new int[][]{{1,2},{1,3},{2,3}};
        List<int[]> next = new ArrayList<>();
        for (int j = 2; j < i; j++) {
            next.clear();
            for (int k = 0; k < tmp.length; k++) {
                int[] t = tmp[k].clone();
                System.out.println(t[0] + " " + t[1]);
                if (t[0] == 2) {
                    t[0] = 3;
                } else if (t[0] == 3) {
                    t[0] = 2;
                }
                if (t[1] == 2) {
                    t[1] = 3;
                } else if (t[1] == 3) {
                    t[1] = 2;
                }
                next.add(t);
            }            
            next.add(new int[]{1,3});
            for (int k = 0; k < tmp.length; k++) {
                int[] t = tmp[k].clone();
                if (t[0] == 1) {
                    t[0] = 2;
                } else if (t[0] == 2) {
                    t[0] = 1;
                }
                if (t[1] == 1) {
                    t[1] = 2;
                } else if (t[1] == 2) {
                    t[1] = 1;
                }
                next.add(t);
            }
   
            tmp = new int[next.size()][2];
            for (int k = 0; k < next.size(); k++) {
                tmp[k] = next.get(k);
            }
        }
        
        return tmp;
    }

}