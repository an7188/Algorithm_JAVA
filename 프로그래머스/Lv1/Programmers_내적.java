package day1006;

import java.util.*;

public class Programmers_내적 {
	public static void main(String[] args) {

		Programmers_내적 p = new Programmers_내적(); // static이 붙어있지 않기 때문에 생성자로 프로그래머스 객체를 만들어준다

		int[] a = { -1,0,1};
		int[] b = { 1,0,-1 };
		
		
		
		
		int result= p.solution(a, b);
		System.out.println(result);
		//일때 예상 값은 3
		

	}

	public int solution(int[] a, int[] b) {
		int answer=0;
		
		for (int i = 0; i < a.length; i++) {
			answer+=a[i]*b[i];
			
		}
		
		return answer;
	}

}
