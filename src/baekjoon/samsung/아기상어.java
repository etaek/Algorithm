package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


class Fish implements Comparable<Fish>{
	int x;
	int y;
	int value;
	public Fish(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Fish(int x,int y,int value) {
		this.x=x;
		this.y=y;
		this.value=value;
	}

	@Override
	public int compareTo(Fish o) {
		if(o.value==this.value) {
			
			if(this.x==o.x) {
				return this.y-o.y; 
			}
			
			return this.x-o.x;
			
		}
		
		return this.value-o.value;
	}
}
public class 아기상어 {

	static int baby=2;
	static int n;
	static int arr[][];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	
	static int eat=0;
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		// TODO Auto-generated method stub
        
        n=Integer.parseInt(br.readLine());
        arr=new int[n][n];
     
        int start_x=0;
    	int start_y=0;
        for(int i=0;i<n;i++) {
        	String str[]=br.readLine().split(" ");
        	
        	for(int j=0;j<str.length;j++) {
        		arr[i][j]=Integer.parseInt(str[j]);
        		if(arr[i][j]==9) {
        			start_x=i;
        			start_y=j;
        		}
        	}
        			
        }
        arr[start_x][start_y]=0;
        bfs(start_x,start_y);
        System.out.println(answer);
  
        

	}
	public static void bfs(int start_x,int start_y) {
		
		Queue<Fish> que=new LinkedList<>();
		
		que.add(new Fish(start_x,start_y,0));
		ArrayList<Fish>list=new ArrayList<>();
		
		int score[][]=new int[n][n];
		while(!que.isEmpty()) {
			Fish f=que.poll();
	
			for(int i=0;i<4;i++) {
				int x=f.x+dx[i];
				int y=f.y+dy[i];
				
				if(x>=0&&y>=0&&x<n&&y<n && arr[x][y]<=baby && score[x][y]==0) {
					score[x][y]=score[f.x][f.y]+1;
					
					if(arr[x][y]!=0 && arr[x][y]!=baby) {
						list.add(new Fish(x,y,score[x][y]));
					}
					que.add(new Fish(x,y,score[x][y]));
				}
			}
		}
		
		if(list.size()==0) {
			return;
		}
		
		Collections.sort(list);
		Fish f=list.get(0);
		int x=f.x;
		int y=f.y;
		int value=f.value;
		
		arr[x][y]=0;
		answer+=value;
		eat++;
		if(eat==baby) {
			eat=0;
			baby++;
		}
		bfs(x,y);
		
	}

}
