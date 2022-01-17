package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//출근
public class boj13903 {
    static int R,C,dr[],dc[],N,cnts[][],answer;
    static boolean board[][];
    static ArrayList<int[]> starts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new boolean[R][C];
        cnts = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(cnts[i],Integer.MAX_VALUE);
        }
        answer = -1;
        starts = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a==0) board[i][j] = false;
                else if (a==1){
                    board[i][j] = true;
                    if(i==0){
                        starts.add(new int[]{i,j});
                    }
                }

            }
        }
        N = Integer.parseInt(br.readLine());
        dr = new int[N];
        dc = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dr[i] = Integer.parseInt(st.nextToken());
            dc[i] = Integer.parseInt(st.nextToken());
        }
        bfs();
        System.out.println(answer);
    }

    private static boolean isRange(int r, int c){
        return r>=0&&r<R&&c>=0&&c<C;
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < starts.size(); i++) {
            int[] temp = starts.get(i);
            queue.add(new int[]{temp[0],temp[1],0});
            cnts[temp[0]][temp[1]] = 0;
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == R - 1) {
                if(answer==-1) answer = cnts[now[0]][now[1]];
                else if (answer > cnts[R - 1][now[1]]) answer = cnts[now[0]][now[1]];
                continue;
            }
            for (int i = 0; i < N; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                int cnt = now[2] + 1;
                if (isRange(nr, nc) && board[nr][nc] && cnts[nr][nc] > cnt) {
                    cnts[nr][nc] = cnt;
                    queue.add(new int[]{nr, nc, cnt});
                }
            }
        }
    }

    private static void show(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(cnts[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
