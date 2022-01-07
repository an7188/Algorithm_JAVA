package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS 접근 
public class Main_1012_유기농배추_BFS {

	static BufferedReader br;
	static StringTokenizer st;
	static int T, M, N, K; // 테케,가로 , 세로, 배추 개수
	static int X, Y; // 배추 좌표
	static int map[][]; // 밭
	static int [] di= {0,1,0,-1}; // 상 하 좌 우 
	static int [] dj= {1,0,-1,0};
	static int cnt; // 배추흰지렁이 수 
	static boolean [][]check;
	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 입력

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());// 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추 개수

			map = new int[M][N];
			check= new boolean [M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				// 좌표에 1입력

			}
			cnt=0;
			
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1) {
						bfs(i,j);
					
						cnt++;
					
					
					}
				}
				
			}
			
			System.out.println(cnt);

		}

	}

	static void bfs(int i, int j) {
		Queue<Point> qu= new LinkedList<>(); // 시작 배추 좌표 큐에 저장
		
		qu.add(new Point(i,j));
		
		while(!qu.isEmpty()) {
			Point p= qu.poll();
			map[p.i][p.j]=0;
			
			for (int k = 0; k < 4; k++) {
				int X= p.i+di[k];
				int Y= p.j+dj[k];
				if (X>=0 && X<M && Y>=0 && Y<N && map[X][Y]== 1) {
					if (!check[X][Y]) {
					check[X][Y] =true;
					qu.offer(new Point(X,Y));
						
					}
					
					
				}
				
			}
			
		}
		
		
		
		
		
	}
	
	
	static class Point {
		int i;
		int j;
		
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

}
