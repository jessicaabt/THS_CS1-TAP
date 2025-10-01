import java.util.*;
import java.time.*;
import java.time.format.*;
public class Abt_ChatBot{
    public static void main(String[] args){
        String userInput = "";
        boolean chatting = true;
        Scanner scan = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        
        System.out.println("Hi! Welcome to the chatbot.");
        userInput = scan.nextLine();
        System.out.println("Do you prefer Proper English or Snobby Teenage Vernacular");
        userInput = scan.nextLine();
        if(userInput.equalsIgnoreCase("Proper English")){
            System.out.println("Magnificent! Allow me to introduce myself.");
            System.out.println("My name is Abigail, and I am fond of questionnaires!");
            System.out.println("Try asking a question! When you're done, say Goodbye.");
            System.out.println("Don't forget, with proper English, we always use puncuation.");
            while(chatting){
                userInput = scan.nextLine();
                if(userInput.equalsIgnoreCase("What's Up?")){
                    System.out.println("Nothing, just analyzing my copy of Pride and Prejudice!");
                }
                else if(userInput.equalsIgnoreCase("What's the Date?")){
                    System.out.println(date.format(dateFormat));
                }
                else if(userInput.equalsIgnoreCase("What's your favorite color?")){
                    System.out.println("I've always held a passion for the endless hues of purple.");
                }
                else if(userInput.equalsIgnoreCase("What's your favorite sports team?")){
                    System.out.println("When I have free time, I love to sip tea while watching the Wimbleton Championships");
                }
                else if(userInput.equalsIgnoreCase("What's your favorite video game?")){
                    System.out.println("I personally find video games outrageous, but enjoy mindsweeper every once in a while");
                }
                else {
                    if(userInput.equalsIgnoreCase("Goodbye.")){
                        System.out.println("Farewell!");
                        System.exit(0);
                    }
                    System.out.println("I apologize, but I do not understand your question. Would you mind rephrasing it?");
                }
            } 
        } //hey guidry if you see this, you're cool! its an easter egg! hehe
        else if(userInput.equalsIgnoreCase("Snobby Teenage Vernacular")){
            System.out.println("cool, so im bored, lets gooo!");
            System.out.println("my name is vanessa, just ask me some questions or something");
            System.out.println("when ur done say bye and yeah thats all");
            while(chatting){
                userInput = scan.nextLine();
                if(userInput.equalsIgnoreCase("What's Up?")){
                    System.out.println("trying to find the nearest party");
                    System.out.println("anyways did you do last nights hw? omg you did.. can i copy it? thanks :))))");
                }
                else if(userInput.equalsIgnoreCase("What's the Date?")){
                    System.out.println(date.format(dateFormat));
                }
                else if(userInput.equalsIgnoreCase("What's your favorite color?")){
                    System.out.println("uh pink, duh?");
                }
                else if(userInput.equalsIgnoreCase("What's your favorite sports team?")){
                    System.out.println("definitely cheer because im like the head captain, obviously");
                }
                else if(userInput.equalsIgnoreCase("What's your favorite video game?")){
                    System.out.println("i think tiktok, maybe instagram too.");
                    System.out.println("...");
                    System.out.println("oh you meant like games... ew... never");
                    
                }
                else {
                    if(userInput.equalsIgnoreCase("bye")){
                        System.out.println("bye girlll!!!");
                        System.exit(0);
                    }
                    System.out.println("um what. i didn't get that..");
                }
            } 
        }
    } 
}