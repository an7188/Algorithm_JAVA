package day0806;

import java.util.Scanner;

public class Solution_3499_퍼팩트셔플 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int tc = sc.nextInt();
		 int k=0;
		
		 for (int TC = 1; TC <= tc; TC++) {
			
			 int N = sc.nextInt();
			 k=N/2;
			 String [] arr=new String[N-k];
			 String [] arr2=new String[k];
			 String []arr3 = new String [N];
			 int x=0, y=1;
			 
			 for (int i = 0; i < N-k; i++) {
				 
				 String num= sc.next();
				 arr[i]= num;	
				 //System.out.println(arr[i]);
			}
			 for (int i = 0; i < k; i++) {
				 
				 String num1= sc.next();
				 arr2[i]= num1;		
				// System.out.println(arr2[i]);
			}
			 
			 
			 for (int i = 0; i < N; i++) {
				
				if (i==0) {
					arr3[i]=arr[i];
					
				}else if (i%2==1) {
					arr3[i]=arr2[x];
					x++;
					
				}else if (i%2==0) {
					arr3[i]=arr[y];
					y++;
					
				}
				
			}
			 
			 System.out.print("#"+ TC +" ");
			 for (int i = 0; i < N; i++) {
				System.out.print(arr3[i]+" ");
			}
			
			 System.out.println();
			 
		}
	}

}
