package 알고리즘연습.codetree;

import java.io.*;
import java.util.Scanner;

public class Test {
    private static final String DATA = "hi java world";

    private static void read1() { // 바이트 한 개씩 읽음
        System.out.println("====================");
        System.out.println("바이트 한 개씩 읽는 방식");
        try {
            InputStream input = new ByteArrayInputStream(DATA.getBytes());
            int read = -1;
            while ((read = input.read()) != -1) {
                System.out.printf("읽은 값 : %d, 문자로 : %c\n", read, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read2() {
        System.out.println("====================");
        System.out.println("buffer[10] 만큼 씩 읽음");
        try {
            byte[] buffer = new byte[10];
            ByteArrayInputStream input = new ByteArrayInputStream(DATA.getBytes());
            int read = -1;
            while ((read = input.read(buffer)) > 0) {
                System.out.printf("읽은 개수 : %d, 문자열 : %s\n", read, new String(buffer));
                buffer = new byte[10];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String file = "hello";


    private void useScanner() throws FileNotFoundException {
        try (Scanner sc = new Scanner(file)) {
            long start = System.nanoTime();
            String line = null;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
            }
            System.out.printf("sc: %10d\n", System.nanoTime() - start);
        }
    }

    private void useBufferedReader() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            long start = System.nanoTime();
            String line = null;
            while ((line = br.readLine()) != null) {
            }
            System.out.printf("br: %10d\n", System.nanoTime() - start);
        }

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader());
//        System.out.println(br.readLine());
        read1();
        read2();
    }
}
