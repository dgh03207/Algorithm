package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17220 {
    static int N, M, S, answer;
    static boolean[][] graph;
    static boolean[] isvisit;
    static boolean[] origin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][N];
        isvisit = new boolean[N];
        origin = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = (int) st.nextToken().charAt(0) - 65;
            int b = (int) st.nextToken().charAt(0) - 65;
            origin[b] = true;
            graph[a][b] = true;
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < S; i++) {
            int s = (int) st.nextToken().charAt(0) - 65;
            isvisit[s] = true;
        }
        for (int i = 0; i < N; i++) {
            if(!origin[i]&&!isvisit[i]){
                dfs(i);
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int start) {
        isvisit[start] = true;
        for (int i = 0; i < N; i++) {
            if (!isvisit[i] & graph[start][i]) {
                answer += 1;
                dfs(i);
            }
        }
        return;
    }
}

//    //마약수사대
//    static HashMap<String, ArrayList<String>> drug_supply= new HashMap<>();
//    static int N,M,S;
//    static ArrayList<String> arrested;
//    static int answer;
//    static boolean origin[];
//    //A의 아스키 코드는 65
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        origin = new boolean[N];
//        answer = N;
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            String key = st.nextToken();
//            String related = st.nextToken();
//            if(!origin[(int)related.charAt(0)-65]) origin[(int)related.charAt(0)-65] = true;
//            if(!drug_supply.containsKey(key)) {
//                drug_supply.put(key,new ArrayList<>());
//            }
//            if(!drug_supply.containsKey(related))
//                drug_supply.put(related,new ArrayList<>());
//            drug_supply.get(key).add(related);
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int S = Integer.parseInt(st.nextToken());
//        arrested = new ArrayList<>();
//        for (int i = 0; i < S; i++) {
//            String arrested_one = st.nextToken();
//            arrested.add(arrested_one);
//            dfs(arrested_one);
//        }
//
//        for (int i = 0; i < N; i++) {
//            if(!origin[i]) answer-=1;
//        }
//
//        System.out.println(answer-arrested.size());
//    }
//
//    private static void dfs(String target){
//        if(drug_supply.get(target)==null){
//            return;
//        }
//
//        ArrayList<String> targets = drug_supply.get(target);
//        for (int i = 0; i < targets.size(); i++) {
//            if(!arrested.contains(targets.get(i))){
//                arrested.add(targets.get(i));
//                dfs(targets.get(i));
//            }
//        }
//    }
//}
