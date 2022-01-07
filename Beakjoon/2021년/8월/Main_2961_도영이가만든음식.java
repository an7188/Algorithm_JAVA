package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든음식 {

		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st ;
		static int N;
		static int Min;
		static int[][] item;
		static boolean []isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		item= new int[N][2];
		isSelected= new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			item[i][0]= Integer.parseInt(st.nextToken());
			item[i][1]= Integer.parseInt(st.nextToken());
			
			
		}
		Min= Integer.MAX_VALUE;
		pe(N,isSelected);
		System.out.println(Min);
		
	}
	private static void pe(int cnt, boolean[] isSelected2) {
		if (cnt==0) {
			print(isSelected2);


			return;
		}
		
		isSelected2[cnt-1] = true;
		pe(cnt-1,isSelected2);
		isSelected2[cnt-1] = false;
		pe(cnt-1,isSelected2);
		
	}
	private static void print(boolean[] isSelected2) {
		int sm=1; //신맛
		int ssm=0; //쓴맛
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (!isSelected2[i]) continue;
			//System.out.println(Arrays.toString(item[i]));
			flag= true;
			sm*=item[i][0];
			ssm+=item[i][1];
			
		}
		if (flag) {
			Min = Math.min(Min, Math.abs(sm-ssm));
		}
		
	}

}
