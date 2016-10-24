
public class Hand {
    Tile[] myHand = new Tile[8];
    int length = 0;

    public Hand() {
        this.myHand = new Tile[8];
    }

    public Tile getTile(int pos){
        Tile returned = new Tile(".",0);
        if(pos<= this.length) {
            returned = this.myHand[pos];
        }
        return returned;
    }
    public int getLength(){
        return this.length;
    }

    public void setTile(Tile tile, int pos){
        this.myHand[pos] = tile;
    }
    public String getWord(){
        String enteredWord = new String();
        int c = 0;
        //int i = 0;
        for(c = 1; c <= this.getLength(); c++){
            enteredWord = enteredWord+ this.myHand[c].myLetter;
        }
        return enteredWord;
    }
    public void addTile(Tile tile){
        this.length++;
        System.out.println(this.length);
        if(this.length <= 7){
            this.myHand[this.length] = tile;
        }
    }


}
