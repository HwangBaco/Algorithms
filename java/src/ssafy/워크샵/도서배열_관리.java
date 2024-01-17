package ssafy.워크샵;

import java.util.Arrays;

public class 도서배열_관리 {
    public static class Book {
        protected String isbn;
        protected String title;
        protected String author;
        protected String publisher;
        protected int price;
        protected String desc;

        public Book() {
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return isbn + "\t|" + title + "\t\t|" + author + "\t|" + publisher + "\t|" + price + "\t|" + desc;
        }

        public Book(String isbn, String title, String author, String publisher, int price, String desc) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.price = price;
            this.desc = desc;
        }
    }

    public static class BookManager {
        final int MAX_SIZE = 100;
        Book[] books = new Book[MAX_SIZE];
        int size = 0;

        public BookManager() {
        }

        public void add(Book book) {
            if(size>= MAX_SIZE) {
                System.err.println("저장할 공간이 부족합니다.");
            }else {
                int index = findIndex(book.getIsbn());
                if(index== -1) {
                    books[size++] = book;
                }else {
                    System.err.println("이미 등록한 isbn 입니다. ");
                }
            }
        }
        private int findIndex(String isbn) {
            for (int i = 0; i <size; i++) {
                if(isbn.equals(books[i].getIsbn())) {
                    return i;
                }
            }
            return -1;
        }

        public void remove(String isbn) {
            if (isbn != null) {
                for (int i = 0; i < size; i++) {
                    if (books[i].isbn.equals(isbn)) {
                        books[i] = books[--size];
                        break;
                    }
                }
            }
        }

        public Book[] getList() {
            return Arrays.copyOfRange(books, 0, size);
        }

        public Book searchByIsbn(String isbn) {
            if (isbn != null) {
                for (int i = 0; i < size; i++) {
                    if (books[i].isbn.equals(isbn)) {
                        return books[i];
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        BookManager bm = new BookManager();

        bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
        bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
        bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));

        Book[] books = bm.getList();
        Book searchByIsbn = bm.searchByIsbn("21424");

        System.out.println("********************도서목록********************");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
        System.out.println("********************도서조회:21424********************");
        System.out.println(searchByIsbn.toString());
        System.out.println("********************도서삭제:21424********************");
        bm.remove("21424");
        books = bm.getList();
        System.out.println("********************도서목록********************");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }


    }

}
