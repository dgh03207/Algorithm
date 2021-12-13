package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//무기공학
public class boj18430 {
	static int N,M,wood[][],strength[][],ans;
	static boolean visited[][];
	static int dr[] = {-1,-1,1,1};
	static int dc[] = {-1,1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		wood = new int[N+1][M+1];
		strength = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				wood[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		dfs(1,1,0);
		
		System.out.println(ans);
		
	}
	
	
	private static void dfs(int r, int c,int result) {
		if(r==N&&c==M+1) {
			return;
		}
		
		for (int i = r; i <= N; i++) {
			for (int j = (i==r? c:1); j <= M; j++) {
				if(visited[i][j]) continue;
				
				for (int k = 0; k < 4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(isRange(nr,j)&&isRange(i,nc)&&!visited[nr][j]&&!visited[i][nc]) {
						visited[i][j] = true;
						visited[nr][j] = true;
						visited[i][nc] = true;
						result += wood[i][j]*2+wood[nr][j]+wood[i][nc];
						
						if(ans<result) {
							ans = result;
						}
						
				
						dfs(i,j+1,result);
						visited[i][j] = false;
						visited[nr][j] = false;
						visited[i][nc] = false;
						result -= wood[i][j]*2+wood[nr][j]+wood[i][nc];
						
					}
					
				}
			}
		}
		
	}
	
	
	private static boolean isRange(int r, int c) {
		return r>=1&& r<=N && c>=1 && c<=M;
	}
}
