
public class Hand {
    Tile[] myHand = new Tile[7];

    public Hand(Tile[] myHand) {
        this.myHand = myHand;
    }

    public Tile getTile(int pos){
        return this.myHand[pos];
    }
    public void setTile(Tile tile, int pos){

    }

}
