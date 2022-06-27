package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class boj2668 {
    static int nums[],N,maxCnt;
    static boolean[] checked;
    static List<Integer> answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];

        maxCnt=0;
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        checked = new boolean[N+1];
        answer = new ArrayList<Integer>();
        for (int i = 1; i<=N; i++) {
            checked[i] = true;
            dfs(i,i);
            checked[i] = false;
        }
        answer = answer.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        };
    }

    private static void dfs(int start,int now){
        if(!checked[nums[now]]){
            checked[nums[now]] = true;
            dfs(start,nums[now]);
            checked[nums[now]] = false;
        }
        if(nums[now]==start) answer.add(now);
    }
}
