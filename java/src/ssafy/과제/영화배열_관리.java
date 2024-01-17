package ssafy.과제;

import ssafy.워크샵.도서배열_관리;

import java.util.Arrays;

public class 영화배열_관리 {
    public static class Movie {
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

        @Override
        public String toString() {
            return id + "\t|" + title + "\t\t|" + director + "\t|" + genre + "\t|" + runningTime;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getRunningTime() {
            return runningTime;
        }

        public void setRunningTime(int runningTime) {
            this.runningTime = runningTime;
        }
    }

    public static class MovieManager {
        final int MAX_SIZE = 100;
        Movie[] movieList = new Movie[MAX_SIZE];
        int size = 0;

        public MovieManager() {
        }

        public void add(Movie movie) {
            if (size < MAX_SIZE) {
                movieList[size] = movie;
            }
            size++;
        }

        public Movie[] getList() {
            return Arrays.copyOfRange(movieList, 0, size);
        }

        public Movie searchByTitle(String title) {
            if (title != null) {
                for (int i = 0; i < size; i++) {
                    if (movieList[i].title.equals(title)) {
                        return movieList[i];
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MovieManager mm = new MovieManager();
        Movie movie1 = new Movie(1, "영화1", "감독1", "장르1", 1000);
        Movie movie2 = new Movie(2, "영화2", "감독2", "장르2", 2000);
        System.out.println("=====영화생성=====");
        System.out.println(movie1);
        System.out.println(movie2);
        mm.add(movie1);
        mm.add(movie2);

        System.out.println("=====영화목록=====");
        Movie[] movies = mm.getList();
        for (Movie movie : movies) {
            if (movie != null) {
                System.out.println(movie);
            }
        }
        System.out.println("=====영화제목검색:영화1=====");
        Movie searchByTitle = mm.searchByTitle("영화1");
        System.out.println(searchByTitle);

    }
}
