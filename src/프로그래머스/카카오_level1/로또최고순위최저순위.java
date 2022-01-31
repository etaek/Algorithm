package 프로그래머스.카카오_level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 로또최고순위최저순위 {
    public static void main(String[] args) {
        int[] lottos={45, 4, 35, 20, 3, 9};
        int []win_nums = {20, 9, 3, 45, 4, 35};

        int answer[]=solution(lottos,win_nums);

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }


    }


    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        ArrayList<Integer>list=new ArrayList<>();
        int cnt=0;
        int result=0;
        for(int i=0;i<win_nums.length;i++){
            list.add(win_nums[i]);
        }
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                cnt++;
                continue;
            }
            if(list.contains(lottos[i])){
                result++;
            }
        }
        int rank=0;
        answer=new int[2];
        for(int i=0;i<2;i++){
            if(i==0){
                result+=cnt;
            }else {
                result -= cnt;
            }
            switch (result){
                case 6: rank=1; break;
                case 5: rank=2; break;
                case 4: rank=3; break;
                case 3: rank=4; break;
                case 2: rank=5; break;
                default : rank=6;
            }
            answer[i]=rank;
        }

        return answer;
    }
}
