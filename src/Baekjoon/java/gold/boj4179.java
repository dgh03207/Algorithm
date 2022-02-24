package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불
public class boj4179 {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int R,C,answer;
    static boolean[][] map;
    static int[][] times;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        times = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(times[i],Integer.MAX_VALUE);
        }

        answer = Integer.MAX_VALUE;
        int[] start = new int[2];
        int[] fire = new int[2];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                if(line[j].equals(".")){
                    map[i][j] = true;
                }
                if(line[j].equals("J")){
                    map[i][j] = true;
                    start[0] = i;
                    start[1] = j;
                    times[i][j] = 0;
                }
                if(line[j].equals("F")){
                    map[i][j] = true;
                    fire[0] = i;
                    fire[1] = j;
                }
            }
        }

        bfs(start,0,fire);

    }

    private static boolean isRange(int r, int c){
        return r>=0&&r<R&&c>=0&&c<=C;
    }

    private static void bfs(int[] start,int time,int[]fire){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start[0],start[1],time});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                int t = now[2]+1;

                if(isRange(nr,nc)&&map[nr][nc]){

                }

            }
        }
    }
}
