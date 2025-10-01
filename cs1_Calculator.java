import java.util.Scanner;
public class cs1_Calculator{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        double num1 = 0;
        double num2 = 0;
        double result = 0;
        int i = 0;

        String op = "";
        System.out.println("Welcome to the Calculator!");
        System.out.println("Type in your problem.");
        System.out.println("Choose from +, -, *, /, %, and ^");
        System.out.println("Example: 2 + 4 (A single space following each character is required)");
        System.out.println("When you are done, type 'Q' to end the program");
        while(running){
            if(scan.hasNext("Q")){
                running = false;
            } 
            else{
                num1 = scan.nextDouble();
                op = scan.next();
                num2 = scan.nextDouble();
                if(op.equals("+")){
                    result = num1 + num2;
                    System.out.println(result);
                }
                if(op.equals("-")){
                    result = num1 - num2;
                    System.out.println(result);
                }
                if(op.equals("*")){
                    result = num1 * num2;
                    System.out.println(result);
                }
                if(op.equals("/")){
                    result = num1 / num2;
                    System.out.println(result);
                }
                if(op.equals("%")){
                    result = num1 % num2;
                    System.out.println(result);
                }
                if(op.equals("^")){
                    result = Math.pow(num1, num2);
                    System.out.println(result);
                }
            }
        }
    }
    
    public static double add(double num1, double num2){
        return num1 + num2;
    }

    public static double subtract(double num1, double num2){
        return num1 - num2;
    }

    public static double multiply(double num1, double num2){
        return num1 * num2;
    }

    public static double divide(double num1, double num2){
        return num1 + num2;
    }

    public static double mod(double num1, double num2){
        return num1 % num2;
    }

    public static double powerOf(double num1, double num2){
        return Math.pow(num1, num2);
    }
}
