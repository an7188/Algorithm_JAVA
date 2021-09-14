package day0823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS_BFS {

	static int[][] check; // 간선들간에 연결 확인
	static boolean[] checked; // 확인 여부
	static int n; // 정점의 개수
	static int m; // 간선 개수
	static int start; //시작정점
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m= sc.nextInt();
		start = sc.nextInt();
		
		check = new int[n+1][n+1]; // 간선들의 좌표
		checked = new boolean[n+1]; 
		
		
		//간선의 연결상태 저장
		for (int i = 0; i < m; i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			
			check[x][y]=check[y][x]=1;
		}
		
		
		
		dfs(start); 
		
		
		checked = new boolean[n+1];
		System.out.println();
		
		bfs();
		
	}
	
	// 시작점을 변수로 받고 확인 하고 출력
	private static void dfs(int i) {
		checked[i]=true;
		System.out.print(i+" ");
		
		
		for (int j = 0; j <= n; j++) {
			if (check[i][j]==1 && checked[j]==false) { // 간선 좌표에 값이 1이고 false이면
				
				dfs(j); // 다음 깊이로 넘어감 
			}
		}
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start); // 시작점을 큐에 넣음
		checked[start]=true;
		System.out.print(start+" ");
		
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			
			for (int i = 1; i <=n; i++) {
				if (check[temp][i]==1 &&  checked[i]==false) {
					queue.offer(i);
					checked[i]=true;
					
					System.out.print(i+" ");
					
				}
			}
			
			
			
		}
		
		
		
	}



}
