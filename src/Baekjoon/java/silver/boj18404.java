package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//현명한 나이트
public class boj18404 {
    static int map[][],targets[][],start[],N,M;
    static boolean checked[][];
    static int[] dr = {-2,-2,-1,-1,1,1,2,2};
    static int[] dc = {-1,1,-2,2,-2,2,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i],Integer.MAX_VALUE);
        }

        start = new int[2];
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;

        targets = new int[M][2];
        checked = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            targets[i][0] = a;
            targets[i][1] = b;
            checked[a][b] = true;
        }

        bfs();
        for (int i = 0; i < M; i++) {
            sb.append(map[targets[i][0]][targets[i][1]]).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static boolean isRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start[0],start[1],0});
        map[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                int move = now[2]+1;

                if(isRange(nr,nc)&&map[nr][nc]>move){
                    map[nr][nc]=move;
                    queue.add(new int[]{nr,nc,move});
                }
            }
        }
    }
}
