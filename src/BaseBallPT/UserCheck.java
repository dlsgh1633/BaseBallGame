package BaseBallPT;

public class UserCheck {
    int strike;
    int ball;
    int out;

    public void check(int com[], int user[]){
        strike = 0;
        ball = 0;
        out = 0;

        for(int i=0; i <com.length; i++){
            for(int j=0; j < user.length; j++){
                    if(com[i] == user[j]){
                        if(i == j){
                            strike ++;
                        }
                        else {
                            ball++;
                        }
                    }
                }
        }
        if(strike==0 && ball ==0){
            out ++;

        }
    }
    public String getValue(){
        return strike+""+ball+""+out;
    }

}
