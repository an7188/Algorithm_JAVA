package day0916;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
 
public class Solution_3308_최장증가수열2 {
 
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
         
        int T= sc.nextInt();
        for (int tc = 1; tc <=T; tc++) {
             
         
        int N= sc.nextInt();
        int [] arr= new int [N];
        int [] LIS =new int[N]; //해당 길이를 증가수열 중 맨 끝을 최소값으로 유지 
         
         
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
         
        int size=0; //LIS에 채워진 원소 수 
        for (int i = 0; i < N; i++) {
            //중복값이 없으므로 탐색 실패 : 음수 값 ==> 삽입 위치로 환산 
             
            int temp =Math.abs(Arrays.binarySearch(LIS, 0,size,arr[i]))-1;
             
            LIS[temp]= arr[i];
             
             
            //추가된 위치가 맨 뒤라면 사이즈 증가
            if (temp ==size ) size++;
         
        }
         
            System.out.println("#"+ tc+" "+size);
        }
         
     
    }
 
}
