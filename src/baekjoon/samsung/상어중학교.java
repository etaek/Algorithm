package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


class Point{
	int x,y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
}

class Standard implements Comparable<Standard>{
	int x,y;
	int num;
	public Standard(int num,int x,int y) {
		this.num=num;
		this.x=x;
		this.y=y;
	}

	@Override
	public int compareTo(Standard o) {
		// TODO Auto-generated method stub
		if(this.x==o.x) {
			return this.y-o.y;
		}
		return this.x-o.x;
	}
}
class Score implements Comparable<Score>{
	int num;
	int x,y;
	int size;
	int rainbow;
	boolean check[][];
	
	public Score(int num,int x,int y,int size,int rainbow,boolean check[][]) {
		this.num=num;
		this.x=x;
		this.y=y;
		this.size=size;
		this.rainbow=rainbow;				
		this.check=check;
	}
	
	@Override
	public int compareTo(Score o) {
		if(o.size==this.size) {
			
			if(o.rainbow==this.rainbow) {
				
				if(o.x==this.x) {
					return o.y-this.y;
				}
				
				return o.x-this.x;
			}
			
			return o.rainbow-this.rainbow;
		}
		return o.size-this.size;
	}
}
public class 상어중학교 {

	static int map[][];
	static int n,m;
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static int answer=0;
	static ArrayList<Score>list=new ArrayList<>();
	static ArrayList<Standard>s_list=new ArrayList<>();
	//static boolean check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		m=Integer.parseInt(str[0]);
		n=Integer.parseInt(str[1]);
		
		map=new int[m][m];
	//	check=new boolean[m][m];
		for(int i=0;i<m;i++) {
			String arr[]=br.readLine().split(" ");
			
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(arr[j]);
			}
		}
		
		
		while(true) {
			
			findBlock();
			if(list.size()==0) break;
			
			Collections.sort(list);
			Score s=list.get(0);
			
			if(s.size<2) break;
						
			answer+=(s.size*s.size);
			list.remove(0);
			
			for(int i=0;i<s.check.length;i++) {
				for(int j=0;j<s.check.length;j++){
					if(s.check[i][j]) {
						map[i][j]=99;
					}
				}
			}
			
			gravity();
			
			move();
			
			gravity();
	
			list.clear();
		}
		System.out.println(answer);
	}
	
	public static void move() {
		int map_copy[][]=new int[m][m];
		
		int idx=m-1;
		for(int i=0;i<m;i++) {
			
			for(int j=0;j<m;j++) {
				map_copy[i][j]=map[j][idx];
			}
			idx--;
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=map_copy[i][j];
			}
		}
	}
	
	public static void gravity() {
		
		for(int i=m-1;i>=0;i--) {
			
			for(int j=m-1;j>=0;j--) {
				if(map[i][j]==99) {
					int idx=i;
					while(true) {
						idx--;
						if(idx<0) break;
						
						if(idx>=0 && map[idx][j]==-1) {
							break;
						}
						
						if(idx>=0 && map[idx][j]!=-1 && map[idx][j]!=99) {
							map[i][j]=map[idx][j];
							map[idx][j]=99;
							break;
						}
					}
					
				}
				
			}
		}
		
	}
	
	public static void findBlock() {
		
		for(int i=1;i<=n;i++) {
			
			for(int j=0;j<m;j++) {
				for(int k=0;k<m;k++) {
					if(map[j][k]==i) {
						s_list.add(new Standard(i,j,k));
						bfs(i,j,k);
						s_list.clear();
					}
				}
			}
		}

	}
	public static void bfs(int num,int a,int b) {
		
	//	System.out.println(num+","+a+","+b);
		Queue<Point> que=new LinkedList<>();
		que.add(new Point(a,b));
		boolean check[][]=new boolean[m][m];
		int cnt=1;
		check[a][b]=true;
		int rainbow=0;
		while(!que.isEmpty()) {
			Point p=que.poll();
		//	System.out.println(p.x+","+p.y);
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
			//	System.out.println(nx+","+ny);
				if(nx>=0 && ny>=0 && nx<m && ny<m && map[nx][ny]!=-1 && map[nx][ny]!=99) {
					if(check[nx][ny]) continue;
					
					if(map[nx][ny]==num || map[nx][ny]==0) {
						//System.out.println(nx+","+ny);
						if(map[nx][ny]==0) {
							rainbow++;
						}else {
							s_list.add(new Standard(num,nx,ny));
						}
						check[nx][ny]=true;
						que.add(new Point(nx,ny));
						cnt++;
					}else {
						continue;
					}
					
					
					
					
				}
			}
			
			
		}
		Collections.sort(s_list);
		Standard s=s_list.get(0);
		
		list.add(new Score(s.num,s.x,s.y,cnt,rainbow,check));
		
		
	}
}
