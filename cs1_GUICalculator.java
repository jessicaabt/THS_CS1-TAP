/*

This was the first big GUI project we worked on and, with respect
to the cs1_Calculator.java, it grew a LOT!!!

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class cs1_GUICalculator implements ActionListener{
    //data
    double number;
    double memory;
    String operator;

    String[] names = {"←", "x^y", "√", "%", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", "Clr", "+"};

    //GUI components
    JFrame frame;
    JPanel displayPanel;
    JLabel displayLabel;
    JPanel buttonPanel;
    JButton[] button = new JButton[20];

    public static void main(String[] args){
        new cs1_GUICalculator();
    }

    public cs1_GUICalculator(){
        frame = new JFrame("Calculator");
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());
        displayPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(5,4));

        displayLabel = new JLabel("0.0");
        displayLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        frame.setBackground(new Color(102,102,102));
        displayPanel.setBackground(new Color(133,133,133));
        buttonPanel.setBackground(new Color(102,102,102));
        displayLabel.setBackground(new Color(133,133,133));

        displayLabel.setForeground(new Color(238,238,238));

        for(int i = 0; i < button.length; i++){
            button[i] = new JButton();
            button[i].setText(names[i]);
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 40));
            button[i].addActionListener(this);
            button[i].setBackground(new Color(102,102,102));
            button[i].setForeground(new Color(238,238,238));
            button[i].setBorderPainted(false);
            buttonPanel.add(button[i], BorderLayout.CENTER);
        }

        displayPanel.add(displayLabel, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button[0]){
            String s = "" + number;
            if(s.indexOf('E') != -1){
                number /= 10;
            }
            else{
                for(int i = s.length() - 1; i >= 0; i--){
                    if((s.charAt(i) == '.') || s.charAt(i) == '0' && i > s.indexOf('.')){
                        continue;
                    }
                    else{
                        s = s.substring(0,i) + s.substring(i+1);
                        break;
                    }
                }
                number = Double.parseDouble(s);
            }
             displayLabel.setText("" + number);
        }
        if(e.getSource() == button[1]){
            memory = number;
            number = 0;
            operator = "x^y";
        }
        if(e.getSource() == button[2]){
            number = Math.sqrt(number);
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[3]){
            memory = number;
            number = 0;
            operator = "%";
        }
        if(e.getSource() == button[4]){
            number = number * 10 + 7;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[5]){
            number = number * 10 + 8;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[6]){
            number = number * 10 + 9;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[7]){
            memory = number;
            number = 0;
            operator = "/";
        }
        if(e.getSource() == button[8]){
            number = number * 10 + 4;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[9]){
            number = number * 10 + 5;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[10]){
            number = number * 10 + 6;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[11]){
            memory = number;
            number = 0;
            operator = "*";
        }
        if(e.getSource() == button[12]){
            number = number * 10 + 1;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[13]){
            number = number * 10 + 2;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[14]){
            number = number * 10 + 3;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[15]){
            memory = number;
            number = 0;
            operator = "-";
        }
        if(e.getSource() == button[16]){
            number = number * 10 + 0;
            displayLabel.setText("" + number);
        }
        if(e.getSource() == button[17]){
            if(operator == "+"){
                displayLabel.setText("" + (memory + number));
                number = (memory + number);
            }
            if(operator == "-"){
                displayLabel.setText("" + (memory - number));
                number = (memory - number);
            }
            if(operator == "*"){
                displayLabel.setText("" + (memory * number));
                number = (memory * number);
            }
            if(operator == "/"){
                displayLabel.setText("" + (memory / number));
                number = (memory / number);
            }
            if(operator == "%"){
                displayLabel.setText("" + (memory % number));
                number = (memory % number);
            }
            if(operator == "x^y"){
                displayLabel.setText("" + Math.pow(memory, number));
                number = Math.pow(memory, number);
            }
        }
        if(e.getSource() == button[18]){
            number = 0.0;
            memory = 0.0;
            displayLabel.setText("0.0");
        }
        if(e.getSource() == button[19]){
            memory = number;
            number = 0;
            operator = "+";
        }
    }
}
