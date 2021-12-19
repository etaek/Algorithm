package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 바이러스 {

    static ArrayList<Integer>list[];
    static boolean check[];
    static int answer=0;
    public static void main(String[] args) throws IOException {


        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int v=Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());

        list=new ArrayList[v+1];
        check=new boolean[v+1];
        for(int i=1;i<=v;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            String str[]=br.readLine().split(" ");
            int s=Integer.parseInt(str[0]);
            int e=Integer.parseInt(str[1]);
            list[s].add(e);
            list[e].add(s);
        }

        dfs(1);


        System.out.println(answer);

    }

    public static void dfs(int node){
        if(check[node]) return;
        check[node]=true;
        for(int i : list[node]){
            if(check[i]) continue;
            answer++;
            dfs(i);

        }

    }
}
