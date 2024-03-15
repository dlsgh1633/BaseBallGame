package BaseBallPT;

public class Rcom {
    int com[];

    public Rcom(){

            com = new int[3];

            com[0] =(int)(Math.random()*9+1);
            com[1] =(int)(Math.random()*9+1);

            while (com[0] == com[1]){
                com[1] = (int)(Math.random()*9+1);

            }
            com[2] = (int)(Math.random()*9+1);

            while (com[0] == com[2] || com[1] == com[2]){
                com[2] = (int)(Math.random()*9+1);

            }
    }

    public int[] getCom() { //set은 굳이 필요 x
        return com;
    }
}
