package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Point{
	int x,y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
}
public class 상어중학교 {

	static int map[][];
	static int n,m;
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		m=Integer.parseInt(str[0]);
		n=Integer.parseInt(str[1]);
		
		map=new int[m][m];
		for(int i=0;i<m;i++) {
			String arr[]=br.readLine().split(" ");
			
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(arr[j]);
			}
		}
		
		findBlock();
		
	}
	
	public static void findBlock() {
		
		for(int i=1;i<=n;i++) {
			if(i==2 || i==1) continue;
			for(int j=0;j<m;j++) {
				for(int k=0;k<m;k++) {
					if(map[j][k]==i) {
						bfs(i,j,k);
						System.out.println("=================");
					}
				}
			}
		}
	}
	public static void bfs(int num,int a,int b) {
		answer=0;
		System.out.println(num+","+a+","+b);
		Queue<Point> que=new LinkedList<>();
		que.add(new Point(a,b));
		boolean check[][]=new boolean[m][m];
		int cnt=1;
		check[a][b]=true;
		while(!que.isEmpty()) {
			Point p=que.poll();
			System.out.println(p.x+","+p.y);
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				System.out.println(nx+","+ny);
				if(nx>=0 && ny>=0 && nx<m && ny<m && map[nx][ny]!=-1) {
					if(check[nx][ny]) continue;
					
					if(map[nx][ny]==num || map[nx][ny]==0) {
						System.out.println(nx+","+ny);
						check[nx][ny]=true;
						que.add(new Point(nx,ny));
						cnt++;
					}else {
						continue;
					}
					
					
					
					
				}
			}
			
			
		}
		System.out.println(cnt);
	}
}
