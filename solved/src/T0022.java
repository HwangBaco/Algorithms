import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String command = br.readLine();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'L') {
                s = s.substring(1) + s.substring(0, 1);
            } else if (command.charAt(i) == 'R') {
                s = s.substring(s.length()-1) + s.substring(0, s.length() - 1);
            }
        }
        System.out.println(s);
    }
}
