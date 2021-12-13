package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
	static int[][][] boxes;
	static int[] dr = { 1, 0, -1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> queue = new LinkedList<>();
	static int N,H,M,days;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken()); 
		boolean already = true;
		
		boxes = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					boxes[h][n][m] = Integer.parseInt(st.nextToken());
					if(boxes[h][n][m]==1)
						queue.add(new int[] {h,m,n});
					else if(boxes[h][n][m]==0) already = false;
				}
			}
		}
		
		if(already) System.out.println(0);
		else {
			bfs();
			if(allchecked(boxes)) System.out.println(days-1);
			else System.out.println(-1);
		}
		
	
	}
	
	private static boolean isRange(int h, int x, int y) {
		return h>=0 && h<H && x>=0 && x<M && y>=0 && y<N;
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nh = now[0] + dh[i];
				int nx = now[1] + dr[i];
				int ny = now[2] + dc[i];
				
				if (isRange(nh,nx, ny) && boxes[nh][ny][nx] == 0) {
					boxes[nh][ny][nx] = boxes[now[0]][now[2]][now[1]] + 1;
					days = Math.max(boxes[nh][ny][nx], days);
					queue.add(new int[] {nh,nx, ny });
				}
			}
		}
	}

	private static boolean allchecked(int[][][] boxes) {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (boxes[h][i][j] == 0)
						return false;
				}
			}
		}
		return true;
	}
}
