public class HouseHand extends Hand {
    
    public int total;
    
    public HouseHand(int card1, int card2){
        super(card1, card2);
        total = card1 + card2;
    }
    
    public String toString() {
        return "The house started with a " + card1 + " and a " + card2;
    }
    
    public int getHouseHand() {
        return total;
    }
    
    // rigged draw function for the house
    public void houseDraw() {
        int houseNeeds = 21 - total;
        houseNeeds -= (int)(Math.random()*6)+1;
        System.out.println("House drew: " + houseNeeds);
        total += houseNeeds;
    }
    
}
