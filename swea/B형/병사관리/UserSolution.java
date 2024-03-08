package 알고리즘연습.swea.B형.병사관리;

import java.util.HashMap;

/**
 * 25개에 대하여 3000ms 이내면 하나당 120ms 이내
 *
 * 일단 병사를 관리할 DB 자료구조를 설정해야 함.
 * 각 TC에서 100ms 이내
 * bestSoldier() 메서드 호출 100회 이내
 * hire 메서드 호출 10만회 이내
 *
 * @intuition 일단 DB 자료구조부터 선정해야 함
 * 1. 추가/삭제/수정이 일어나는데, 이게 각 데이터를 찾고, 순서 수정이 아니라 그냥 수정하는 거라서 굳이 linkedlist는 필요 없음
 * 2. 일단 HashMap으로 hire/fire 등을 구현하고
 * 3. 각 팀별로 인덱스를 운영해야 접근이 빠름
 *
 * 4. mID를 갖는 작업은 HashMap으로만 하면 쌉가능
 * 5. 전체 순회는 linkedlist같은 선형 자료구조가 빠름 -> updateTeam을 위함
 * -> 그러면 linkedlist를 이용하여 tree를 구현하여 관리 -> 이진탐색으로
 * 6. bestsoldier는 우선순위 큐(?)를 이용하면 되지 않을까? 팀별로 관리
 *
 * 해시맵으로 mID를 가지고 연산하는건 hire, fire, updateSoldier까지는 문제 없는데,
 * updateTeam의 경우에는 병사가 최대 10만명인데, 최대 10만번 호출되면 메서드 시간복잡도가 O(logN) 정도로 나와야 가능)
 *
 * 근데 bestSoldier는 100번 호출이 전부인거면 10만명의 병사에 대하여 O(N * logN)까지 가능하다는 의미
 *
 * 각 솔져의 mID, mTeam, mScore를 각각 하나씩 HashMap<Integer,Integer> 으로 운영하고,
 * 각 팀별로 mID 인덱스를 linkedlist로 관리
 *
 * 삭제는 아예 지우지 말고 mID를 0으로 넣어라.
 * 전체 업데이트 시 linkedlist를 순회하면서
 *
 * 관건은 updateTeam 연산임.
 */
class UserSolution {
    private static HashMap<Integer, Integer> hm = new HashMap<>();
    /**
     * 각 TC의 처음에 호출됨 (사용 변수 초기화 목적)
     * TC 시작시 고용된 병사는 없는 것으로 설정
     */
    public void init() {
    }

    /**
     * 중복으로 주어지지 않음
     *
     * @param mID    고유번호 (1이상 10만 이하)
     * @param mTeam  소속팀 (1이상 5이하)
     * @param mScore 평판점수 (1이상 5이하)
     * @return void (해당 병사 DB에 등록)
     */
    public void hire(int mID, int mTeam, int mScore) {
    }

    /**
     * 해당 mID인 병사가 반드시 존재함 (예외처리 불필요)
     *
     * @param mID 고유번호
     * @return void (해당 병사 DB에서 삭제)
     */
    public void fire(int mID) {
    }

    /**
     * @param mID    고유번호
     * @param mScore 평판 점수
     * @return void (해당 병사 평판점수 대입하여 수정)
     */
    public void updateSoldier(int mID, int mScore) {
    }

    /**
     * @param mTeam        소속팀
     * @param mChangeScore 평판 점수 (-4이상 4이하)
     * @return void (소속 팀에 대한 평판 점수 bulk 연산 ; +연산으로 설정)
     */
    public void updateTeam(int mTeam, int mChangeScore) {
    }

    /**
     * @param mTeam 소속 팀
     * @return int (평판 점수가 가장 높은 병사 mID 반환, 중복이면 고유번호가 가장 큰 것)
     */
    public int bestSoldier(int mTeam) {
        return 0;
    }
}