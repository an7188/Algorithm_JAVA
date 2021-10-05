package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1963_탈주범검거_BFS {

	static String[] type = { null, "0312", // 1: 상하좌우
			"03", // 2: 상하
			"12", // 3: 좌우
			"02", // 4: 상우
			"32", // 5: 하우
			"31", // 6: 하좌
			"01", // 7: 상좌
	};

	static int[] di = { -1, 0, 0, 1 }; // 상,좌,우,하
	static int[] dj = { 0, -1, 1, 0 }; // 상,좌,우,하
	static int N,M,R,C,L,map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringTokenizer st= null;
		for (int tc = 1; tc <= TC; tc++) {
			st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			
			
			map= new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+tc+" "+bfs());
		}
	}

	private static int bfs() {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean [][] visited= new boolean[N][M];
		int result=0, time=1;
		
		qu.add(new int[] {R,C});
		visited[R][C]= true;
		result++;
		
		
		int r,c,nr,nc,size,current[],dir;
		String info= null;
		while(time++<L) {
			size=qu.size();
			while(size-->0) {
				
				current=qu.poll();
				r=current[0];
				c=current[1];
				
				info= type[map[r][c]];
				
				for (int d = 0,length=info.length(); d < length; d++) {
					dir=info.charAt(d)-'0';
					nr=r+di[dir];				
					nc=c+dj[dir];
					
					if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=0
							&& type[map[nr][nc]].contains(Integer.toString(3-dir))
							&& !visited[nr][nc]) {
						qu.offer(new int[] {nr,nc});
						visited[nr][nc]=true;
						result++;
						
					}
					
				}
				
			}
			
			
			
		}
		
		
		return result;
	}

}
