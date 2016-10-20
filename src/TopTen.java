import java.util.Arrays;

public class TopTen {
    Player[] myTopTenList = new Player[10];

    public TopTen(Player[] myTopTenList) {
        this.myTopTenList = myTopTenList;
    }

    public Player[] getMyTopTenList() {
        return myTopTenList;
    }

    public void setMyTopTenList(Player[] myTopTenList) {
        this.myTopTenList = myTopTenList;
    }

    public void openTopTen(){

    }

    public void saveTopTen(){

    }

    public void sort(){

    }


    @Override
    public String toString() {
        return "TopTen{" +
                "myTopTenList=" + Arrays.toString(myTopTenList) +
                '}';
    }
}
