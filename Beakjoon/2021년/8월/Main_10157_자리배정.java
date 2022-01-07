package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	static int R, C; // 행과 열
	static int map[][]; // 좌석번호 담기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int di[] = { 0, 1, 0, -1 }; // 좌 하 우 상
	static int dj[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C]; // 좌석번호 담을 배열 초기화
		int an = 0, an2 = 0;
		int seat = Integer.parseInt(br.readLine()); // 좌석번호 입력 받기
		int num = 1; // 좌석 번호
		int move = 0; // 오른쪽부터 출발
		int x = 0; // 현재 위치 행
		int y = 0; // 현재 위치 열
		int num1=1;
	
	

		while (true) {
			
			map[x][y] = num;
		
			if (num == R * C)
				break;

			int X = x + di[move];
			int Y = y + dj[move];
			
			if (X < 0 || X >= R || Y < 0 || Y >= C || map[X][Y]!=0) {

				move++; // 범위를 벗어 나면 움직이는 방향을 바꾸줌
				move %= 4;
				continue;
			}

			x = X;
			y = Y;
			num++;
			
		} // while문 끝
		

	aa:	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]==seat) {
					an=i+1;
					an2=j+1;
					break aa;
				}
			}
		}
		if (an==0 && an2==0) {
			System.out.println("0");
		}else
		System.out.printf("%d %d",an,an2);


	}

}
