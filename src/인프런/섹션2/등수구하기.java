package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 등수구하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String str[]=br.readLine().split(" ");
        int rank[]=new int[num];
        for(int i=0;i<num;i++){
            int n1=Integer.parseInt(str[i]);
            int cnt=1;
            for(int j=0;j<num;j++){
                if(i==j) continue;
                int n2=Integer.parseInt(str[j]);
                if(n1<n2)
                    cnt++;

            }
            rank[i]=cnt;
        }

        for(int i=0;i<rank.length;i++){
            System.out.print(rank[i]+" ");
        }
    }
}
