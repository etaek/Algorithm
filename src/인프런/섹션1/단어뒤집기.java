package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int num=Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            String str[]=br.readLine().split("");
            String temp="";
            for(int j=str.length-1;j>=0;j--){
                temp+=str[j];
            }
            System.out.println(temp);
        }



    }

}
