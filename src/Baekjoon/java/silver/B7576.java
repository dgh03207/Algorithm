package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {

	static int[][] boxes;
	static int[][] visited;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, days;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boxes = new int[N][M];
		visited = new int[N][M];
		boolean already = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				boxes[i][j] = Integer.parseInt(st.nextToken());
				if (boxes[i][j] == 1) {
					queue.add(new int[] { j, i });
				}
				if (boxes[i][j] == 0)
					already = false;
			}
		}
		days = 0;
		if (already)
			System.out.println(0);
		else {

			bfs();
			if (allchecked(boxes)) {
				System.out.println(days - 1);
			} else
				System.out.println(-1);
		}
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dr[i];
				int ny = now[1] + dc[i];

				if (isRange(nx, ny) && boxes[ny][nx] == 0) {
					boxes[ny][nx] = boxes[now[1]][now[0]] + 1;
					days = Math.max(boxes[ny][nx], days);
					queue.add(new int[] { nx, ny });
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(boxes[i]));
		}
	}

	private static boolean allchecked(int[][] boxes) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boxes[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
