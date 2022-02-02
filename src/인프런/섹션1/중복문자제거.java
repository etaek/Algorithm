package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 중복문자제거 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("");
        ArrayList<String>list=new ArrayList<>();

        for(String s:str){
            if(!list.contains(s)){
                list.add(s);
            }
        }
        String answer="";
        for(String s : list){
            answer+=s;
        }
        System.out.println(answer);
    }
}
