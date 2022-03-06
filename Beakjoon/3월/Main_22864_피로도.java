import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22864_피로도 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 피로
		int A = Integer.parseInt(st.nextToken());
		// 일의 양
		int B = Integer.parseInt(st.nextToken());
		// 쉬는 시간 피로도 감소 양
		int C = Integer.parseInt(st.nextToken());
		// 피로도 최대 양
		int M = Integer.parseInt(st.nextToken());

		// 피로도 초기값
		int P = 0;
		// 일의 양 초기값
		int W = 0;

		// 하루 24시간
		for (int i = 0; i < 24; i++) {

			if (P+A > M) {
				P -= C;
				if (P <= 0) {
					P = 0;
				}
			} else {
				P+=A;
				W += B;
			}

		}
		System.out.println(W);

	}

}