package Baekjoon.java.silver;

import java.util.Arrays;
import java.util.Scanner;

//국회의원 선거
public class boj1417 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] votes = new int[N-1];
		int myvote = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N-1; i++) {
			votes[i]=sc.nextInt();
		}
		
		Arrays.sort(votes);
		if(N>1) {
			while(myvote <= votes[N-2]) {
				votes[N-2]-=1;
				myvote+=1;
				cnt+=1;
				Arrays.sort(votes);
			}
		}
		System.out.println(cnt);
		
	}
}
