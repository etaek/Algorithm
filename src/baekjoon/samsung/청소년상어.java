//package baekjoon.samsung;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//
//class Fish{
//	int num;
//	int x,y;
//	int direct;
//	int alive;
//
//	public Fish(int num,int x,int y,int direct,int alive) {
//		this.num=num;
//		this.x=x;
//		this.y=y;
//		this.direct=direct;
//		this.alive=alive;
//	}
//}
//public class 청소년상어 {
//
//
//	static int[][]map=new int[4][4];
//	static int[] dx= {-1,-1,0,1,1,1,0,-1};
//	static int[] dy= {0,-1,-1,-1,0,1,1,1};
//	static Fish[] fish=new Fish[17];
//	static int answer=0;
//
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		/*초기 물고기 설정*/
//		for(int i=0;i<4;i++) {
//			st= new StringTokenizer(br.readLine());
//
//			for(int j=0;j<4;j++) {
//				int a= Integer.parseInt(st.nextToken());
//				int b= Integer.parseInt(st.nextToken())-1;
//				map[i][j]=a;
//				fish[a]=new Fish(a,i,j,b,1);
//			}
//
//		}
//
//		int first=map[0][0];
//		fish[first].alive=0;
//		map[0][0]=99;
//
//
//
//
//		eatFish(0,0,fish[first].direct,first);
//		System.out.println(answer);
//	}
//
//	public static void eatFish(int sx,int sy,int sd,int eat) {
//		answer=answer>eat?answer:eat;
//
//
//
//		int map_copy[][]=new int[4][4];
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<4;j++) {
//				map_copy[i][j]=map[i][j];
//			}
//		}
//
//		Fish[] fish_copy=new Fish[17];
//		for(int i=1;i<17;i++) {
//			fish_copy[i] = new Fish(i,fish[i].x,fish[i].y,fish[i].direct,fish[i].alive);
//		}
//
//		moveFish();
//
//		for(int i=1;i<=3;i++) {
//			int nx=sx+(dx[sd] * i);
//			int ny=sy+(dy[sd] * i);
//
//			if(nx>=0 && ny>=0 && nx<4 && ny< 4 && map[nx][ny]!=0) {
//				int target=map[nx][ny];
//				fish[target].alive=0;
//				map[nx][ny]=99;
//				map[sx][sy]=0;
//
//				eatFish(nx,ny,fish[target].direct,eat+target);
//
//				fish[target].alive=1;
//				map[nx][ny]=target;
//				map[sx][sy]=99;
//			}
//
//
//
//		}
//		for(int j=0;j<4;j++) {
//			for(int k=0;k<4;k++) {
//				map[j][k]=map_copy[j][k];
//			}
//		}
//
//
//		for(int j=1;j<17;j++) {
//			fish[j] = new Fish(fish_copy[j].num,fish_copy[j].x,fish_copy[j].y,fish_copy[j].direct,fish_copy[j].alive);
//		}
//
//
//
//
//	}
//
//	public static void moveFish() {
//
//		for(int i=1;i<=16;i++) {
//			if(fish[i].alive==0) continue;
//
//			int x=fish[i].x;
//			int y=fish[i].y;
//			int dir=fish[i].direct;
//			for(int j=0;j<8;j++) {
//
//				int nx=x+dx[dir];
//				int ny=y+dy[dir];
//
//				if(nx>=0 && ny>=0 && nx<4 && ny<4 && map[nx][ny]!=99) {
//					if(map[nx][ny]==0) {
//						map[nx][ny]=i;
//						map[x][y]=0;
//						fish[i].x=nx;
//						fish[i].y=ny;
//						fish[i].direct=dir;
//
//					}else {
//						int temp=map[nx][ny];
//						fish[temp].x=x;
//						fish[temp].y=y;
//
//						fish[i].x=nx;
//						fish[i].y=ny;
//						fish[i].direct=dir;
//
//						map[nx][ny]=i;
//						map[x][y]=temp;
//					}
//					break;
//				}else {
//					if(dir==7) {
//						dir=0;
//					}else {
//						dir++;
//					}
//				}
//
//
//
//			}
//		}
//
//	}
//}
