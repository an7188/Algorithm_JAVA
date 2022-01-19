import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        String string = br.readLine();
        String arr[]= string.split("\\-"); // "-" 기준으로 나눠 배열에 저장

        int sum = Integer.MAX_VALUE; //처음 값인지 확인하기 위해 아주아주 최소값 넣기

            for (int i = 0; i < arr.length; i++) {


                String arr2[] = arr[i].split("\\+");

                int minus = 0;
                for (int j = 0; j < arr2.length; j++) {
                    minus += Integer.parseInt(arr2[j]);

                }

                if(sum==Integer.MAX_VALUE){ //처음 넣는 값이라면 +니까
                    sum=0;
                    sum+=minus; // 더함
                }else{
                    sum-=minus; // 아니면 위에서 더한 애들을 땐다!
                }

            }

            System.out.println(sum);




    }
}
