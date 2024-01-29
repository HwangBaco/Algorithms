package 알고리즘연습;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAutoMigration {
    private static final String localRepoPath = "C:\\Users\\HwangTaeyeon\\Desktop\\hwangz\\workspace\\repositories\\ps-study\\java-coding-test-study";
    private static final String USER_NAME = "황제철";
    private static final String PROBLEM_TYPE = "BOJ";

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        /*
        * input problem description
        * */
        String problemNumber = inputCommandString("백준 문제 '번호'를 입력하세요 : ");

        String problemName = inputCommandString("백준 문제 '이름'을 입력하세요 : ");

        String problemTier = inputCommandString("백준 문제 '티어'을 입력하세요 : ");

        String runTime = inputCommandString("로직 실행 '시간'을 입력하세요 : ");

        String solvingTime = inputCommandString("풀이 소요 '시간'을 입력하세요 : ");

        long prev = System.nanoTime();

        /*
        * fileName generation
        * */
        String fileName = getFileName(problemNumber, problemName);


        /*
        * file migration
        * */
        migrate(fileName);  // output : 14961401

        /*
        * commit message generation
        * */
        String commitMessage = getCommitMessage(problemNumber, problemTier, runTime, solvingTime);

        /*
        * push to origin forked repository
        * */
        add();
        commit(commitMessage);
        push();
        openGitHubRepository();
        
        System.out.println("실행시간 : " + (System.nanoTime() - prev));
    }

    private static String getFileName(String problemNumber, String problemName) {
        return new StringBuffer()
                .append(PROBLEM_TYPE + "_")
                .append(problemNumber)
                .append("_")
                .append(problemName)
                .toString();
    }


    private static String inputCommandString(String s) throws IOException {
        System.out.print(s);
        br = new BufferedReader(new InputStreamReader(System.in));
        String commandString = br.readLine();
        System.out.println();
        return commandString;
    }

    private static String getCommitMessage(String problemNumber, String problemTier, String runTime, String solvingTime) {
        return new StringBuffer()
                .append("[" + PROBLEM_TYPE + "]")
                .append(problemNumber)
                .append("/")
                .append(problemTier)
                .append("/")
                .append(runTime)
                .append("ms/")
                .append(solvingTime)
                .append("/")
                .append(USER_NAME)
                .toString();
    }

    private static void openGitHubRepository() throws IOException {
        Process openRepo = Runtime.getRuntime().exec("explorer \"https://github.com/HwangBaco/java-coding-test-study\"");
        printStream(openRepo.getInputStream());
        printStream(openRepo.getErrorStream());
    }

    private static void migrate(String fileName) {
        String sourcePath = ".\\" + PROBLEM_TYPE.toLowerCase() + "\\" + fileName + ".java";
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
