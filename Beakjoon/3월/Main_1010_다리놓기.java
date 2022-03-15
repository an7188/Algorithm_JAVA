import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	static int N, M, count;
	static int arr[], box[][];

	public static void main(String[] args) throws IOException {

		box= new int[30][30];
		
		for (int i = 0; i <30; i++) {
			for (int j = 0; j < 30; j++) {
				if(i==j || i==0 || j==0 ) {
					box[i][j]=1;
					
				}else {
					box[i][j]= box[i-1][j-1]+box[i][j-1];
				}
			}
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());


		
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			System.out.println(box[N][M]);
			
		}

	}

}
