package 프로그래머스.카카오_level1;

import java.util.ArrayList;
import java.util.Collections;

class Game implements Comparable<Game>{

    int stage;
    double rate;

    public Game(int stage,double rate){
        this.stage=stage;
        this.rate=rate;
    }

    @Override
    public int compareTo(Game o){
        if(Double.compare(o.rate,this.rate)==0){
            return (int)o.rate-(int)this.rate;
        }
        else if(Double.compare(o.rate,this.rate)>0){
            return 1;
        }else{
            return -1;
        }
    }


}

public class failrate {

    public static void main(String[] args) {
        int n=5;
        int stages[]={2, 1, 2, 6, 2, 4, 3, 3};

        int answer[]={};
        answer=new int [n];
        boolean check[]=new boolean[stages.length];
        int total=stages.length;
        ArrayList<Game> list=new ArrayList<>();

        int cnt=0;
        for(int j=1;j<=n;j++) {
            total=total-cnt;
            cnt=0;

            for (int i = 0; i < stages.length; i++) {
                if(check[i]) continue;
                if(j>=stages[i]){
                    cnt++;
                    check[i]=true;
                }
            }
            double num =0;
            if(total==0){
                num=0;
            }else {
                num = (double)cnt / total;
            }
            list.add(new Game(j,num));

        }
        Collections.sort(list);
        for(int i=0;i<n;i++){
            answer[i]=list.get(i).stage;
            System.out.println(answer[i]+","+list.get(i).rate);
        }




    }
}

