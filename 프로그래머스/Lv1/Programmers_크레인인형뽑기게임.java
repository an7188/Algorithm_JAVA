import java.util.*;

public class Programmers_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		
		System.out.println(Solution(board,moves));
	}

	private static int Solution(int[][] board, int[] moves) {
		  int answer = 0;
		  
		  Stack<Integer> st = new Stack<Integer>();
		  for (int i = 0; i < moves.length; i++) {
			int num = moves[i]-1;
			for (int j = 0; j < board.length; j++) {
				int doll = board[j][num];
				
				if(doll>0) { //해당하는 위치의 열을 위쪽부터 검사 0 이상이라면 인형이 있음 
					if(st.isEmpty()) { //바구니가 비어 있다면 그냥 담음
						st.add(doll);
						System.out.print(doll+" add");
					}else {
						if(st.peek()==doll) { // 바구니에 원래 담겨 있던 인형이 지금 인형과 같다면 
							System.out.print(st.pop()+" pop");
//							st.pop(); //인형 터트리기
							answer+=2;
						}else {
							System.out.print(doll+" add2");
							st.add(doll); // 인형 바구니에 담기
						}
					}
					board[j][num]=0;
					System.out.println();
					System.out.println();
					break;
				}
				
			}
			  
		}
	        return answer;
		
	}
	
	
	

}
