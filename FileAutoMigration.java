package 알고리즘연습;

import java.io.*;

public class FileAutoMigration {
    private static final String localRepoPath = "C:\\Users\\HwangTaeyeon\\Desktop\\hwangz\\workspace\\repositories\\ps-study\\java-coding-test-study";
    public static void main(String[] args) throws IOException {
        BufferedReader br;

        /*
        * input problem description
        * */
        System.out.print("백준 문제 '번호'를 입력하세요 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String problemNumber = br.readLine();
        System.out.println();
        System.out.print("백준 문제 '이름'을 입력하세요 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String problemName = br.readLine();
        System.out.println();
        System.out.print("백준 문제 '티어'을 입력하세요 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String problemTier = br.readLine();
        System.out.println();
        System.out.print("로직 실행 '시간'을 입력하세요 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String runTime = br.readLine() + "ms";
        System.out.println();
        System.out.print("풀이 소요 '시간'을 입력하세요 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String solvingTime = br.readLine();
        System.out.println();

        /*
        * fileName generation
        * */
        String fileName = new StringBuffer()
                .append("BOJ_")
                .append(problemNumber)
                .append("_")
                .append(problemName)
                .toString();

        /*
        * file migration
        * */
        long prev = System.nanoTime();
        migrate(fileName);  // output : 14961401
//        migrateByGPT(fileName); // output : 17097599
        System.out.println("실행시간 : " + (System.nanoTime() - prev));

        /*
        * commit message generation
        * */
        String commitMessage = new StringBuffer()
                .append("[BOJ]")
                .append(problemNumber)
                .append("/")
                .append(problemTier)
                .append("/")
                .append(runTime)
                .append("/")
                .append(solvingTime)
                .append("/")
                .append("황제철")
                .toString();

        /*
        * push to origin forked repository
        * */
        add();
        commit(commitMessage);
        push();
    }

    private static void migrate(String fileName) {
        String sourcePath = ".\\boj\\" + fileName + ".java";
        File sourceFile = new File(sourcePath);
        String destPath = localRepoPath + "\\Jecheol_Hwang\\" + fileName + ".java";
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
        String destPath = localRepoPath + "\\Jecheol_Hwang\\" + fileName + ".java";
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

    public static void add() throws IOException {
        Process add = Runtime.getRuntime().exec("git add .", null, new File(localRepoPath));

        // 명령어 정상 실행 여부 확인 (표준 출력과 에러 출력)
        printStream(add.getInputStream());
        printStream(add.getErrorStream());
    }

    private static void commit(String commitMessage) throws IOException {
        StringBuffer sb = new StringBuffer();
        String command = sb.append("git commit -m \"")
                .append(commitMessage)
                .append("\"")
                .toString();
        Process commit = Runtime.getRuntime().exec(command, null, new File(localRepoPath));

        // 명령어 정상 실행 여부 확인 (표준 출력과 에러 출력)
        printStream(commit.getInputStream());
        printStream(commit.getErrorStream());
    }

    public static void push() throws IOException {
        String pushCommand = new StringBuffer().append("git push origin main").toString();
        Process push = Runtime.getRuntime().exec(pushCommand, null, new File(localRepoPath));
        printStream(push.getInputStream());
    }

    private static void printStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
