package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class boj13910 {
    static int N, mywok[], order, answer, dp[];
    static List<Integer> wok = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = -1;
        order = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        mywok = new int[N];
        dp = new int[order + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mywok[i] = Integer.parseInt(st.nextToken());
            if (mywok[i] <= order) {
                wok.add(mywok[i]);
            }
        }


        for (int i = 0; i <N; i++) {
            for (int j = i+1; j < N; j++) {
                if (mywok[i] + mywok[j] <= order) {
                    wok.add(mywok[i] + mywok[j]);
                }
            }

        }
        wok = wok.stream().sorted().collect(Collectors.toList());
        cook();
        System.out.println(dp[order]);

    }

    public static void cook() {

        for (int i = 0; i < order+1; i++) {
            for (int j = 0; j < wok.size(); j++) {
                if(i<wok.get(j)) break;
                else if(i==wok.get(j)){
                    dp[i]=1;
                    break;
                }else if(dp[i-wok.get(j)]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-wok.get(j)]+1);
                }
            }
        }
    }
}