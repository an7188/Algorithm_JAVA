package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len = Integer.parseInt(br.readLine());
		int person = Integer.parseInt(br.readLine());
		int[] cake = new int[len+1];
		int max = 0;
		int bmax=0;
		int per =0;
		int personmax=0;

		for (int i = 1; i < person+1; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (max < end - start) {
				max = end -start;
				bmax =i;
			}
			for (int j = start; j <= end; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}

			}
			if (personmax<cnt) {
				personmax=cnt;
				 per = i;
			}
			
		}
	
		System.out.println(bmax);
		System.out.print(per);

	}

}
