package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj16987 {
    static int N,answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[N];
        StringTokenizer st;
        List<int[]> eggs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        dfs(0,0,eggs);

        System.out.println(answer);

    }
    //egg[0] : 내구성 egg[1] : 무게
    private static void dfs(int now,int cnt,List<int[]>eggs){
        if(now==N){
            if(cnt>answer) answer = cnt;
            return;
        }
        //판에있는 계란이 내가갖고있는 계란빼고 다 깨져있거나 or 내가들고있는 계란이 깨져있는 경우
        if(cnt>=N-1||eggs.get(now)[0]<=0){
            dfs(now+1,cnt,eggs);
        }else{
            for (int i = 0; i < eggs.size(); i++) {
                //내가 들고있는 계란이 있는 위치를 가리키는 경우
                if(i==now) continue;
                int[] egg_onHand = eggs.get(now);
                int[] egg = eggs.get(i);
                //판에 있는 계란이 깨져있는 경우, 다음 계란을 선택함
                if(egg[0]<=0) continue;

                int broke_cnt = 0;
                egg_onHand[0]-= egg[1];
                egg[0]-= egg_onHand[1];

                if(egg_onHand[0]<=0) broke_cnt+=1;
                if(egg[0]<=0)broke_cnt+=1;

                dfs(now + 1, cnt + broke_cnt,eggs);
                egg_onHand[0]+=egg[1];
                egg[0]+=egg_onHand[1];
            }
        }

    }
}
