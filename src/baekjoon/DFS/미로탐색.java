package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int maze[][];
    static int n,m;
    static boolean check[][];
    public static void main(String[] args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str[]=br.readLine().split(" ");
        n= Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        maze=new int[n][m];
        check=new boolean[n][m];
        for(int i=0;i<n;i++){
            String[] arr=br.readLine().split("");
            for(int j=0;j<arr.length;j++){
                maze[i][j]=Integer.parseInt(arr[j]);
            }
        }
        bfs();
        System.out.println(maze[n-1][m-1]);
    }
    public static void bfs(){
        Queue<Integer> que_x=new LinkedList<>();
        Queue<Integer> que_y=new LinkedList<>();
        que_x.offer(0);
        que_y.offer(0);
        check[0][0]=true;
        while(!que_x.isEmpty()){
            int x=que_x.poll();
            int y=que_y.poll();

            for(int i=0;i<4;i++){
                int temp_x=x+dx[i];
                int temp_y=y+dy[i];

                if(temp_x>=0 && temp_y>=0 && temp_x<n && temp_y<m){
                    if(maze[temp_x][temp_y]==1 && !check[temp_x][temp_y]){
                        que_x.offer(temp_x);
                        que_y.offer(temp_y);
                        check[temp_x][temp_y]=true;
                        maze[temp_x][temp_y]=maze[x][y]+1;
                    }
                }
            }
        }

    }
}
