package programmers.bruteforce;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            // yellow가 어떻게 배치될 지 완전탐색
            // yellow가 최대 2백만이고, 탐색 로직은 yellow로 주어진 숫자를 1,2,3,4,5,...로 나눠서
            // 딱 떨어지는 값에 대하여 brown개수가 일치하는지 볼 것이므로 완전탐색 시간복잡도 1000ms 이내.
            // yellow를 1,2,3,4,5,..로 나눠진 값(가로)이 나머지가 없어야 하고, 나누는 수(세로)보다 커야 한다.
            // yellow로부터 가로/세로를 구했으면, brown은 '(가로+세로)*2 + 4 == brown' 개수와 일치해야 한다.
            // 일치하는 가로와 세로 return.
            int width = 0;
            int height = 0;
            int[] answer = {};

            for (int i = 1; i <= yellow; i++) {
                if (yellow % i != 0) { // 나머지가 있으면 pass
                    continue;
                }
                width = yellow / i;
                height = i;
                if  (((width + height) * 2 + 4) == brown) {
                    answer = new int[]{width+2,height+2};
                    break;
                }
                if  (width < height) { // 세로가 가로보다 길어질 때부터는 연산 x
                    break;
                }

            }



            return answer;
        }
    }
}
