package day0825;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String alp = sc.next();
		 String str[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		 
		 for (int i = 0; i < str.length; i++) {
			if (alp.contains(str[i])) {
				alp=alp.replace(str[i], "a");
			}
			
			
		}
		 
		 System.out.println(alp.length());
		 
	}

}
