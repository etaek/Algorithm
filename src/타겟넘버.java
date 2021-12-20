public class 타겟넘버 {

    public static void main(String[] args) {
        int[] numbers={1,1,1,1,1};

        int target=3;

        int answer= solution(numbers,target);
        System.out.println(answer);
    }
    static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers,target,0,0);

        return answer;
    }
    public static void dfs(int []numbers,int target,int sum,int idx){
        if(idx==numbers.length){
            if(sum==target){
                answer++;

            }
            return;
        }


        dfs(numbers,target,sum+numbers[idx],idx+1);
        dfs(numbers,target,sum-numbers[idx],idx+1);

    }

}
