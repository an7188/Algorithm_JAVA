package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2846_오르막길 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수열의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //
		int arr[] = new int[N];
		int ur = 0; // 오르막 측정값 저장
		int start = 0; // 오르막길 시작값 저장
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}

		start = arr[0];

		for (int i = 1; i < N; i++) {
			if (arr[i-1] >= arr[i]) {

				if ((arr[i-1] - start)>ur) {
					ur = arr[i-1] - start;
					
				}
				start = arr[i];

			}else if ((arr[i] - start)>ur) {
				ur = arr[i] - start;
				
			}
			
		}
		
		System.out.println(ur);

	}

}
