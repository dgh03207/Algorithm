package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class boj2206 {
	static int N,M,map[][],hammer;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue <int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		hammer = 1;
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		bfs();
		
	}
	
	public static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	
	public static void bfs() {
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int cnt = 4;
			for (int i = 0; i < 4; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				
				if(isRange(nr,nc)) {
					if(map[nr][nc]==0) {
						queue.add(new int[] {nr,nc});
					}else {
						cnt--;
					}
				}
			}
		}
	}
	
}
