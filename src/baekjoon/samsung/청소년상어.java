package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Direct{
	int x,y;
	public Direct(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

class Shark{
	int x,y,direct;
	public Shark() {
		
	}
	public Shark(int x,int y,int direct) {
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}

class Fish implements Comparable<Fish>{
	int num;
	int x,y;
	int direct;

	public Fish(int num,int x,int y,int direct) {
		this.num=num;
		this.x=x;
		this.y=y;
		this.direct=direct;
	}

	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		return this.num-o.num;
	}
	
	
}

public class 청소년상어 {
	
	static HashMap<Integer,Direct> cycle=new HashMap<>();
	static int sea[][]=new int[4][4];
	static ArrayList<Fish>list=new ArrayList<>();
	static int answer=0;
	static Shark shark;
	static boolean dead[]=new boolean[17];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		cycle.put(1, new Direct(-1,0));
		cycle.put(2, new Direct(-1,-1));
		cycle.put(3, new Direct(0,-1));
		cycle.put(4, new Direct(1,-1));
		cycle.put(5, new Direct(1,0));
		cycle.put(6, new Direct(1,1));
		cycle.put(7, new Direct(0,1));
		cycle.put(8, new Direct(-1,1));
		
		/*초기 물고기 설정*/
		for(int i=0;i<4;i++) {
			String str[]=br.readLine().split(" ");
			int idx=0;

			for(int j=0;j<str.length;j++) {
				if(j%2==1) {
					list.add(new Fish(sea[i][idx],i,idx,Integer.parseInt(str[j])));
					idx++;
					continue;
				}
				sea[i][idx]=Integer.parseInt(str[j]);
				
			}
					
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(sea[i][j]+" ");
			}
			System.out.println();
		}
		Collections.sort(list);
		
		eatFish(0,0,list.get(sea[0][0]-1).direct,sea[0][0]);
		
		System.out.println(answer);
	
	}
	public static void eatFish(int x,int y,int sd,int eat) {
		
		answer= Math.max(answer,eat);
		
		int sea_copy[][]=new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sea_copy[i][j]=sea[i][j];
			}
		}
		ArrayList<Fish>list_copy=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			list_copy.add(new Fish(list.get(i).num,list.get(i).x,list.get(i).y,list.get(i).direct));
		}
		
		moveFish();
		

		int move_x=cycle.get(sd).x;
		int move_y=cycle.get(sd).y;

		
		for(int i=1;i<=3;i++) {
			int nx=x+(move_x*i);
			int ny=y+(move_y*i);
		
			if(nx>=0 && ny>=0 && nx<4 && ny<4 && sea[nx][ny]!=0) {
				int eatFish=sea[nx][ny];
				int dir=list.get(eatFish-1).direct;
				sea[x][y]=0;
				sea[nx][ny]=99;
				dead[eatFish]=true;
				
				eatFish(nx,ny,dir,eatFish);
				
				dead[eatFish]=false;
				sea[x][y]=99;
				sea[nx][ny]=eatFish;
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sea[i][j]=sea_copy[i][j];
			}
		}
		
		list.clear();
		for(int i=0;i<list_copy.size();i++) {
			list.add(new Fish(list_copy.get(i).num,list_copy.get(i).x,list_copy.get(i).y,list_copy.get(i).direct));
		}
		Collections.sort(list);
		
	}

	public static void moveFish() {
		
		
	}
}
