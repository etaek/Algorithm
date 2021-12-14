import java.util.*;

public class Crane_Game {
    static Stack<Integer>stack=new Stack<>();

    public static void main(String[] args) {
        int[][]board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[]moves={1,5,3,5,1,2,1,4};
        int result=solution(board,moves);
        System.out.println(result);
    }

    public static int solution(int[][] board, int[] moves){
        int answer=0;

        for(int i=0;i<moves.length;i++){
            int num=moves[i];

            for(int j=0;j<board.length;j++){
                if(board[j][num-1]==0) continue;
                answer+=2*check(board[j][num-1]);
                board[j][num-1]=0;
                break;
            }
        }
        return answer;
    }
    public static int check(int num){
        int result=0;

        if(!stack.isEmpty()){
            if(num==stack.peek()){
                stack.pop();
                result++;
            }else{
                stack.add(num);
            }
        }else{
            stack.add(num);
        }
        return result;
    }
}
