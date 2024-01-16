package 알고리즘연습.codetree.자료구조_중급.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 책꽂이_정리 {
    private static Book head = null;
    private static Book tail = null;

    public static final int ARR_SIZE = 101;

    public static void main(String[] args) throws IOException {
        BookSelf<Integer>[] bookSelves = new BookSelf[ARR_SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k + 1; i++) {
            bookSelves[i] = new BookSelf<>();
            if (i == 1) {
                for (int j = 1; j <= n; j++) {
                    bookSelves[i].addLast(new Book(j));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int l = 0; l < q; l++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                if (bookSelves[i] != null) {
                    BookSelf<Integer> bookSelf1 = bookSelves[i];
                    Book<Integer> book = bookSelf1.popFirst();
                    if (book != null) {
                        BookSelf<Integer> bookSelf2 = bookSelves[j];
                        bookSelf2.addLast(book);
                    }
                }
            } else if (cmd == 2) {
                if (bookSelves[i] != null) {
                    BookSelf<Integer> bookSelf1 = bookSelves[i];
                    Book<Integer> book = bookSelf1.popLast();
                    if (book != null) {
                        BookSelf<Integer> bookSelf2 = bookSelves[j];
                        bookSelf2.addFirst(book);
                    }
                }
            } else if (cmd == 3) {
                if (i != j) {
                    BookSelf<Integer> bookSelf1 = bookSelves[i];
                    BookSelf<Integer> bookSelf2 = bookSelves[j];
                    if (bookSelf1.size != 0) {
                        bookSelves[i] = new BookSelf<>();
                        bookSelf2.addListFirst(bookSelf1);
                    }
                }
            } else if (cmd == 4) {
                if (i != j) {
                    BookSelf<Integer> bookSelf1 = bookSelves[i];
                    BookSelf<Integer> bookSelf2 = bookSelves[j];
                    if (bookSelf1.size != 0) {
                        bookSelf2.addListLast(bookSelf1);
                        bookSelves[i] = new BookSelf<>();
                    }
                }

            }

//            for (int ik = 1; ik <= k; ik++) {
//                StringBuffer sb = new StringBuffer().append(bookSelves[ik].size).append(" ");
//                Book<Integer> book = bookSelves[ik].head;
//                for (int jk = 0; jk < bookSelves[ik].size; jk++) {
//                    while (book != null) {
//                        if (book.data == null) {
//                            break;
//                        }
//                        sb.append(book.data).append(" ");
//                        book = book.next;
//                    }
//                }
//                System.out.println(sb);
//            }
//            System.out.println("+++++++++++++++++++");
        }

        for (int ik = 1; ik <= k; ik++) {
            StringBuffer sb = new StringBuffer().append(bookSelves[ik].size).append(" ");
            Book<Integer> book = bookSelves[ik].head;
            for (int jk = 0; jk < bookSelves[ik].size; jk++) {
                while (book != null) {
                    if (book.data == null) {
                        break;
                    }
                    sb.append(book.data).append(" ");
                    book = book.next;
                }
            }
            System.out.println(sb);
        }

    }

    private static class Book<E> {
        private E data;
        private Book prev, next;

        public Book(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private static class BookSelf<E> {
        private Book<E> head;
        private Book<E> tail;
        private int size;

        private BookSelf() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        private Book<E> search(int idx) {
            Book<E> book = head;
            for (int i = 0; i < idx; i++) {
                book = book.next;
            }
            return book;
        }

        private void addFirst(Book<E> book) {
            Book<E> headBook = head;

            book.next = headBook;

            size++;

            if (headBook != null) {
                headBook.prev = book;
            } else {
                tail = book;
            }

            head = book;
        }

        private void addLast(Book<E> book) {
            Book<E> tailBook = tail;

            book.prev = tailBook;

            size++;

            if (tailBook != null) {
                tailBook.next = book;
            } else {
                head = book;
            }
            tail = book;
        }

        private Book<E> popFirst() {
            if (head == null) {
                return null;
            }
            E data = head.data;

            Book<E> newHead = head.next;

            head.next = null;
            head.data = null;

            head = newHead;
            if (head != null) {
                head.prev = null;
            }

            size--;

            if (head == null) {
                tail = null;
            }
            return new Book(data);
        }

        private Book<E> popLast() {
            if (tail == null) {
                return null;
            }

            E data = tail.data;

            Book<E> newTail = tail.prev;

            tail.data = null;
            tail.prev = null;

            tail = newTail;
            if (tail != null) {
                tail.next = null;
            }

            size--;

            if (tail == null) {
                head = null;
            }
            return new Book(data);
        }

        private void addListFirst(BookSelf<E> linkedList) {
            if (head != null) {
                head.prev = linkedList.tail;
            }
            if (linkedList.tail != null) {
                linkedList.tail.next = head;
            }
            head = linkedList.head;
            if (tail == null) {
                tail = linkedList.tail;
            }
            size += linkedList.size;
        }

        private void addListLast(BookSelf<E> linkedList) {
            if (tail != null) {
                tail.next = linkedList.head;
            }
            if (linkedList.head != null) {
                linkedList.head.prev = tail;
            }
            tail = linkedList.tail;
            if (head == null) {
                head = linkedList.head;
            }
            size += linkedList.size;
        }
    }
}
