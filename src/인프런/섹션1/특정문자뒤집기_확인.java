package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정문자뒤집기_확인 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        char arr[]=str.toCharArray();
        String result="";
        int lt=0;
        int rt=arr.length-1;

        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt])){
                lt++;
            }else if(!Character.isAlphabetic(arr[rt])){
                rt--;
            }else{
                char temp=arr[rt];
                arr[rt]=arr[lt];
                arr[lt]=temp;
                lt++;rt--;
            }
        }
        String answer=String.valueOf(arr);
        System.out.println(answer);
    }
}
