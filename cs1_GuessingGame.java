import java.util.Scanner;
import java.util.Random;
public class Abt_GuessingGame{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        Random rand = new Random();
        int answer = rand.nextInt(1001);
        boolean looping = true;
        int tries = 0;
        
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I am thinking of a random number between 0 and 1000!");
        while(looping){
            System.out.println("Enter your guess here:");
            int guess = scan.nextInt();
            if(guess < answer){
                System.out.println("Your guess was too low, try again!");
                tries++;
            }
            else if(guess > answer){
                System.out.println("Your guess was too high, try again");
                tries++;
            }
            else if(guess == answer){
                System.out.println("Congrats! You guessed the right number.");
                System.out.println("Tries Taken: " +tries);
                System.out.println("Would you like to play again");
                scan.nextLine();
                userInput = scan.nextLine();
                if(userInput.equalsIgnoreCase("No")){
                    looping = false;
                }
                answer = rand.nextInt(1001);
                tries = 0;
            }
        }
        System.out.println("Thanks for Playing!");
        System.exit (0);
    }
}