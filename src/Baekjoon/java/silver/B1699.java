package Baekjoon.java.silver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] d = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			d[i] = i;
			for (int j = 2; j*j<=i; j++) {
				d[i] = Math.min(d[i],d[i-(j*j)]+1);
				
			}
			
		}
		
		System.out.println(d[N]);
		
		
		
		
		
		
	}
}
