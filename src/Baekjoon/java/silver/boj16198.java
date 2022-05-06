package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj16198 {
    static int answer =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> marbles = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            marbles.add(Integer.parseInt(st.nextToken()));
        }
        dfs(marbles,0);
        System.out.println(answer);

    }

    private static void dfs(ArrayList<Integer> marbles, int weight){
        if(marbles.size()==3){
            weight += marbles.get(0)*marbles.get(2);
            if(answer< weight) answer = weight;
            return;
        }

        for (int i = 1; i < marbles.size()-1; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>)marbles.clone();
            temp.remove(i);
            dfs(temp,weight+(temp.get(i-1)*temp.get(i)));
        }
    }


}
