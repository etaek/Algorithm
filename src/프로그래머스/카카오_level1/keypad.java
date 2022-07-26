package 프로그래머스.카카오_level1;

public class keypad {

    static int key[][]=new int[4][3];

    public static int acc(int num,int target){
        int x=0;
        int y=0;
        int tx=0;
        int ty=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(key[i][j]==target){
                    tx=i;
                    ty=j;
                }
                if(key[i][j]==num){
                    x=i;
                    y=j;
                }
            }
        }

        int result=Math.abs(tx-x)+Math.abs(ty-y);

        return result;

    }

    public static void main(String[] args) {
        int []numbers={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand ="left";
        String answer="";


        key[3][1]=0;
        int num=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(i==3&&j==1) continue;
                key[i][j]=num;
                num++;
            }
        }

        int left=10;
        int right=11;

        for(int i=0;i<numbers.length;i++){
            int number=numbers[i];
            if(number==1||number==4||number==7){
                answer+="L";
                left=number;
            }
            else if(number==3||number==6||number==9){
                answer+="R";
                right=number;
            }
            else{
                int lnum=acc(left,number);
                int rnum=acc(right,number);

                if(lnum<rnum){
                    answer+="L";
                    left=number;
                }
                else if(lnum>rnum){
                    answer+="R";
                    right=number;
                }
                else{
                    System.out.println(1);
                    if(hand.equals("right")){
                        answer+="R";
                        right=number;
                    }else{
                        answer+="L";
                        left=number;
                    }
                }

            }
            System.out.println(number+":"+left+","+right+","+answer);
        }

        System.out.println(answer);

    }

}
