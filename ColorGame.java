import java.util.Scanner;

public class ColorGame {
    
    public static Scanner scanner = new Scanner(System.in);
    public static String[] colorArray = {"Black", "Red", "Cyan", "Green", "Violet", "White"};
    public static int[] playerBets = new int[6];
    public static int playerMoney = 10;
    
    public static void colorGuide() {
        
        System.out.println("+-----+-----+-----+\n"
                         + "|Black| Red |Cyan |\n"
                         + "|  1  |  2  |  3  |\n"
                         + "|     |     |     |\n"
                         + "+-----+-----+-----+\n"
                         + "|Green|Viole|White|\n"
                         + "|  4  |  5  |  6  |\n"
                         + "|     |     |     |\n"
                         + "+-----+-----+-----+");
        
    }
    
    public static void betGuide() {
        
        System.out.println("[1] 10");
        System.out.println("[2] 100");
        System.out.println("[3] 1000");
        
    }
    
    public static void placeBet() {
        
        String placeMore = "";
        int colorChoice = 0;
        int placedBet = 0;
        int betValue = 0;
        
        do {
            
            colorGuide();
            System.out.print("Choose Color  : ");
            colorChoice = Integer.parseInt(scanner.nextLine());
            
            System.out.println();
            betGuide();
            
            do {
                
                System.out.print("Place Bet     : ");
                placedBet = Integer.parseInt(scanner.nextLine());
                
                switch(placedBet) {
                    case (1):
                        betValue = 10;
                        break;
                    case (2):
                        betValue = 100;
                        break;
                    case (3):
                        betValue = 1000;
                        break;
                }
                
            } while(playerMoney < betValue);
            
            switch(placedBet) {
                case (1):
                    playerMoney -= 10;
                    playerBets[colorChoice - 1] += 10;
                    break;
                case (2):
                    playerMoney -= 100;
                    playerBets[colorChoice - 1] += 100;
                    break;
                case (3):
                    playerMoney -= 1000;
                    playerBets[colorChoice - 1] += 1000;
                    break;
            }
            
            if(playerMoney < 10) {
                System.out.println("-------------------------------------------------");
                System.out.println("[] INSUFFICIENT BALANCE.");
                System.out.println("[] CANNOT ANYMORE BET.");
                break;
            }
            
            System.out.print("\nPlace More? [Y/N]: ");
            placeMore = scanner.nextLine().toUpperCase();
            
        } while(placeMore.equals("Y"));
        
        System.out.println("-------------------------------------------------");
        System.out.println("                    TOTAL BET                    ");
        System.out.println("-------------------------------------------------");
        showTotalBet();
        System.out.println("-------------------------------------------------");
        
    }
    
    public static void showTotalBet() {
        
        for(int i = 0; i < playerBets.length; i++) {
            System.out.print("[" + colorArray[i] + "]: ");
            System.out.println(playerBets[i]);
        }
        
    }
    
    public static void computation(int color1, int color2, int color3) {
        if(playerBets[color1] != 0) {
            playerMoney += playerBets[color1] * 2;
        }
        if(playerBets[color2] != 0) {
            playerMoney += playerBets[color2] * 2;
        }
        if(playerBets[color3] != 0) {
            playerMoney += playerBets[color3] * 2;
        }
        playerBalance();
        playAgain();
    }
    
    public static void playAgain() {
        
        playerBets = new int[6];
        if(playerMoney < 10) {
            System.out.println("[] INSUFFICIENT BALANCE.");
            System.out.println("[] CANNOT ANYMORE PLAY AGAIN.");
            System.out.println("-------------------------------------------------");
            System.exit(0);
        }
        
        String playAgain = "";
        
        System.out.print("PLAY AGAIN? [Y, N]: ");
        playAgain = scanner.nextLine().toUpperCase();
        
        if(playAgain.equals("Y")) {
            gameStart();
        } else {
            System.out.println("\n-------------------------------------------------");
            System.out.println("[] GOODBYE, PLAYER.");
            System.out.println("-------------------------------------------------");
        }
        
    }
    
    public static void gameStart() {
        
        playerBalance();
        String[] threeColors = new String[3];
        
        placeBet();
        
        int randomColor = 0;
        
        for(int i = 0; i < 3; i++) {
            randomColor = (int)(Math.random() * 6);
            threeColors[i] = randomColor + "|" + colorArray[randomColor];
        }
        
        System.out.println("                     COLORS!                     ");
        System.out.println("-------------------------------------------------");
        
        for(String printer : threeColors) {
            System.out.print("[" + printer.substring(printer.indexOf("|") + 1) + "] ");
        }
        System.out.println();
        
        computation(Integer.parseInt(threeColors[0].substring(0, threeColors[0].indexOf("|"))), 
                    Integer.parseInt(threeColors[1].substring(0, threeColors[0].indexOf("|"))), 
                    Integer.parseInt(threeColors[2].substring(0, threeColors[0].indexOf("|"))));
        
    }
    
    public static void playerBalance() {
        
        System.out.println("-------------------------------------------------");
        System.out.println("                     BALANCE                    ");
        System.out.println("-------------------------------------------------");
        System.out.println("Your Balance Is: " + playerMoney);
        System.out.println("-------------------------------------------------");
        
    }
    
    public static void main(String[] args) {
        
        gameStart();
        
    }
}