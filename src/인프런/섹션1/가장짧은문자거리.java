package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 가장짧은문자거리 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        String s[]= str[0].split("");
        String t=str[1];

        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals(t)){
                list.add(i);
            }
        }
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals(t)){
                result.add(0);
                continue;
            }

            int min=101;
            for(int in:list){
                if(min>(Math.abs(in-i))){
                    min=Math.abs(in-i);
                }
            }
            result.add(min);
        }
        for(int i:result){
            System.out.print(i+" ");
        }


    }
}
