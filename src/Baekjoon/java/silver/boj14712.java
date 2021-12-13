package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//넴모넴모(Easy)
// 풀이 참고 :  https://coder-in-war.tistory.com/entry/BOJ-JAVA14712-%EB%84%B4%EB%AA%A8%EB%84%B4%EB%AA%A8
public class boj14712 {
	static int N,M,answer;
	static boolean map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][M+1];
		
		dfs(1,1);
		System.out.println(answer);
	}
	
	public static void dfs(int r, int c) {
		if(r==N&&c==M+1) {
			answer++;
			return;
		}
		
		for (int i = r; i <= N; i++) {
			
			for (int j = (i == r? c: 1); j <= M; j++) {
				if(check(i,j)) continue;
				
				map[i][j] = true;
				dfs(i,j+1);
				map[i][j] = false;
				
			}
		}
		
		answer++;
	}
	
	public static boolean check(int r, int c) {		//넴모넴모인지 확인하는 함수
		return map[r-1][c] && map[r][c-1] && map[r-1][c-1];
	}
}
