package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj16206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        int priorityCnt = 0;
        int laterCnt = 0;
        ArrayList<Integer> priority = new ArrayList<>();
        ArrayList<Integer> later = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int cake = Integer.parseInt(st.nextToken());
            if (cake==10) answer +=1;
            else if(cake%10==0) {
                priority.add(cake);
                priorityCnt++;
            }else if(cake>10){
                later.add(cake);
                laterCnt++;
            }
        }

        Collections.sort(priority);
        Collections.sort(later);

        if(priorityCnt>0) {
            for (int i = 0; i < priorityCnt; i++) {
                int cake = priority.get(i);
                int get = cake / 10;
                int cut = get - 1;
                if (M >= cut) {
                    answer += get;
                    M -= cut;
                }else if(M<cut){
                    answer += M;
                    M=0;
                }
            }
        }
        if(M>0&&laterCnt>0) {
            for (int i = 0; i < laterCnt; i++) {
                int cake = later.get(i);
                int get = cake/10;
                if(M>=get){
                    answer += get;
                    M-= get;
                }else if(M<get){
                    answer += M;
                    M=0;
                }
            }
        }

        System.out.println(answer);

    }
}
