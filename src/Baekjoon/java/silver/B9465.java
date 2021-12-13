package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//스티커
public class B9465 {
	static int N,board[][],d,dp[][];

	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[2][N+1];
			dp = new int[2][N+1];
			visit = new boolean[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N ; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = board[0][1];
			dp[1][1] = board[1][1];
			for (int i = 2; i <=N; i++) {
				dp[0][i] = board[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
				dp[1][i] = board[1][i]+Math.max(dp[0][i-1],dp[0][i-2]);
			}
			
			
			sb.append(Math.max(dp[0][N], dp[1][N])+"\n");
		}
		System.out.println(sb.toString());
	}

	
	
	
	
	
	
}
