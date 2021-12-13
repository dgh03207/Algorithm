package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//단지번호 붙이기
public class B2667 {

	static int N, map[][], cnt, num;
	static boolean visit[][];
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static Queue<int[]> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String s : br.readLine().split("")) {
				map[i][j] = Integer.parseInt(s);
				j++;
			}
		}
		answer = new ArrayList<>();
		num = 0;
		search();
		System.out.println(num);
		Collections.sort(answer);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void search() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					cnt = 1;
					visit[i][j]=true;
					bfs(i, j);
					num++;
				}
			}
		}
	}

	public static void bfs(int r, int c) {
		queue.add(new int[] { r, c });
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (isRange(nr, nc) && !visit[nr][nc] && map[nr][nc] == 1) {
					queue.add(new int[] { nr, nc });
					visit[nr][nc] = true;
					cnt++;
				}
			}

		}
		answer.add(cnt);
	}

}
