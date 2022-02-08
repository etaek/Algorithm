package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가위바위보 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String arrA[]=br.readLine().split(" ");
        String arrB[]=br.readLine().split(" ");

        for(int i=0;i<num;i++){
            int a=Integer.parseInt(arrA[i]);
            int b=Integer.parseInt(arrB[i]);

            switch(a){
                case 1:
                    if(b==1) System.out.println("D");
                    if(b==2) System.out.println("B");
                    if(b==3) System.out.println("A");
                    break;
                case 2:
                    if(b==2) System.out.println("D");
                    if(b==3) System.out.println("B");
                    if(b==1) System.out.println("A");
                    break;
                case 3:
                    if(b==3) System.out.println("D");
                    if(b==1) System.out.println("B");
                    if(b==2) System.out.println("A");
                    break;
            }
        }
    }
}
