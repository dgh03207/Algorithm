package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4179 {

    static int R,C;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean[][] map;
    static int[][] times;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        times = new int[R][C];

        int[] start = new int[2];
        int[] fire = new int[2];

        for (int i = 0; i < R; i++) {
            Arrays.fill(times[i],Integer.MAX_VALUE);
        }

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                if(line[j].equals("#")){
                    map[i][j] = false;

                }else{
                    map[i][j] = true;

                    if(line[j].equals("J")){
                        start[0] = i;
                        start[1] = j;
                        times[i][j] = 0;
                    }else if(line[j].equals("F")){
                        fire[0] = i;
                        fire[1] = j;
                    }
                }
            }
        }

    }

    private static boolean isRange(int r, int c){
        return r>=0 && r<R && c>=0 && c<C;
    }

    private static void bfs(int[] start,int[] fire){
        Queue<int[]> fqueue = new LinkedList<>();
        Queue <int[]> queue = new LinkedList<>();

        fqueue.add(new int[]{fire[0],fire[1]});
        queue.add(new int[]{start[0],start[1],0});

        while (queue.isEmpty()){
            int[] now = queue.poll();
            int[] fnow = queue.poll();

            map[now[0]][now[1]] = false;
            map[fnow[0]][fnow[1]] = false;

            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                int time = now[2]+1;
//
//                if(isRange(nr,nc)&& map[nr][nc] && )

            }

            for (int i = 0; i < 4; i++) {
                int fr = fnow[0]+dr[i];
                int fc = fnow[1]+dc[i];

            }

        }
    }


}
