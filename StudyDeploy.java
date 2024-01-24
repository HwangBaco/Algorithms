package 알고리즘연습;

import java.io.*;

public class StudyDeploy {
    private static void migrate(String fileName) {
        String sourcePath = ".\\boj\\" + fileName + ".java";
        File sourceFile = new File(sourcePath);
        String destPath = "C:\\Users\\HwangTaeyeon\\Desktop\\hwangz\\workspace\\repositories\\ps-study\\java-coding-test-study\\Jecheol_Hwang\\" + fileName + ".java";
        File destFile = new File(destPath);

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(destFile))) {

            int length;
            while ((length = inputStream.read()) > 0) {
                outStream.write(length);
            }

            System.out.println("파일이 성공적으로 복사되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void migrateByGPT(String fileName) {
        String sourcePath = ".\\boj\\" + fileName + ".java";
        File sourceFile = new File(sourcePath);
        String destPath = "C:\\Users\\HwangTaeyeon\\Desktop\\hwangz\\workspace\\repositories\\ps-study\\java-coding-test-study\\Jecheol_Hwang\\" + fileName + ".java";
        File destFile = new File(destPath);

        try (InputStream inStream = new FileInputStream(sourceFile);
             OutputStream outStream = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];

            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            System.out.println("파일이 성공적으로 복사되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("백준 파일명을 입력하세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        long prev = System.nanoTime();
        migrate(fileName);  // output : 14961401
//        migrateByGPT(fileName); // output : 17097599
        System.out.println("실행시간 : " + (System.nanoTime() - prev));
    }
}
