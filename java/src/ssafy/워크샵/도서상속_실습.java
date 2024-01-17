package ssafy.워크샵;

import java.util.Arrays;

public class 도서상속_실습 {


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
            if (size < MAX_SIZE) {
                books[size] = book;
            }
            size++;
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
            for (int i = 0; i < size; i++) {
                if (books[i].isbn.equals(isbn)) {
                    return books[i];
                }
            }
            return null;
        }

        public Book[] searchByTitle(String title) {
            Book[] results = new Book[size];
            int idx = 0;
            for (int i = 0; i < size; i++) {
                if (books[i].title.contains(title)) {
                    results[idx++] = books[i];
                }
            }
            return results;
        }

        public Magazine[] getMagazine() {
            Magazine[] ans = new Magazine[MAX_SIZE];
            for (int i = 0; i < size; i++) {
                if (books[i].getClass().equals(Magazine.class)) {
                    ans[i] = (Magazine) books[i];
                }
            }
            return ans;
        }

        public Book[] getBooks() {
            Book[] ans = new Book[MAX_SIZE];
            for (int i = 0; i < size; i++) {
                if (!books[i].getClass().equals(Magazine.class)) {
                    ans[i] = books[i];
                }
            }
            return ans;
        }

        public int getTotalPrice() {
            int totalPrice = 0;
            for (Book book : books) {
                if (book != null) {
                    totalPrice += book.getPrice();
                }
            }
            return totalPrice;
        }

        public double getPriceAvg() {
            int totalPrice = 0;
            for (Book book : books) {
                if (book != null) {
                    totalPrice += book.getPrice();
                }
            }
            return (double) totalPrice / size;
        }
    }

    public static class Magazine extends Book {
        public int year;
        public int month;

        public Magazine() {
        }

        public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.price = price;
            this.desc = desc;
            this.year = year;
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        @Override
        public String toString() {
            return isbn + "\t|" + title + "\t|" + author + "\t|" + publisher + "\t|" + price + "\t|" + desc + "\t|" + year + "\t|" + month;
        }

    }


    public static void main(String[] args) {
        BookManager bm = new BookManager();

        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
        Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
        Magazine b4 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);

        bm.add(b1);
        bm.add(b2);
        bm.add(b3);
        bm.add(b4);

        Book[] allBooks = bm.getList();
        Book[] books = bm.getBooks();
        Magazine[] magazines = bm.getMagazine();
        Book[] javas = bm.searchByTitle("Java");

        System.out.println("********************도서 전체 목록********************");
        for (Book allBook : allBooks) {
            if (allBook != null) {
                System.out.println(allBook.toString());
            }
        }
        System.out.println("********************일반 도서 목록********************");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
        System.out.println("********************잡지 목록********************");
        for (Magazine magazine : magazines) {
            if (magazine != null) {
                System.out.println(magazine.toString());
            }
        }
        System.out.println("********************도서 제목 포함 검색:Java********************");
        for (Book java : javas) {
            if (java != null) {
                System.out.println(java.toString());
            }
        }
        System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
        System.out.println("도서 가격 평균 : " + bm.getPriceAvg());

    }
}