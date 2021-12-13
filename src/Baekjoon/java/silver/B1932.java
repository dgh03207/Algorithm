package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1932 {
	//정수 삼각형
	static int N = 0;
	static int[][] triangle,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int num = 1;
		triangle = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < num; j++) {
				triangle[i][j]=Integer.parseInt(st.nextToken());
				if(i==N-1) {
					dp[i][j]=triangle[i][j];
				}
			}
			num++;
		}
		
		fill();
		
		System.out.println(dp[0][0]);
	}
	
	private static void fill() {
		for (int f = N-1; f >0 ; f--) {
			for (int i = 0; i <f ; i++) {
				dp[f-1][i]= triangle[f-1][i]+Math.max(dp[f][i], dp[f][i+1]);
			}
		}
	}
	
	
	
	
	
}
