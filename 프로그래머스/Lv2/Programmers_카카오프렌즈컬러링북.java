import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
//		int m =6;
//		int n=4;
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

		int m =4;
		int n=4;
		int[][] picture =  { { 1, 1, 1, 1 }, { 1, 4, 1, 1 }, { 1, 3, 2, 1 }, { 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(m,n,picture)));

	}

	static boolean check[][];
	static Queue<Point> qu = new LinkedList<>();

	static long arr[][];
	static int da[][] = {{1,-1,0,0},{0,0,1,-1}};
	private static int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];

		check = new boolean[m][n];
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				if(picture[i][j]!=0 && !check[i][j]) {
					int max =bfs(i,j,picture,m,n);
					numberOfArea++;

					maxSizeOfOneArea= Math.max(max,maxSizeOfOneArea);
				}
			}
		}
		answer[0]=numberOfArea;
		answer[1]=maxSizeOfOneArea;
		return answer;
	}

	private static int bfs(int i, int j, int[][] picture,int m, int n) {
		int max=0;
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(i,j));
		int da[][] = {{1,-1,0,0},{0,0,1,-1}};
		int cnt =1;
		int now = picture[i][j];
		check[i][j]=true;
		while(!qu.isEmpty()) {

			Point P= qu.poll();
			int x= P.x;
			int y= P.y;

			for (int k = 0; k < 4; k++) {
				int X= x+da[0][k];
				int Y= y+da[1][k];

				if(X>=0 &&Y>=0 && X<m && Y<n && picture[X][Y]==now && !check[X][Y]) {
					qu.add(new Point(X,Y));
					check[X][Y]=true;
					cnt++;
				}
			}

		}
		// max= Math.max(max, cnt);
		return cnt;
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}