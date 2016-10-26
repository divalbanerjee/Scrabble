import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class TopTen {
    Player[] myTopTenList = new Player[1000];
    int playerCount = 0;

    public TopTen() {
    }

    public Player[] getMyTopTenList() {
        return myTopTenList;

    }

    public void topPlayers(Player newPlayer){
        int i = 0;
        int replacePos = 0;
        Player tempPlayer = new Player("",0);
        for(i=1; i<10;i++){
            if(newPlayer.myScore > this.myTopTenList[i].getMyScore()){
                playerCount++;
                this.myTopTenList[playerCount] = newPlayer;
            }
        }
        sort();
    }

    public void setMyTopTenList(Player[] myTopTenList) {
        this.myTopTenList = myTopTenList;
    }

    public void openTopTen() throws IOException{
        Scanner reader = new Scanner(new File("topten.txt"));
        int count = 1;
        while(reader.hasNext()){
            count++;
            System.out.println(count);
            this.myTopTenList[count].setMyName(reader.next());
            this.myTopTenList[count].setMyScore(reader.nextInt());
        }
        this.playerCount = count;
    }

    public void saveTopTen(){

    }

    public void sort(){
        Player tempPlayer = new Player("",0);
        int i = 0;
        int c = 0;


        for(i = 1; i < 9; i++){
           for(c = i+1; c < 10; i++){
               if(this.myTopTenList[i].getMyScore() < this.myTopTenList[c].getMyScore()) {
                   tempPlayer = this.myTopTenList[i];
                   this.myTopTenList[i] = this.myTopTenList[c];
                   this.myTopTenList[c] = tempPlayer;
               }
           }
        }
    }


    @Override
    public String toString() {
        return "TopTen{" +
                "myTopTenList=" + Arrays.toString(myTopTenList) +
                '}';
    }
}
