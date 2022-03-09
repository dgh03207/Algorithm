package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj13910 {
    static int N, mywok[], order, answer;
    static List<Integer> wok = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = Integer.MAX_VALUE;
        order = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        mywok = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mywok[i] = Integer.parseInt(st.nextToken());
            if (mywok[i] <= order) {
                wok.add(mywok[i]);
            }
        }


        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (mywok[i] + mywok[j] <= order) {
                    wok.add(mywok[i] + mywok[j]);
                }
            }

            wok = wok.stream().sorted(Collections.reverseOrder()).distinct().collect(Collectors.toList());
            cook(0, 0);
            System.out.println(answer);
        }

    }
    public static void cook(int result,int cnt){
        for (int i = 0; i < wok.size(); i++) {
            if (result + wok.get(i) < order) {
                cook(result+wok.get(i),cnt+1);
            }else if(result==wok.get(i)){
                if(cnt<answer) answer = cnt+1;
                break;
            }
        }
    }
}
