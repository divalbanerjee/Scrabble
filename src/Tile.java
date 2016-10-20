

public class Tile {
    String myLetter;
    int myPoints;
    int myFrequency;

    public Tile(String myLetter, int myPoints) {
        super();
        this.myLetter = myLetter;
        this.myPoints = myPoints;
    }

    public String getMyLetter() {
        return myLetter;
    }

    public void setMyLetter(String myLetter) {
        this.myLetter = myLetter;
    }

    public int getMyPoints() {
        return myPoints;
    }

    public void setMyPoints(int myPoints) {
        this.myPoints = myPoints;
    }

    @Override
    public String toString() {
        return "[" + myLetter + ", " + myPoints + "]";
    }





}
