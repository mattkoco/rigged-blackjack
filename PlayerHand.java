public class PlayerHand extends Hand{

    public int total;
    
    public PlayerHand(int card1, int card2){
        super(card1, card2);
        total = card1 + card2;
    }
    
    public String toString() {
        return "You drew a hand that started with a " + card1 + " and a " + card2;
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
    
    // NEW METHODS!
    
    public void hit() {
        int hit = (int)(Math.random()*11)+1;
        System.out.println("You drew a " + hit);
        total+=hit;
    }
    
    public int seeHand() {
        return total;
    }
}
