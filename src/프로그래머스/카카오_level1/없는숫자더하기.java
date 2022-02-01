package 프로그래머스.카카오_level1;

import java.util.Arrays;

public class 없는숫자더하기 {

    public static void main(String[] args) {
        int []numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int temp[]=new int[10];
        for(int i=0;i<=9;i++){
            temp[i]=i;
        }

        for(int i=0;i<numbers.length;i++){
            temp[numbers[i]]=0;
        }

        for(int i=0;i<temp.length;i++){
            if(temp[i]==0) continue;
            answer+=temp[i];
        }
        return answer;
    }
}
