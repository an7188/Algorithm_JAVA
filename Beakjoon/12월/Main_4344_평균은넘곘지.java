import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344_평균은넘곘지 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스
		
		for (int tc = 0; tc < TC; tc++) {
			
			st= new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken()); //학생 수
			
			int student []= new int[N];
			int sum =0;
			for (int i = 0; i < N; i++) {
				student[i]= Integer.parseInt(st.nextToken());
				sum+=student[i];
			}// 학생 배열에 점수 넣기
			
			
			int avg= sum/N;
			double cnt=0;
			for (int i = 0; i < N; i++) {
				if(student[i]>avg) {
					cnt++;
				}
			}

			
			double result=100*cnt/N;
			
			System.out.printf("%.3f%%\n", result);
		}
		
		
	}

}
