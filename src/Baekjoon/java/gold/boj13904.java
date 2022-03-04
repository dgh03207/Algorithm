package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//과제
public class boj13904 {

    private static class Hw{
        int day;
        int score;

        public Hw(int day, int score) {
            this.day = day;
            this.score = score;
        }

        public int getDay() {
            return day;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int finish = 0;
        List<Hw> hws = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            if(day>finish) finish = day;
            Hw hw = new Hw(day,score);
            hws.add(hw);
        }

        int[] orders = new int[finish];
        Arrays.fill(orders,0);
        hws = hws.stream().sorted(Comparator.comparing(Hw::getDay).thenComparing(Hw::getScore)).collect(Collectors.toList());

        for (int i = 0; i < hws.size(); i++) {
            Hw now = hws.get(i);

            if(orders[now.getDay()-1]==0) orders[now.getDay()-1]=now.getScore();
            else {
                int minIndex = 0;
                int min = orders[0];
                for (int j = 1; j < now.getDay(); j++) {
                    if(min>orders[j]){
                        min = orders[j];
                        minIndex = j;
                    }
                }
                if(min<now.getScore()){
                    orders[minIndex] = now.getScore();
                }
            }

        }

        System.out.println(Arrays.stream(orders).sum());
    
    }
}
