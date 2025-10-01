import java.util.*;
import java.util.Random;
public class Abt_RPS{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); 
        Random rand = new Random(); 
        boolean playing = true;
        String userInput = "";
        int userChoice = 0;
        int compChoice = 0;
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        final int LIZARD = 4;
        final int SPOCK = 5;
        int wins = 0;
        int losses = 0;
        int ties = 0;

        System.out.println("Hello! Welcome to Rock, Paper, Scissors, Lizard, Spock!"); 
        while(playing){
            System.out.println("Wait while I choose an option...");
            compChoice = rand.nextInt(4) + 1;
            System.out.println("Alright! Go ahead and choose Rock, Paper, Scissors, Lizard, or Spock!");
            userInput = scan.nextLine(); 
            if(userInput.equalsIgnoreCase("Rock") ){            
                userChoice = ROCK;
            }
            if(userInput.equalsIgnoreCase("Paper") ){            
                userChoice = PAPER;
            }
            if(userInput.equalsIgnoreCase("Scissors") ){            
                userChoice = SCISSORS;
            }
            if(userInput.equalsIgnoreCase("Lizard") ){            
                userChoice = LIZARD;
            }
            if(userInput.equalsIgnoreCase("Spock") ){            
                userChoice = SPOCK;
            }

            if(userChoice == ROCK){
                if(compChoice == ROCK){
                    System.out.println("We tied! We both chose rock!");
                    ties ++;
                }
                if(compChoice == PAPER){
                    System.out.println("You lose! My paper covers your rock!");
                    losses ++;
                }
                if(compChoice == SCISSORS){
                    System.out.println("You win! Your rock crushes my scissors!");
                    wins ++;
                }
                if(compChoice == LIZARD){
                    System.out.println("You win! Your rock crushes my lizard!");
                    wins ++;
                }
                if(compChoice == SPOCK){
                    System.out.println("You lose! My spock vaporizes your rock!");
                    losses ++;
                }
            }
            if(userChoice == PAPER){
                if(compChoice == ROCK){
                    System.out.println("You win! Your paper covers my rock!");
                    wins ++;
                }
                if(compChoice == PAPER){
                    System.out.println("We tied! We both chose paper!");
                    ties ++;
                }
                if(compChoice == SCISSORS){
                    System.out.println("You lose! My scissors cut your paper!");
                    losses ++;
                }
                if(compChoice == LIZARD){
                    System.out.println("You lose! My lizard eats your paper!");
                    losses ++;
                }
                if(compChoice == SPOCK){
                    System.out.println("You win! Your paper disproves of my spock!");
                    wins ++;
                }
            }
            if(userChoice == SCISSORS){
                if(compChoice == ROCK){
                    System.out.println("You lose! My rock crushes your scissors!");
                    losses ++;
                }
                if(compChoice == PAPER){
                    System.out.println("You win! Your scissors cut my paper!");
                    wins ++;
                }
                if(compChoice == SCISSORS){
                    System.out.println("We tied! We both chose scissors!");
                    ties ++;
                }
                if(compChoice == LIZARD){
                    System.out.println("You win! Your scissors decapitate my lizard!");
                    wins ++;
                }
                if(compChoice == SPOCK){
                    System.out.println("You lose! My spock smashes your scissors!");
                    losses ++;
                }
            }
            if(userChoice == LIZARD){
                if(compChoice == ROCK){
                    System.out.println("You lose! My rock crushes your lizard!");
                    losses ++;
                }
                if(compChoice == PAPER){
                    System.out.println("You lose! My lizard eats your paper!");
                    losses ++;
                }
                if(compChoice == SCISSORS){
                    System.out.println("You win! Your scissors decapitate my lizard!");
                    wins ++;
                }
                if(compChoice == LIZARD){
                    System.out.println("We tied! We both chose lizard!");
                    ties ++;
                }
                if(compChoice == SPOCK){
                    System.out.println("You lose! My spock poisons your lizard!");
                    losses ++;
                }
            }
            if(userChoice == SPOCK){
                if(compChoice == ROCK){
                    System.out.println("You win! Your spock vaporizes my rock!");
                    wins ++;
                }
                if(compChoice == PAPER){
                    System.out.println("You lose! My paper disproves of your spock!");
                    losses ++;
                }
                if(compChoice == SCISSORS){
                    System.out.println("You win! Your spock smashes my scissors!");
                    wins ++;
                }
                if(compChoice == LIZARD){
                    System.out.println("You lose! My lizard poisons your spock!");
                    losses ++;
                }
                if(compChoice == SPOCK){
                    System.out.println("We tied! We both chose spock!");
                    ties ++;
                }
            }
            System.out.println("Would you like to play again");
            userInput = scan.nextLine();
            if(userInput.equalsIgnoreCase("No")){
                playing = false;
                System.out.println("Thanks for Playing!");
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
            }
            compChoice = rand.nextInt(4) + 1;
        }
    }
}