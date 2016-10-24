
public class Hand {
    Tile[] myHand = new Tile[7];
    int length = 0;

    public Hand(Tile[] myHand) {
        this.myHand = myHand;
    }

    public Tile getTile(int pos){
        return this.myHand[pos];
    }
    public int getLength(){
        return this.length;
    }

    public void setTile(Tile tile, int pos){
        this.myHand[pos] = tile;
    }
    public String getWord(){
        String enteredWord = "";
        int c = 0;
        int i = 0;
        for(c = 0; c <= this.getLength(); c++){
            enteredWord = enteredWord+ this.myHand[c];
        }
        return enteredWord;
    }
    public void addTile(Tile tile){
        length++;
        if(length <= 7){
            this.myHand[length] = tile;
        }
    }
}
