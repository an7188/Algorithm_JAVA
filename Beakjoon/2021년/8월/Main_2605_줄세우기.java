package day0827;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt(); // 학생 수 입력
		//int arr[] = new int[num]; //학생이 뽑은 숫자 저장 배열
		int box[]= new int [num]; //학생을 잠시 뺴놓을 배열 ㅎ
		int cnt=0; //학생 번호
	
		
		
		for (int i = 0; i < num; i++) {
			int input = sc.nextInt();
			cnt++;
			for (int j = 1; j <= input; j++) {
				box[j]=st.pop();
				//System.out.println(box[j]);
			}
			st.add(cnt);
			for (int j = input; j >= 1; j--) {
				st.add(box[j]);
			}
		}
		
		
		for (int i = 0; i < num; i++) {
			box[i]= st.pop();
					
		}
		
		for (int i =num-1; i >=0; i--) {
			System.out.print(box[i]+" ");
		}
		
		

	}

}
