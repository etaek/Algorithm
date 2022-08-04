package 프로그래머스.카카오_level1;

public class LOTTO {
    public static void main(String[] args) {

        int[]lottos={45, 4, 35, 20, 3, 9};
        int[]win_nums={20, 9, 3, 45, 4, 35};

        int []answer=new int[2];
        int[]result={6,6,5,4,3,2,1};

        int cnt=0;
        int zero_cnt=0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                zero_cnt++;
                continue;
            }
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                }
            }
        }

        answer[0]=result[cnt+zero_cnt];
        answer[1]=result[cnt];

        System.out.println(answer[0]+","+answer[1]);
    }
}
