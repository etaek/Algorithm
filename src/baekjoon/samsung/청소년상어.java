package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Direction{
	int x,y;
	public Direction(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
class Fish{
	int x,y;
	int direct;
	public Fish(int x,int y,int direct) {
		this.x=x;
		this.y=y;
		this.direct=direct;

	}
}
public class 청소년상어 {
	
	static HashMap<Integer,Direction> map=new HashMap<>();
	static HashMap<Integer,Fish> fish=new HashMap<>();
	static boolean check[][]=new boolean[4][4];
	static int[][]arr;
	static int target=0;
	static int answer=0;
	static boolean die[]=new boolean[17];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		map.put(1, new Direction(-1,0));
		map.put(2, new Direction(-1,-1));
		map.put(3, new Direction(0,-1));
		map.put(4, new Direction(1,-1));
		map.put(5, new Direction(1,0));
		map.put(6, new Direction(1,1));
		map.put(7, new Direction(0,1));
		map.put(8, new Direction(-1,1));
		
		arr=new int[4][4];
		int num=0;
		int idx=0;
		for(int i=0;i<4;i++) {
			String str[]=br.readLine().split(" ");
			idx=0;
			for(int j=0;j<str.length;j++) {
				if(j%2==1) {
					fish.put(num,new Fish(i,idx,Integer.parseInt(str[j])));
					idx++;
					continue;
				}
				if(idx>=4) break;
				arr[i][idx]=Integer.parseInt(str[j]);
				num=arr[i][idx];
				
				
			}
		}
		//System.out.println(fish.get(14).x+","+fish.get(14).y+","+fish.get(14).direct);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=================================================");
		target=arr[0][0];
		die[target]=true;
		int target_direct=fish.get(target).direct;
		arr[0][0]=99; //상어
		fish.put(arr[0][0], new Fish(0,0,target_direct));
		check[0][0]=true;
		moveFish();
		HashMap<Integer,Direction> map2=new HashMap<>();
		HashMap<Integer,Fish> fish2=new HashMap<>();
		
		for(int i: map.keySet()) {
			map2.put(i, new Direction(map.get(i).x,map.get(i).y));
		}
		for(int i: fish.keySet()) {
			fish2.put(i, new Fish(fish.get(i).x,fish.get(i).y,fish.get(i).direct));
		}
		
		int first[][]=new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				first[i][j]=arr[i][j];
			}
		}
		Fish f=fish.get(target);
		int direct=f.direct;
		int move_x=map.get(direct).x;
		int move_y=map.get(direct).y;
		for(int i=1;i<=3;i++) {
			int temp_x=(move_x*i);
			int temp_y=(move_y*i);
			if(i==1 | i==3) continue;
			for(int k=0;k<arr.length;k++) {
				for(int j=0;j<arr.length;j++) {
					System.out.print(arr[k][j]+" ");
				}
				System.out.println();
			}
			System.out.println("******************");
			die=new boolean[17];
			eatFish(0,0,temp_x,temp_y);
			System.out.println(answer);
			answer=0;
			map.clear();
			fish.clear();
			
			for(int j=0;j<first.length;j++) {
				for(int k=0;k<first.length;k++) {
					arr[j][k]=first[j][k];
				}
			}
			for(int j: map2.keySet()) {
				map.put(j, new Direction(map2.get(j).x,map2.get(j).y));
			}
			for(int j: fish2.keySet()) {
				fish.put(j, new Fish(fish2.get(j).x,fish2.get(j).y,fish2.get(j).direct));
			}
			
		}
		
	
	}
	public static void eatFish(int x,int y,int temp_x,int temp_y) {

		System.out.println(temp_x+","+temp_y);
		if(temp_x>=0 && temp_y >=0 && temp_x<4 && temp_y<4) {
			Fish f=fish.get(arr[temp_x][temp_y]);
			int direct=f.direct;
			int move_x=map.get(direct).x;
			int move_y=map.get(direct).y;
			
			answer+=arr[temp_x][temp_y];
			arr[x][y]=0;
			die[arr[temp_x][temp_y]]=true;
			arr[temp_x][temp_y]=99;
			fish.put(arr[temp_x][temp_y],new Fish(temp_x,temp_y,direct));
			
			for(int k=0;k<arr.length;k++) {
				for(int j=0;j<arr.length;j++) {
					System.out.print(arr[k][j]+" ");
				}
				System.out.println();
			}
			System.out.println("#############################");
			
			
			moveFish();
			eatFish(temp_x,temp_y,temp_x+move_x,temp_y+move_y);
		}else {
			return;
		}
		
		
	}
	
	public static void moveFish() {
	
		
		for(int i=1;i<=16;i++) {
			Fish f=fish.get(i);
			int x=f.x;
			int y=f.y;
			int direct=f.direct;
			if(i==target) continue;
			if(die[i]) continue;
			
			for(int j=0;j<7;j++) {
				int move_x=map.get(direct).x;
				int move_y=map.get(direct).y;
				int temp_x=x+move_x;
				int temp_y=y+move_y;
				
				if(temp_x>=0 && temp_y >=0 && temp_x<4 && temp_y<4) {
					if(arr[temp_x][temp_y]==99) {
						if(direct==8) {
							direct=1;
						}else {
							direct++;
						}
						continue;
					}else {
						if(arr[temp_x][temp_y]==0) {
							arr[temp_x][temp_y]=arr[x][y];
							arr[x][y]=0;
							fish.put(arr[temp_x][temp_y],new Fish(temp_x,temp_y,direct));
							continue;
						}
						int direct2=fish.get(arr[temp_x][temp_y]).direct;
						int temp=arr[temp_x][temp_y];
						arr[temp_x][temp_y]=arr[x][y];
						arr[x][y]=temp;
						fish.put(arr[temp_x][temp_y], new Fish(temp_x,temp_y,direct));
						fish.put(arr[x][y], new Fish(x,y,direct2));
						break;
					}
					
				}else {
					if(direct==8) {
						direct=1;
					}else {
						direct++;
					}
					continue;
				}
			}
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr.length;k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			
		}
		
		for(int j=0;j<arr.length;j++) {
			for(int k=0;k<arr.length;k++) {
				Fish f=fish.get(arr[j][k]);
				System.out.print(f.direct+" ");
			}
			System.out.println();
		}
		System.out.println("===================================");
		
	}

}
