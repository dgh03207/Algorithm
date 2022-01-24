package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj16988 {

    static int N,M,board[][],answer;
    static ArrayList<int[]> group_start = new ArrayList<>();
    static ArrayList<int[]> group_blocks= new ArrayList<>();
    static boolean isvisit[][];
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isvisit = new boolean[N][M];
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j]==2&&!isvisit[i][j]){
                    group_start.add(new int[]{i,j});
                    get_blocks(i,j);
                }
            }
        }

        if(group_blocks.size()>=2){
            for (int i = 0; i < group_blocks.size()-1; i++) {
                for (int j = i+1; j < group_blocks.size(); j++) {
                    board[group_blocks.get(i)[0]][group_blocks.get(i)[1]] = 1;
                    board[group_blocks.get(j)[0]][group_blocks.get(j)[1]] = 1;
                    int cnt = 0;
                    isvisit = new boolean[N][M];
                    for (int[] start:group_start) {
                        cnt+= bfs(start[0],start[1]);
                    }
                    if(cnt>answer) answer = cnt;
                    board[group_blocks.get(i)[0]][group_blocks.get(i)[1]] = 0;
                    board[group_blocks.get(j)[0]][group_blocks.get(j)[1]] = 0;

                }
            }
        }else if(group_blocks.size()==1){
            isvisit = new boolean[N][M];
            board[group_blocks.get(0)[0]][group_blocks.get(0)[1]]=1;
            int cnt = 0;
            for (int[] start: group_start) {
                cnt+= bfs(start[0],start[1]);
            }
            if(cnt> answer)answer = cnt;
            board[group_blocks.get(0)[0]][group_blocks.get(0)[1]]=0;
        }

        System.out.println(answer);
    }

    private static void get_blocks(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b});
        isvisit[a][b] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];

                if(isRange(nr,nc)&&!isvisit[nr][nc]){
                    if(board[nr][nc]==2){
                        isvisit[nr][nc]=true;
                        queue.add(new int[]{nr,nc});
                    }else if(board[nr][nc]==0){
                        isvisit[nr][nc]=true;
                        group_blocks.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
    private static int bfs(int a, int b){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{a,b});
        isvisit[a][b] = true;
        int cnt =1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];

                if(isRange(nr,nc)&&!isvisit[nr][nc]){
                    if(board[nr][nc]==2){
                        isvisit[nr][nc] = true;
                        cnt+=1;
                        queue.add(new int[]{nr,nc});
                    }else if(board[nr][nc]==0){
                        return 0;
                    }
                }
            }
        }
        return cnt;
    }
    private static boolean isRange(int a, int b){
        return a>=0&&a<N&&b>=0&&b<M;
    }


}
