

public class Tile {
    String myLetter;
    int myPoints;
    int myFrequency;
    boolean Used;
    boolean visibility = true;

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

    public void setUsage(Boolean Usage){this.Used = Usage;}

    public void setVisibility(Boolean visible){this.visibility= visible;}

    @Override
    public String toString() {
        return "[" + myLetter + ", " + myPoints + "]";
    }





}
