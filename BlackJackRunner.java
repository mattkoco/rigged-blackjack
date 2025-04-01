import java.util.Scanner;

public class BlackjackRunner {
    
    public static int drawCard(){
        return (int)(Math.random()*11)+1;
    }
    
    public static void main(String[] args) {
        
        boolean isBust = false;
        boolean stand = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to blackjack. Would you like to play? (y/n): ");
        String choice = input.nextLine();
        if (choice.equals("y")) {
            
            // draw for players hand and check if they have blackjack
            PlayerHand hand = new PlayerHand(drawCard(), drawCard());
            System.out.println(hand);
            if(hand.isBlackjack()) {
                System.out.println("You drew blackjack! You win!");
            }
            // draw for house and check if they have blackjack
            HouseHand house = new HouseHand(drawCard(), drawCard());
            System.out.println(house);
            if(house.isBlackjack()){
                System.out.println("The House drew blackjack! You lose!");
            }
            
            // while the player is under 21 points and isnt standing, play:
            while(stand == false) {
                System.out.println("What would you like to do? (hit/stand)");
                choice = input.nextLine();
                // if the player chooses to hit, draw and return total + bust
                if(choice.equals("hit")) {
                    hand.hit();
                    System.out.println("Your total is now: " + hand.seeHand());
                    System.out.println("Bust: " + hand.bust());
                    isBust = hand.bust();
                    if(isBust == true) {
                        System.out.print("You lost! Thanks for playing. Exiting...");
                        System.exit(0);
                    }
                    if(hand.isBlackjack()) {
                        System.out.println("You got blackjack! You win. Exiting...");
                        System.exit(0);
                    }
                }
                
                else if(choice.equals("stand")) {
                    System.out.println("Standing...");
                    stand = true;
                } else {
                    System.out.println("Invalid choice.");
                }
                
            
            }
            // after the player stands, 
            
            System.out.println("Drawing for the house...");
            house.houseDraw();
            System.out.println("Houses new total is: " + house.getHouseHand());
            if (house.getHouseHand() == 21) {
                System.out.println("House got blackjack! You lose. Exiting...");
                System.exit(0);
            }
            
            
            
        } else if (!input.equals("y") && !input.equals("n")) {
            System.out.println("Invalid choice; exiting...");
            System.exit(0);
        }
        
        else {
            System.out.println("Bye.");
            System.exit(0);
            
        }
        
        
        
    }
}
