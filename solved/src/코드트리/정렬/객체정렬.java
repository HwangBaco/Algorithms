package 코드트리.정렬;

import java.util.Arrays;

public class 객체정렬 {
    /*
     * 자바에서 객체 필드 하나를 기준으로 오름차순/내림차순으로 정렬하기 위해서는 custom comparator함수가 필요.
     * 이 함수는 반환 타입이 "반드시" int여야 하며, 해당 class를 type으로 하는 1개의 인자를 가져야만 한다.
     *
     * 현재 객체(this)에 들어있는 값과 함수로 넘어온 객체 값을 비교했을 때, 오름차순 정렬을 위해서는
     * 다음 조건 3개를 만족시키면 된다.
     * 1. 현재 객체가 정렬 기준 더 뒤에 나와야 한다면 0보다 큰 값을 반환
     * 2. 현재 객체가 정렬 기준 더 앞에 나와야 한다면 0보다 작은 값을 반환
     * 3. 현재 객체가 정렬 기준 우선순위가 함수로 넘어온 객체와 동일하다면, 값 0을 반환
     *
     * 아래 예시는 "국어 점수를 기준으로 오름차순 정렬을 진행하기 위한 코드"이다.
     */
    static class Student implements Comparable<Student> {
        int kor, eng, math;

        public Student(int kor, int eng, int math) {
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

/*        @Override
        public int compareTo(Student student) { // 국어 점수 기준 오름차순 정렬
            if (this.kor > student.kor)
                return 1;
            else if (this.kor < student.kor)
                return -1;
            else
                return 0;
        }*/

        // 위의 오버라이드를 아래와 같이 표현해도 동일한 효과 달성
        @Override
        public int compareTo(Student student) { // 국어 점수 기준 오름차순 정렬
            return this.kor - student.kor;
            /*
            내림차순은 아래와 같다.
            return student.kor - this.kor;
            **/
        }
    };

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(90, 80, 90),
                new Student(20, 80, 80),
                new Student(90, 30, 60),
                new Student(60, 10, 50),
                new Student(80, 20, 10)
        };
        Arrays.sort(students);

        for (int i = 0; i < 5; i++) {
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math);
        }
    }

}
