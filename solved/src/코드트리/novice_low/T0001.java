package 코드트리.novice_low;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 배열의 원소 10개가 주어졌을 때, 원소 중 3의 배수가 처음으로 등장하는 부분의 바로 앞 원소를 출력

 <pseudo code>
 1. StringTokenizer로 한줄 입력받고
 2. int[] arr = new int[10];
 3. for i in range(0,10):
    arr[i] = Integer.parseInt(st.nextToken());

    if arr[i]%3 == 0:
        print(arr[i-1]);
        break;
 4.
* */
public class T0001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] % 3 == 0) {
                System.out.println(arr[i - 1]);
                break;
            }
        }
    }
}
