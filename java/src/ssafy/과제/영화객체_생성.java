package ssafy.과제;

public class 영화객체_생성 {
    public static void main(String[] args) {
//        Movie m1 = new Movie();
//        Movie m2 = new Movie(1, "서울의 봄", "싸피", "역사", 1000);
    }

    public class Movie {
        int id;
        String title;
        String director;
        String genre;
        int runningTime;

        public Movie() {
        }

        public Movie(int id, String title, String director, String genre, int runningTime) {
            this.id = id;
            this.title = title;
            this.director = director;
            this.genre = genre;
            this.runningTime = runningTime;
        }

    }
}
