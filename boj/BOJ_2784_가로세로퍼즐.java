package 알고리즘연습.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2784_가로세로퍼즐 {
    static List<String> allWords = new ArrayList<>();
    static List<String> selectedWords = new ArrayList<>();
    static Map<Integer, Boolean> selected = new HashMap<>(); // 이것만 바꾸면 되는데... 흠 / 구분이 안되고 있음 / 문자열을 구분하기 위해
    static Queue<String> possiblePuzzles = new PriorityQueue<>();
    static final int FRONT = 0;
    static final int MID = 1;
    static final int BACK = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        for (int i = 0; i < 6; i++) {
            String s = br.readLine();
            allWords.add(s);
            selected.put(i, false);
        }
        go();

        // possiblePuzzles.poll() 하나 뽑고 substring으로 출력
        if (possiblePuzzles.isEmpty()) {
            System.out.println(0);
            return;
        }
        String ansPuzzle = possiblePuzzles.poll();
        System.out.println(ansPuzzle.substring(0, 3));
        System.out.println(ansPuzzle.substring(3, 6));
        System.out.println(ansPuzzle.substring(6, 9));
    }
    public static void go() {
        if (selectedWords.size() == 3) {
            if (isPossible(selectedWords)) {
                StringBuffer sb = new StringBuffer();
                for (String selectedWord : selectedWords) {
                    sb.append(selectedWord);
                }

                possiblePuzzles.add(sb.toString());
                return;
            }
        }
        // 단어 고르기
        for (int i = 0; i < 6; i++) {
            if (!selected.get(i)) {
                selected.put(i, true);
                selectedWords.add(allWords.get(i));
                go();
                selected.replace(i, false);
                selectedWords.remove(selectedWords.size() - 1);
            }
        }
    }

    public static boolean isPossible(List<String> selectedWords) {
        // 단어가 3개 있잖아
        // 그 단어를 하나씩 빼서 f / m / b 로 쪼개서 문자 하나씩 만들고
        // 그 단어 하나는 그대로 allWords.contains() 검사해
        // 완성된 단어 f / m / b 도 검사해
        // 한번이라도 삑나면 return false;
        StringBuffer front = new StringBuffer();
        StringBuffer mid = new StringBuffer();
        StringBuffer back = new StringBuffer();
        int cnt = 6;
        ArrayList<String> copyList = new ArrayList<>();
        allWords.stream().forEach(copyList::add);
        for (String selectedWord : selectedWords) {
            front.append(selectedWord.substring(FRONT, FRONT + 1));
            mid.append(selectedWord.substring(MID, MID + 1));
            back.append(selectedWord.substring(BACK, BACK + 1));
            if (copyList.contains(selectedWord)) {
//                cnt--;
                copyList.remove(selectedWord);
            }
        }
        if (copyList.contains(front.toString())) {
//            cnt--;
            copyList.remove(front.toString());
        }
        if (copyList.contains(mid.toString())) {
//            cnt--;
            copyList.remove(mid.toString());
        }
        if (copyList.contains(back.toString())) {
//            cnt--;
            copyList.remove(back.toString());
        }
        if (copyList.isEmpty()) {
            return true;
        }
        return false;
    }
}
