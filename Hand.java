public class Hand {
    public int card1;
    public int card2;
    public int total;
    
    public Hand(int card1, int card2){
        this.card1 = card1;
        this.card2 = card2;
    }
    
    public String toString() {
        return "Hand that started with a " + card1 + " and a " + card2;
    }
    
    public boolean bust() {
        if(total > 21) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isBlackjack() {
        if(total == 21) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
        
    
}
