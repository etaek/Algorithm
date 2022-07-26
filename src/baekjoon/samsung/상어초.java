package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student{
    int num;
    String[] friends;

    public Student(int num,String[]friends){
        this.num=num;
        this.friends=friends;
    }
}

class Seat implements Comparable<Seat>{
    int x,y;
    int value;

    public Seat(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;

    }

    @Override
    public int compareTo(Seat o) {
        if(o.value-this.value ==0) {
            if (this.x - o.x == 0) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
        return o.value-this.value;
    }
}
public class 상어초 {


    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int n;
    static int seat[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        seat=new int[n][n];
        ArrayList<Student>list=new ArrayList<>();
        HashMap<Integer,String[]> map=new HashMap<>();
        for(int i=0;i<n*n;i++){
            String str[]=br.readLine().split(" ");
            map.put(Integer.parseInt(str[0]),str);
            list.add(new Student(Integer.parseInt(str[0]),str));
            findFriend(str);

        }

        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=seat[i][j];
                String str[]=map.get(num);
                int score= calcScore(i,j,str);

                if(score ==1){
                    answer+=1;
                }else if(score==2){
                    answer+=10;
                }else if(score==3){
                    answer+=100;
                }else if(score==4){
                    answer+=1000;
                }

            }
        }
        System.out.println(answer);

    }

    public static void findFriend(String str[]){
        int num=Integer.parseInt(str[0]);
        ArrayList<Seat> list=new ArrayList<>();
       // int clone[][]=seat.clone();
        int clone[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                clone[i][j]=seat[i][j];
            }
        }
        for(int i=1;i<str.length;i++){
            int f=Integer.parseInt(str[i]);
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(seat[j][k]==f){
                        list.add(new Seat(j,k,f));
                    }
                }
            }
        }

        if(list.size()==0){
            emptySeat(clone,num);
        }else{
            findFriendSeat(list,clone,num);
        }


    }

    public static void findFriendSeat(ArrayList<Seat> list,int clone[][],int st_num){

        boolean check[][]=new boolean[n][n];
        int arr[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=clone[i][j];
                if(arr[i][j]!=0){
                    check[i][j]=true;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            Seat s=list.get(i);
            for(int j=0;j<4;j++){
                int x=s.x+dx[j];
                int y=s.y+dy[j];

                if(x>=0&&y>=0&&x<n&&y<n){
                    if(!check[x][y]){
                        arr[x][y]+=1;
                    }
                }
            }

        }


        int max=0;
        Queue<Seat> que=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(check[i][j]) continue;
                if(max<arr[i][j]){
                    max=arr[i][j];
                }
                que.add(new Seat(i,j,arr[i][j]));
            }
        }
        ArrayList<Seat> temp=new ArrayList<>();
        while(!que.isEmpty()){
            Seat s=que.poll();

            if(s.value==max){
                temp.add(s);
            }
        }
        Collections.sort(temp);

        if(temp.size()==1){
            Seat s=temp.get(0);
            seat[s.x][s.y]=st_num;

        }else{
            findEmptySeat(arr,temp,st_num);

        }
    }

    public static void findEmptySeat(int[][] arr,ArrayList<Seat> list,int st_num){

        ArrayList<Seat> answer=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Seat s=list.get(i);
            int cnt=0;
            for(int j=0;j<4;j++){
                int x=s.x+dx[j];
                int y=s.y+dy[j];

                if(x>=0&&y>=0&&x<n&&y<n){
                    if(seat[x][y]==0){
                        cnt++;
                    }
                }
            }
            answer.add(new Seat(s.x,s.y,cnt));

        }

        Collections.sort(answer);
        Seat s=answer.get(0);

        seat[s.x][s.y]=st_num;
    }

    public static void emptySeat(int [][]arr,int st_num){
        int cnt=0;
        ArrayList<Seat> answer=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cnt=0;
                if(seat[i][j]!=0) continue;
                for(int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];

                    if(x>=0&&y>=0&&x<n&&y<n){
                        if(arr[x][y]==0){
                            cnt++;
                        }
                    }
                }

                answer.add(new Seat(i,j,cnt));
            }
        }


        Collections.sort(answer);

        Seat s= answer.get(0);

        seat[s.x][s.y]=st_num;
    }

    public static int calcScore(int a,int b,String str[]){
        int cnt=0;
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=1;i<str.length;i++){
            list.add(Integer.parseInt(str[i]));
        }

        for(int i=0;i<4;i++){
            int x=a+dx[i];
            int y=b+dy[i];

            if(x>=0 && y>=0 && x<n && y<n){
                if(list.contains(seat[x][y])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
