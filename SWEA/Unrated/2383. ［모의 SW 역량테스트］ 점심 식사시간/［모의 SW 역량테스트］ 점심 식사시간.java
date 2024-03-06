import java.io.*;
import java.util.*;

public class Solution {
    private static int N;
    private static int personCnt;
    private static ArrayList<int[]> peoplePos = new ArrayList<>();
    private static int[][] stairs;
    private static int res;
    private static final int DEPTH = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            res = (int) 1e9;
            personCnt = 0;
            peoplePos = new ArrayList<>();
            stairs = new int[2][3]; // 2개 * (y, x, depth)
            N = Integer.parseInt(br.readLine());

            int stairsIdx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        personCnt++;
                        peoplePos.add(new int[]{i, j});
                    } else if (num >= 2) { // 2 이상은 계단 입구
                        stairs[stairsIdx++] = new int[]{i, j, num}; // num == 깊이
                    }
                }
            }
            // 부분집합 사용 (A계단 or B 계단
            powerSet(0, new boolean[personCnt]);

            sb.append(String.format("#%d %d\n", tc, res));
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static void powerSet(int depth, boolean[] selected) {
        if (depth == personCnt) {
//            System.out.println("=======");
//            for (int i = 0; i < personCnt; i++) {
//                if (selected[i]) {
//                    System.out.println(i);
//                }
//            }
//            System.out.println("-");
            HashMap<Integer, Integer> aTeam = new HashMap<>();
            HashMap<Integer, Integer> bTeam = new HashMap<>();

            // 사람 순회하면서 팀 나눠두고
            for (int i = 0; i < personCnt; i++) {
                int[] pos = peoplePos.get(i);
                int py = pos[0];
                int px = pos[1];
                int[] stair = stairs[selected[i] ? 0 : 1];
                int sy = stair[0];
                int sx = stair[1];

                if (selected[i]) {
                    aTeam.put(i, Math.abs(py - sy) + Math.abs(px - sx));
                } else {
                    bTeam.put(i, Math.abs(py - sy) + Math.abs(px - sx));
                }
            }
            int passCnt = 0;
            int aStairCnt = 0; // 세마포어
            int bStairCnt = 0; // 세마포어
            int time = 0;
            boolean[] pass = new boolean[personCnt];
            while (passCnt < personCnt) {
                time++;
                Queue<Integer> waitQ = new ArrayDeque<>();
                for (int i = 0; i < personCnt; i++) {
                    if (pass[i]) {
                        continue;
                    }
                    if (selected[i]) {
                        // 계단 도착 인원이라면
                        if (aTeam.get(i) == 0) {
                            // 이미 계단이 만석이면
                            if (aStairCnt >= 3) {
                                // 못내려감
                                waitQ.add(i);
                                continue;
                            }
//                            System.out.println(aStairCnt);
                            aStairCnt++;
                        }
                        aTeam.put(i, aTeam.get(i) - 1);
                        if (aTeam.get(i) < 0 && (Math.abs(aTeam.get(i))) == stairs[0][DEPTH] + 1) {
                            aStairCnt--;
                            pass[i] = true;
                            passCnt++;
                        }
                    } else { // b 계단
                        // 계단 도착 인원이라면
                        if (bTeam.get(i) == 0) {
                            // 이미 계단이 만석이면 잠시대기
                            if (bStairCnt >= 3) {
                                waitQ.add(i);
                                continue;
                            }
//                            System.out.println(bStairCnt);
                            bStairCnt++;
                        }
                        bTeam.put(i, bTeam.get(i) - 1);
                        if (bTeam.get(i) < 0 && (Math.abs(bTeam.get(i))) == stairs[1][DEPTH] + 1) {
                            bStairCnt--;
                            pass[i] = true;
                            passCnt++;
                        }
                    }
                }
                for (int i : waitQ) {
                    if (selected[i]) { // aTeam
                        // 이미 계단이 만석이면
                        if (aStairCnt >= 3) {
                            // 못내려감
                            continue;
                        }
//                            System.out.println(aStairCnt);
                        aStairCnt++;
                        aTeam.put(i, aTeam.get(i) - 1);
                        if (aTeam.get(i) < 0 && (Math.abs(aTeam.get(i))) == stairs[0][DEPTH] + 1) {
                            aStairCnt--;
                            pass[i] = true;
                            passCnt++;
                        }
                    } else { // bTeam
                        // 이미 계단이 만석이면 잠시대기
                        if (bStairCnt >= 3) {
                            continue;
                        }
//                            System.out.println(bStairCnt);
                        bStairCnt++;
                        bTeam.put(i, bTeam.get(i) - 1);
                        if (bTeam.get(i) < 0 && (Math.abs(bTeam.get(i))) == stairs[1][DEPTH] + 1) {
                            bStairCnt--;
                            pass[i] = true;
                            passCnt++;
                        }
                    }
                }
            }
            res = Math.min(res, time);
            return;
        }
        selected[depth] = true;
        powerSet(depth + 1, selected);
        selected[depth] = false;
        powerSet(depth + 1, selected);
    }
}