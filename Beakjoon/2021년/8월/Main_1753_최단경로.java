package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb= new StringBuilder();
	static int V, E ,K; // 정점과 간선, 시작 정점 변수
	static int u,v,start ; // u에서 v의 경로 w가중치
	static int distance[]; //최단거리를 저장할수 있는 변수
	static int check[]; // 해당 노드를 반문했는지 체크 변수
	
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		
		distance = new int[V+1];
		check= new int [V+1];
		
		K = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 1; i <= V; i++) {
			distance[i]=Integer.MAX_VALUE;
			
		}
		
		
		
	}

}
