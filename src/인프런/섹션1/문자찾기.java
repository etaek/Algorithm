package 인프런.섹션1;

import java.util.Locale;
import java.util.Scanner;

public class 문자찾기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1=in.next();
        String input2=in.next();

        input1=input1.toUpperCase();
        input2=input2.toUpperCase();

        int answer=0;
        for(int i=0;i<input1.length();i++){
            if(input1.charAt(i) == input2.charAt(0)){
                answer++;
            }
        }
        System.out.println(answer);

    }
}
