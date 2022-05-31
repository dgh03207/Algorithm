package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj19942 {


    static class Food{
        private int p;
        private int f;
        private int s;
        private int v;
        private int c;

        public Food(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }

        public boolean checkStandard(int[] standard){
            if(p<standard[0]){
                return false;
            }else if(f<standard[1]){
                return false;
            }else if(s<standard[2]){
                return false;
            }else if(v<standard[3]){
                return false;
            }
            return true;
        }

        public void addNutri(Food food){
            p+=food.p;
            f+=food.f;
            s+=food.s;
            v+=food.v;
            c+=food.c;
        }
        public void minusNutri(Food food){
            p-=food.p;
            f-=food.f;
            s-=food.s;
            v-=food.v;
            c-=food.c;
        }


    }
    static int N;
    static boolean[] checked;
    static boolean[] finalchecklist;
    static int minCost;
    static int[] standard;
    static Food[] foods;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        standard = new int[4];

        N = Integer.parseInt(br.readLine());
        checked = new boolean[N];
        finalchecklist = new boolean[N];

        minCost=Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            standard[i] = Integer.parseInt(st.nextToken());
        }

        foods = new Food[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            foods[i] = new Food(p,f,s,v,c);
        }
        dfs(checked,new Food(0,0,0,0,0),-1);
        if(minCost==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minCost);
            for (int i = 0; i < N; i++) {
                if(finalchecklist[i]){
                    System.out.print((i+1)+" ");
                }
            }
        }
    }

    private static void dfs(boolean[] checked, Food infos,int now){
        if(infos.checkStandard(standard)){
            if(minCost>infos.c){
                minCost = infos.c;
                finalchecklist=Arrays.copyOf(checked,N);
            }else if(minCost==infos.c){
                for (int i = 0; i < N; i++) {
                    if(finalchecklist[i]&&!checked[i]) break;
                    if(checked[i]&&!finalchecklist[i]){
                        finalchecklist = Arrays.copyOf(checked,N);
                        break;
                    }
                }
            }
            return;
        }
        for (int i = now+1; i < N; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            infos.addNutri(foods[i]);
            dfs(checked,infos,i);
            infos.minusNutri(foods[i]);
            checked[i] = false;
        }
    }
}

