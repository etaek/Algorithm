public class PressKeyPad {

    public static void main(String[] args) {
        int [] numbers={1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        System.out.println(solution(numbers,hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right= 12;
        for(int i=0;i< numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 ||numbers[i]==7 ){
                answer+="L";
                left=numbers[i];
            }
            else if(numbers[i]== 3|| numbers[i]==6 ||numbers[i]==9 ){
                answer+="R";
                right=numbers[i];
            }
            else{
               int leftLength=getLength(left,numbers[i]);
               int rightLength=getLength(right,numbers[i]);

               if(leftLength>rightLength){
                   answer+="R";
                   right=numbers[i];
               }else if(leftLength<rightLength){
                   answer+="L";
                   left=numbers[i];
               }else{
                   if(hand.equals("right")){
                       answer+="R";
                       right=numbers[i];
                   }else{
                       answer+="L";
                       left=numbers[i];
                   }
               }
            }

        }
        return answer;
    }

    public static int getLength(int index,int number){
        if(index==0){
            index=11;
        }
        if(number==0){
            number=11;
        }
        int x=(index-1)/3;
        int y=(index-1)%3;
        int numberX=number/3;
        int numberY=1;


        return Math.abs(x-numberX) + Math.abs(y-numberY);
    }
}
