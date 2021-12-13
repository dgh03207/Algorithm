package Baekjoon.java.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144 {

	static int R, C, T, map[][],answer;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<Integer> que_val = new LinkedList<>();
	static int[] aircleaner;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		aircleaner = new int[2];
		answer = 0;
		int a = 0;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if (map[r][c] == -1) {
					aircleaner[a++] = r;
				}

			}
		}

		Arrays.sort(aircleaner);
		
		for (int t = 0; t < T; t++) {
			before_spread();
			spread();
			clean();
			queue.clear();
			que_val.clear();
		}
		getdust();
		System.out.println(answer+2);
		
		
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && x < C && y >= 0 && y < R;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	private static void before_spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dust = map[i][j];
				if(dust>0) {
					queue.add(new int[] {j,i});
					que_val.add(map[i][j]);
				}
			}
		}
	}
	
	private static void spread() {
		int size = queue.size();
		if (!queue.isEmpty()) {
			for (int i = 0; i < size; i++) {

				int[] dust = queue.poll();
				int den = que_val.poll();
				int cnt = 0;
				// cnt구하는 배열
				for (int j = 0; j < 4; j++) {
					int nx = dust[0] + dr[j];
					int ny = dust[1] + dc[j];

					if (isRange(nx, ny) && map[ny][nx] != -1) {
						cnt++;
					}
				} // 사방 탐색

				den = (int) Math.floor(den / 5);
				int origin = map[dust[1]][dust[0]] - den * cnt;
				if (origin > 0) {
					map[dust[1]][dust[0]] = origin;

					for (int j = 0; j < 4; j++) {
						int nx = dust[0] + dr[j];
						int ny = dust[1] + dc[j];

						if (isRange(nx, ny) && map[ny][nx] != -1) {
							map[ny][nx] = map[ny][nx] + den;
						}
					} // 사방 탐색
				}
			}
		} // queue가 비어있는지 확인
	}// spread 종료문

	private static void clean() {
		int u = aircleaner[0];
		int d = aircleaner[1];
		Queue<Integer> temp = new LinkedList<>();

		// 반시계 방향으로 이동 시킴
		int[] rev_r = { 0, -1, 0, 1 };
		int[] rev_c = { 1, 0, -1, 0 };
		int[] now = new int[2];
		now[0] = 1;
		now[1] = u;
		temp.add(map[now[1]][now[0]]);
		map[now[1]][now[0]]=0;
		for (int i = 0; i < 4; i++) {

			while (true) {
				if (isRange(now[0] + rev_c[i], now[1] + rev_r[i])) {
					now[0] += rev_c[i];
					now[1] += rev_r[i];
					if (now[0] == 0 && now[1] == u) {
						break;
					}
					else {
						temp.add(map[now[1]][now[0]]);
						map[now[1]][now[0]] = temp.poll();

					}
				}else {
					break;
				}   
			}
		}
		
		//시계 방향으로 이동 시킴
		temp.clear();
		int[] clock_r = { 0, 1, 0, -1 };
		int[] clock_c = { 1, 0, -1, 0 };
		now = new int[2];
		now[0] = 1;
		now[1] = d;
		temp.add(map[now[1]][now[0]]);
		map[now[1]][now[0]]=0;
		for (int i = 0; i < 4; i++) {

			while (true) {
				if (isRange(now[0] + clock_c[i], now[1] + clock_r[i])) {
					now[0] += clock_c[i];
					now[1] += clock_r[i];
					if (now[0] == 0 && now[1] == d) {
						break;
					}
					else {
						temp.add(map[now[1]][now[0]]);
						map[now[1]][now[0]] = temp.poll();

					}
				}else {
					break;
				}   
			}
		}
	}
	
	private static void getdust() {
		for (int i = 0; i < R; i++) {
			answer += Arrays.stream(map[i]).sum();
		}
	}
}
