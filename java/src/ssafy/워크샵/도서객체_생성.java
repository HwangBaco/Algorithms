package ssafy.워크샵;

import java.io.IOException;

public class 도서객체_생성 {
    public static void main(String[] args) throws IOException {
        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        Book b2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
        System.out.println("********************도서목록********************");
        System.out.println(b1);
        System.out.println(b2);

    }

    public static class Book {
        String isbn;
        String title;
        String author;
        String publisher;
        int price;
        String desc;

        public Book() {}

        public Book(String isbn, String title, String author, String publisher, int price, String desc) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.price = price;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return isbn + "\t|" + title + "\t|" + author + "\t|" + publisher + "\t|" + price + "\t|" + desc;
        }
    }
}
