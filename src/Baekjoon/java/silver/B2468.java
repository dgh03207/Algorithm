package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//안전 영역
public class B2468 {
	static int N, map[][], max;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static List<Integer> list = new ArrayList<>();
	static boolean[][] visit;
	static int[][] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		max = 0;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				if (!list.contains(num)) {
					list.add(num);
				}
			}
		}
		int answer = 1;
		Collections.sort(list);
		HashMap<Integer, int[][]> maps = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			visit = new boolean[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= n) {
						visit[j][k] = true;
						continue;
					} else if (visit[j][k])
						continue;
					else {
						
						dfs(new int[] {j,k},n);
						cnt++;
						if(answer<cnt) answer=cnt;
					}
				}
			}
		}
		System.out.println(answer);

	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void dfs(int[] now,int T) {
		visit[now[0]][now[1]] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + now[0];
			int nc = dc[i] + now[1];
			if (isRange(nr,nc) && map[nr][nc] > T&&!visit[nr][nc]) {
				dfs(new int[] {nr,nc},T);
			}
		}
	}
}
