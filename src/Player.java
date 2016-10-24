
public class Player {
    String myName;
    int myScore;
    Hand playerHand = new Hand();

    public Player(String myName, int myScore) {
        super();
        this.myName = myName;
        this.myScore = myScore;

    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }

    @Override
    public String toString() {
        return myName + ", " + myScore;
    }
}
